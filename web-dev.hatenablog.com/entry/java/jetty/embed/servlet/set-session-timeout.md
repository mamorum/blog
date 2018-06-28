---
Title: 組込Jetty：セッションタイムアウトの設定
Category:
- Java
Date: 2017-10-12T16:19:26+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/servlet/set-session-timeout
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812307236469
---

組み込み Jetty（Embedded Jetty）で、セッションタイムアウトの時間を設定する方法を書いてみました。


## 前提
この記事のコードを動かす場合は、記事「[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world)」の資源（ディレクトリ構成、pom.xml）が必要になります。


## 設定方法
Jetty の `ServletContextHandler` を使っている場合、コンテキストからセッションハンドラーを取得して設定します。

```java
// ※ 下の ctx は ServletContextHandler 型の変数
ctx.getSessionHandler().setMaxInactiveInterval(1800);
```

設定する値は秒で、上の例だと30分（1800秒=60秒×30分）になります。


## コード例
次のコードは、記事「[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world)」の `AppServer` クラスです。セッションタイムアウトを設定する行を追加してみました。

`ejs/src/main/java/ejs/AppServer.java`

```java
package ejs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class AppServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    ctx.getSessionHandler().setMaxInactiveInterval(1800);
    ctx.addServlet(HelloServlet.class, "/hello");
    svr.start();
    svr.join();
  }
}
```
