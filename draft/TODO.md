## Java
- DBアクセス
  - HikariCP
  - Flyway
  - sql2o


### Jettyの記事作成
- 構想
  - JSR-356 を使う。
  - 組込Jetty と Tomcat の両方で使えるサンプルアプリにしたい。
  - まずは Tomcat 8.5 で Websocket できるように、サンプルを用意したい。
- サンプルコード
  - 組込Jetty -> ejws（参考文献→https://github.com/jetty-project/embedded-jetty-websocket-examples）
  - Tomcat 8.5 -> http://tomcat.apache.org/tomcat-8.5-doc/web-socket-howto.html
- chat を開始して、タブを閉じると closeになる
- chat を開始して、ずっとつないでおくと timeout がおきる。
- firefox と chrome だとタイムラグがある。
```
java.net.SocketTimeoutException: Timeout on Read
  at org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.onReadTimeout(AbstractWebSocketConnection.java:592)
  at org.eclipse.jetty.io.AbstractConnection.onFillInterestedFailed(AbstractConnection.java:170)
  at org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.onFillInterestedFailed(AbstractWebSocketConnection.java:538)
  at org.eclipse.jetty.io.AbstractConnection$ReadCallback.failed(AbstractConnection.java:285)
  at org.eclipse.jetty.io.FillInterest.onFail(FillInterest.java:140)
  at org.eclipse.jetty.io.AbstractEndPoint.onIdleExpired(AbstractEndPoint.java:398)
  at org.eclipse.jetty.io.IdleTimeout.checkIdleTimeout(IdleTimeout.java:166)
  at org.eclipse.jetty.io.IdleTimeout$1.run(IdleTimeout.java:50)
  at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
  at java.util.concurrent.FutureTask.run(FutureTask.java:266)
  at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
  at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
  at java.lang.Thread.run(Thread.java:748)
  ```


### crul
- リクエストを送信する（GET, POST, PUT, DELETE）
- JSONリクエストを送信する


## 改善
[Linux：どのディストリビューションを使うか？](http://web-dev.hatenablog.com/entry/linux/select-distribution)
->「個人利用なら Ubuntu が良いかも。」を追加したい。

[PostgreSQL：WindowsでユーザとDBを作成](http://web-dev.hatenablog.com/entry/postgresql/windows/create-user-db)
-> DB名、ユーザ名、パスワード（spring）を変えたい

[JDBC：UPDATE文の実行]()
