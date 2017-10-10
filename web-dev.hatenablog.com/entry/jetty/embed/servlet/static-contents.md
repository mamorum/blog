---
Title: 組込Jetty：静的コンテンツを返す
Category:
- Java
Date: 2017-10-10T15:35:42+09:00
URL: http://web-dev.hatenablog.com/entry/jetty/embed/servlet/static-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812306582897
---

Jetty の `DefaultServlet` クラスを使うと、要求元に静的コンテンツを返すことができます。今回は、組み込み Jetty（Embedded Jetty）で `DefaultServlet` を使う方法を書いていきます。


## 前提
今回のコードを動かす場合、[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world) の資源（ディレクトリ構成、pom.xml、等）が必要になります。


## 手順1. サーバ起動クラスの作成
静的コンテンツの場所（ドキュメントルート）を指定して、ハンドラに `DefaultServlet` を追加するクラスを作成します。

`ejs/src/main/java/ejs/FileServer.java`

```java
package ejs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;

public class FileServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    //-> 静的コンテンツの場所をクラスパスで指定
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    ctx.addServlet(DefaultServlet.class, "/");
    svr.start();
    svr.join();
  }
}
```

上の例だと、静的コンテンツをクラスパスの `public` ディレクトリ配下に置くことになります。


## 手順2. HTMLの作成
動作確認で使う静的コンテンツを作成します。

`ejs/src/main/resources/public/index.html`

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"></head>
<body><p>Hello, from Embedded Jetty.</p></body>
</html>
```

## 手順3. 動作確認
`FileServer` クラスを実行してコンテナを起動します（Eclipse などの IDE で 実行すると楽だと思います）。

それから `http://localhost:8080/index.html` にアクセスすると、HTML の内容が表示されます。


## 補足. 静的コンテンツの配置場所について
静的コンテンツの配置場所は、次のようにファイルパスで指定することもできます。

```
    ctx.setResourceBase(
      "C:\\..."
    );
```
