---
Title: 組込みTomcat：サーバーの起動
Category:
- Java
Date: 2018-03-29T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/tomcat/start-embedded-server
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971630173965
---

組込みTomcat（Embedded Tomcat）にサーブレットを追加して起動する方法を書いていきます。また、Tomcat が静的コンテンツ（html, js, css, etc）を返せるように設定していきます。


## 1. プロジェクトの作成
Maven プロジェクトとして作成していきます。ディレクトリ階層の例は以下の通りです。

```
sample-tomcat/
  - src/main/java/
  - src/main/resources/
  - pom.xml
```

pom.xml に以下の依存性を追加します。

```
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-core</artifactId>
  <version>8.5.16</version>
</dependency>
```


## 2. サーブレットの作成
サンプルとして、簡単な文字列を返すサーブレットを作成します。

`sample-tomcat/src/main/java/sample/tomcat/HelloServlet.java`

```java
package sample.tomcat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
  public void doGet(
    HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
      res.setContentType("text/plain;charset=utf-8");
      res.getWriter().println("こんにちは！");
    }
}
```


## 3. 静的コンテンツの作成
サンプルの HTML を作成しておきます。

`sample-tomcat/src/main/resources/public/index.html`

```html
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<p>組込み Tomcat</p>
</body>
</html>
```


## 4. メインクラスの作成
組込み Tomcat を設定して、起動するクラスを作成します。

`sample-tomcat/src/main/java/sample/tomcat/Main.java`

```java
package sample.tomcat;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

public class Main {
  public static void main(String[] args) throws Exception {
    Tomcat cat = new Tomcat();
    cat.setPort(8080);
    cat.setHostname("0.0.0.0");
    File docDir = new File("src/main/resources/public");
    Context ctx = cat.addContext(
      "", docDir.getAbsolutePath()
    );
    Tomcat.addServlet(ctx, "default", new DefaultServlet());
    ctx.addServletMappingDecoded("/", "default");
    ctx.addWelcomeFile("index.html");
    Tomcat.addServlet(ctx, "app", new HelloServlet());
    ctx.addServletMappingDecoded("/app/*", "app");
    cat.start();
    cat.getServer().await();
  }
}
```

静的コンテンツ用の `DefaultServlet` と、上の `HelloServlet` を追加してます。


## 5. 起動・動作確認
上のプロジェクトを、Eclipse などにインポートして Main クラスを実行します。

ローカルの `8080` で起動するので、以下の URL にアクセスして確認します。

- サーブレット -> `http://localhost:8080/app/hello`
- 静的コンテンツ -> `http://localhost:8080/ (or /index.html)`

