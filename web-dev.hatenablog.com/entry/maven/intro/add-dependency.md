---
Title: Maven入門：4.依存性の追加
Category:
- Java
Date: 2017-06-28T08:42:26+09:00
URL: https://web-dev.hatenablog.com/entry/maven/intro/add-dependency
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812274689926
---

Maven の `pom.xml` を編集して、依存性（jar）を追加してみようと思います。依存性を追加すると、Maven のビルドで jar がクラスパスに追加されます。

今回は例として、ログ関連の jar（`slf4j-api`, `logback-classic`）を追加してみます。


## 手順1. pom.xml の編集
記事「[2.エンコーディングとコンパイラの設定](/entry/maven/intro/encoding-and-javac-version)」の `pom.xml` を編集して、`dependency` を２つ追加します。

`my-app/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycompany.app</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0-SNAPSHOT</version>
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
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```

`junit` の上に追加しています。それ以外の箇所は変更なしです。


## 手順2. App クラスの編集
プロジェクトを作成したときにできてた `App` クラスを編集します。

`my-app/src/main/java/com/mycompany/app/App.java`

```java
package com.mycompany.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
  private static final Logger log = LoggerFactory.getLogger(App.class);
  public static void main(String[] args) {
    log.info("Hello!");
    System.out.println("Hello World!");
  }
}
```

以下の行を追加しています。

- `private static final Logger log...`
- `log.info("Hello!");`


## 手順3. 実行
アプリを実行すると、次のように表示されます。

```
08:07:23.818 [main] INFO com.mycompany.app.App - Hello!
Hello World!
```

１行目が、`slf4j-api` と `logback-classic` を使って出力されたログになります。
