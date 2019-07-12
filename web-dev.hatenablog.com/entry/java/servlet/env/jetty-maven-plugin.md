---
Title: Servlet API：動作環境構築（Jetty Maven Plugin）
Category:
- Java
Date: 2017-08-02T10:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/servlet/env/jetty-maven-plugin
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812285817528
---

Jetty の Maven Plugin を使って、サーブレットを動作させる環境を作ってみます。


## 手順1. プロジェクトの作成
ディレクトリ階層はこんな感じで作成します。ルートディレクトリは例として `ssjp` にしています。

```
ssjp/
  - pom.xml
  - src/
    - main/
      - java/
      - webapp/
        - WEB-INF/
        ...
```

ディレクトリの大まかな役割は以下の通りです。

- `src/main/java`: Servlet のコード（Java コード）を配置
- `src/main/webapp`: 静的コンテンツやテンプレートなどを配置
- `src/main/webapp/WEB-INF`: web.xml などを配置

`pom.xml` は次のような内容にします。一番下の `build` で Jetty Plugin を定義しています。

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>ccom.domain</groupId>
  <artifactId>ssjp</artifactId>
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
    <finalName>ssjp</finalName>
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

War を作成できるように `packaging` を `war` にしています。詳細は、記事「[Maven：warの作成](/entry/maven/plugin/war)」を参照して頂けると嬉しいです。

また、JSON を使えるように Gson を依存性に追加しています。


## 手順2. 静的コンテンツの作成
Jetty Plugin の動作確認のため、静的コンテンツを追加しておきます。

`ssjp/src/main/webapp/index.html`

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"></head>
<body><p>Index</p></body>
</html>
```


## 手順3. 起動
`mvn` コマンドで Jetty を起動します（Maven は 3.5.0 を使いました）。

```
ssjp> mvn jetty:run
```


## 手順4. 確認
起動したら `http://localhost:8080/index.html` を開いて、上の HTML が返ってくることを確認します。


## ソースコード
[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
