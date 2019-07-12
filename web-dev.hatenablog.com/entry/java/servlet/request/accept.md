---
Title: Servlet：リクエストの受信
Category:
- Java
Date: 2017-09-04T11:03:55+09:00
URL: https://web-dev.hatenablog.com/entry/java/servlet/request/accept
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812294837342
---

Java のサーブレットで、リクエストを受け付ける方法を書いていきます。


## 手順1. プロジェクトの作成
ルートディレクトリを `ssjp` とする Maven プロジェクトを作成します。

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

- `src/main/java`: Java コード（Servlet など）を配置
- `src/main/webapp`: 静的コンテンツなどを配置
- `src/main/webapp/WEB-INF`: web.xml などを配置


## 手順2. pom.xml の作成
以下の内容の `pom.xml` を作成します。

`ssjp/pom.xml`

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

Maven でサーブレットコンテナを起動できるように、`build` で Jetty Plugin を定義しています。


## 手順3. サーブレットの作成
HTTPメソッド `GET`, `POST`, `PUT`, `DELETE` を受信して、文字列を標準出力するサーブレットを作成します。

`ssjp/src/main/java/ssjp/servlet/AcceptServlet.java`

```java
package ssjp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/accept")
@SuppressWarnings("serial")
public class AcceptServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Get.");
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Post.");
  }
  public void doPut(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Put.");
  }
  public void doDelete(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Delete.");
  }
}
```

`@WebServlet` を付けて、`/req/accept` のリクエストを処理できるようにしています。


## 手順4. 動作確認
次のコマンドでコンテナ（Jetty Maven Plugin）を起動します。

```
ssjp> mvn jetty:run
```

起動したらブラウザで `http://localhost:8080/req/accept` を開いて、`Process Http Get.` が標準出力されれば成功です。（※ブラウザには何も表示されません。）


## 補足1. GET（doGet）以外の確認
ブラウザで URL直打ちすると `GET` メソッドになるため、サーブレットの `doGet` が実行されます。他のメソッドを確認する場合は、`curl` などを使うと便利です。

```
> curl -X POST http://localhost:8080/req/accept
```

上のコマンドだと、メソッドは `POST` になります。


## 補足2. サーブレットのメソッドについて
[サーブレット 3.1 の仕様書（PDF）](http://download.oracle.com/otn-pub/jcp/servlet-3_1-fr-spec/servlet-3_1-final.pdf) には、以下のように書かれています。

- 一般的に、開発者は `doGet` と `doPost` を実装することになる。
- `doPut`, `doDelete` を実装することで、HTTP 1.1 のクライアントをサポートすることができる。
- 他には `doHead`, `doOptions`, `doTrace` などがあり、それぞれ `HEAD`, `OPTIONN`, `TRACE` といった HTTP メソッドを受け付ける。
- サーブレットの `service` メソッドは全てのリクエストに対して実行される。`service` メソッドから、`doGet`, `doPost` などが呼び出される。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
