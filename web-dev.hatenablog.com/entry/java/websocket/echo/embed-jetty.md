---
Title: WebSocket：組込みJettyでエコーアプリを起動
Category:
- Java
Date: 2018-02-13T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/websocket/echo/embed-jetty
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971615017656
---

Java の WebSocket を使ったエコーアプリを、組込み Jetty で起動してみようと思います。アプリの資源は、以下の記事で準備してきました。

- [エコーアプリのJava開発](/entry/java/websocket/echo/dev-java)
- [エコーアプリのUI開発](/entry/java/websocket/echo/dev-ui)

アプリ（と今回のコード）を動かすためには、上の記事の資源が必要になります。必要に応じて参照して頂けると嬉しいです。


## 1. メインクラスの作成
Jetty を起動するメインクラスを作成します。

`ws-echo/src/main/java/sample/ws/echo/jetty/Main.java`

```java
package sample.ws.echo.jetty;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import sample.ws.echo.EchoSocket;

public class Main {
  public static void main(String[] args) throws Exception {
    //-> setup context
    WebAppContext ctxt = new WebAppContext();
    ctxt.setContextPath("/ws-echo");
    //-> setup static file
    ctxt.setBaseResource(
      Resource.newResource("src/main/webapp")
    );
    //-> setup server
    Server svr = new Server(8080);
    svr.setHandler(ctxt);
    //-> setup websocket
    ServerContainer ws
      = WebSocketServerContainerInitializer.configureContext(ctxt);
    ws.addEndpoint(EchoSocket.class);
    //-> start server
    svr.start();
    svr.join();
  }
}
```

Jetty の `WebSocketServerContainerInitializer` を使って、WebSocket が有効になるように設定しています。あとは `ServerContainer` を使って、以前作成した `EchoSocket` をエンドポイントとして登録しています。


## 2. 実行
上のメインクラスを実行するとサーバが起動します。Eclipse 等で実行すると簡単だと思います。


## 動作確認
画面を使った動作確認は、次回の記事にまとめようかと思っています。

