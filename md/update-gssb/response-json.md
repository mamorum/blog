---
Title: SpringBoot入門：JSONを返す
Date: 2017.02.15
---

Spring Boot を使って、サーバサイドから JSON を返却する方法を紹介します。

次の URL にリクエストすると、

```txt
http://localhost:8080/hello
```

次のレスポンスを返す例を書いていきます。

```json
{"message":"Hello, World!"}
```


## 環境・ツール
- JDK 1.8 以上
- Maven 3.0 以上（or Gradle 等）


## 手順1. ビルドファイルの作成
Maven の XML を作成します。アプリのルートディレクトリは `gssb` としています。


`gssb/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>gssb</artifactId>
  <version>1.0.0</version>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.1.RELEASE</version>
  </parent>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```


## 手順2. コントローラの作成
リクエストを受け付けて、JSON を返すクラスです。

`gssb/src/main/java/gssb/controller/HelloController.java`

```java
package gssb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // JSON を返すコントローラに付与。
public class HelloController {

  // リクエスト /hello に対して実行されるメソッド。
  @RequestMapping("/hello")
  public Map<String, String> hello() {
    return Collections.singletonMap("message", "Hello, World!");
  }
}
```


## 手順3. 起動クラスの作成
SpringBoot のアプリを起動するクラスを作成します。

`gssb/src/main/java/gssb/App.java`

```java
package gssb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
```


## 手順4. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
（省略）
・・・Started App in 3.865 seconds (JVM running for 8.989)
```


## 手順5. 確認
`http://localhost:8080/hello` にアクセスして、冒頭の JSON が返ってくれば成功です。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
