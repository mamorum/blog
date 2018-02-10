---
Title: WebSocket：エコーアプリの動作確認
Category:
- Java
Date: 2018-02-19T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/websocket/echo/check
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971615018273
Draft: true
---

Java の WebSocket を使って開発したエコーアプリの動作確認をしていきます。エコーアプリの資源と起動方法は、以下の記事にまとめています。

- [エコーアプリのJava開発](/entry/java/websocket/echo/dev-java)
- [エコーアプリのUI開発](/entry/java/websocket/echo/dev-ui)
- [組込みJettyでエコーアプリを起動](/entry/java/websocket/echo/embed-jetty)
- [Tomcatでエコーアプリを起動](/entry/java/websocket/echo/deploy-tomcat)


## 画面の表示
エコーアプリを起動してから、`http://localhost:8080/ws-echo/` にアクセスすると下の画面が開きます。

[f:id:mamorums:20180208162416p:plain]


## エコーの確認
画面を開いたら、

1. 文字を入力して送信ボタンを押して、
2. 文字列が表示されることを確認します。

入力エリアの下に文字列が表示されれば、サーバーのエコーを受け取ったことになります。


## Jetty で起動した場合のタイムアウト
Jetty で動作確認していると、接続がタイムアウトすることがありました。

そのときに発生した例外を掲載しておきます。

```
@OnError:
java.net.SocketTimeoutException: Timeout on Read
	at org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.onReadTimeout(AbstractWebSocketConnection.java:592)
	at org.eclipse.jetty.io.AbstractConnection.onFillInterestedFailed(AbstractConnection.java:170)
	at org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.onFillInterestedFailed(AbstractWebSocketConnection.java:538)
	at org.eclipse.jetty.io.AbstractConnection$ReadCallback.failed(AbstractConnection.java:285)
	at org.eclipse.jetty.io.FillInterest.onFail(FillInterest.java:140)
	at org.eclipse.jetty.io.AbstractEndPoint.onIdleExpired(AbstractEndPoint.java:398)
	at org.eclipse.jetty.io.IdleTimeout.checkIdleTimeout(IdleTimeout.java:166)
	at org.eclipse.jetty.io.IdleTimeout$1.run(IdleTimeout.java:50)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:514)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:299)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
	at java.base/java.lang.Thread.run(Thread.java:844)
@OnClose: CloseReason[1001,Idle Timeout]
```

`EchoSocket` クラスの `@OnError` に例外が渡ってきて画面に出力されたものです。`@OnClose` も実行されていて、理由はタイムアウトとなっています。ブラウザで何も操作しないでいると、タイムアウトが発生するような気がします。

Tomcat のほうは、だいぶ待ったんですが、同じようなタイムアウトは発生しませんでした。

