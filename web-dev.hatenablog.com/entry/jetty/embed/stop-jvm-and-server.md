---
Title: 組込みJetty：JVMとサーバーの停止方法
Category:
- Java
Date: 2018-04-03T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/jetty/embed/stop-jvm-and-server
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971628478754
---

組込み Jetty と JVM を停止する方法を書いていきます。今回のコードは、サーバー上で動いているプログラム（サーブレットなど）から実行するものになります。


## 停止方法１
次のようなコードで停止することができます。

```java
Server server = ...

server.setStopAtShutdown(true);
(new Thread() {
  public void run() { System.exit(0); }
}).start();
```

新しいスレッドで JVM を停止する感じです。事前に `Server.setStopAtShutdown(true);` を実行して、サーバーも停止させるようにしておきます。


## 停止方法２
JVM を停止するスレッド内で、`Server.stop();` を実行しても大丈夫そうです。`Server.stop();` だけだと、JVMは停止されないようです。


## 補足. セキュリティ面について
不特定多数に公開しているサービスは、セキュリティ面を考慮したほうが良さそうです。誰でも停止処理を実行できるようにすると、攻撃を受けてサービスが提供できなくなったりする可能性があります。


## 参考文献
Jetty の [ShutdownHandler.java - GitHub](https://github.com/eclipse/jetty.project/blob/jetty-9.4.x/jetty-server/src/main/java/org/eclipse/jetty/server/handler/ShutdownHandler.java) を参考にさせて頂きました。
