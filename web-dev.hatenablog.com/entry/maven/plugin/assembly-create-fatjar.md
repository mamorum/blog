---
Title: Maven：fatjarの作成
Category:
- Java
Date: 2017-07-03T08:35:57+09:00
URL: https://web-dev.hatenablog.com/entry/maven/plugin/assembly-create-fatjar
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812276276211
---

Maven の [Assembly Plugin](http://maven.apache.org/plugins/maven-assembly-plugin/) を使って、fatjar を作成する方法を書いていきます。


## 手順1. プロジェクトの作成
プロジェクトのルートディレクトリ（例：`fjs`）を作成して、その下に `pom.xml` を用意します。

`fjs/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>fjs</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.21</version>
    </dependency>
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.7</version>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.0.0</version>
        <configuration>
          <finalName>${project.artifactId}</finalName>
          <archive>
            <manifestEntries>
              <Built-By>mvn</Built-By>
              <Main-Class>fjs.Main</Main-Class>
              <Implementation-Version>${project.version}</Implementation-Version>
            </manifestEntries>
          </archive>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
          <appendAssemblyId>false</appendAssemblyId>
          <attach>false</attach>
        </configuration>
        <executions>
          <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals><goal>single</goal></goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
```

ログ関連の依存性を追加していて、それらも fatjar に梱包されます。


## 手順2. アプリの作成
以下の Java クラスを作成します。

`fjs/src/main/java/fjs/Main.java`

```java
package fjs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger log = LoggerFactory.getLogger(Main.class);
  public static void main(String[] args) {
    log.info(
      Main.class.getPackage().getImplementationVersion()
    );
  }
}

```

`MANIFEST.MF` の `Implementation-Version` をログ出力するようにしています。


## 手順3. jar の作成
`mvn` コマンドで jar を作成します。

```
fjs > mvn package
```

jar は２つ作成されます。fatjar の名前は、`pom.xml` の `finalName` で指定したものになっています。

- `target/fjs.jar`: fatjar
- `target/fjs-1.0.0.jar`: 普通のjar

fatjar のマニフェストは、次の内容になっていました。

`MANIFEST.MF`

```
Manifest-Version: 1.0
Implementation-Version: 1.0.0
Built-By: mvn
Created-By: Apache Maven 3.5.0
Build-Jdk: 1.8.0_131
Main-Class: fjs.Main
```


## 手順4. 実行
fatjar を実行するとログが出力されました。

```
fjs > java -jar target/fjs.jar
19:47:00.168 [main] INFO fjs.Main - 1.0.0
```


## 補足
Maven の [Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/) でも fatjar を作れるみたいですが、ちょっとエラー（警告？）が出たりしたので Assembly Plugin を使うことにしています。


## コード
[fjs - GitHub](https://github.com/mamorum/blog/tree/master/code/maven/fjs)
