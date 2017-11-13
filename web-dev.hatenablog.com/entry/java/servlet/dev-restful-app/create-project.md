---
Title: Servletアプリ開発：2.プロジェクト作成
Category:
- Java
Date: 2017-11-09T07:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/create-project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315254264
---

サーブレットアプリ（RESTful API）を開発するために、プロジェクトのディレクトリ構成やビルドファイルを作成していきます。

※ アプリの概要は、以下のリンク先に書いてあります。

[Servletアプリ開発：1.概要](/entry/java/servlet/dev-restful-app/overview)


## ディレクトリ構成
事前に Maven プロジェクトのディレクトリ構成を作成しておきます。

```
servlet-rest
└─src
    └─main
          └─java
```

`src/main/java` に、サーブレットなどのプロダクトコードを置いてきます。


## ビルドファイルの作成
次の内容で `pom.xml` を作成します。

`servlet-rest/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.domain</groupId>
  <artifactId>servlet-rest</artifactId>
  <version>1.0.0</version>
  <packaging>war</packaging>

  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.8.1</version>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <build>
    <finalName>${project.artifactId}</finalName>
    <plugins>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.1.0</version>
      </plugin>
      <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.4.6.v20170531</version>
      </plugin>
    </plugins>
  </build>
</project>
```

XML のタグ要素ごとに、詳細を書いていきます。

### packaging
サーブレットアプリなので、Servletコンテナにも配備できるように packaging を war にしています。

### dependencies
`javax.servlet-api` を `provided` にして、アプリの war に梱包されないようにしています。`gson` は JSON のレスポンスを返したりするときに使います。

### plugins
今回は web.xml を使わないので、`maven-war-plugin` を `3.1.0` にしてます。warプラグインのバージョンが古いと、web.xml がなくてビルドエラーになったりします。

`jetty-maven-plugin` を使うと、`mvn jetty:run` でコンテナ（Jetty）が起動してサーブレットアプリを実行することができます。動作確認で使うため定義しています。


## 補足. Maven のバージョンについて
ブログ執筆時は、Maven 3.5.0 を使いました。
