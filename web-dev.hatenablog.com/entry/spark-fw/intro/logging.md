---
Title: Spark FW：ログ出力
Category:
- SparkFW
Date: 2017-04-12T11:06:42+09:00
URL: http://web-dev.hatenablog.com/entry/spark-fw/intro/logging
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687236396030
---

Java の [Spark Framework](http://sparkjava.com/) を使ったアプリで、ログを出力する方法を書いていこうと思います。


## 前提1. アプリ資源について
アプリの資源（ビルドファイル、コード）は、[Spark FW：HelloWorldを返す](http://web-dev.hatenablog.com/entry/spark-fw/intro/hello-world) に書いてあります。この記事では、リンク先のアプリを使ってログを出します。


## 前提2. ログ出力の設定がない場合
ログ設定なしで Spardk Framework のアプリを起動すると、次のようなメッセージが出力されます。

```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```


## 手順1. ビルドファイルの編集
[Spark FW：HelloWorldを返す](http://web-dev.hatenablog.com/entry/spark-fw/intro/hello-world) のビルドファイルに、次の依存性を追加します。

`sprkgs/pom.xml（追加部分）`

```
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-simple</artifactId>
      <version>1.7.21</version>
    </dependency>
```


## 手順2. アプリ起動・確認
HelloWorld の記事で作成した `Main.java` を実行します。すると、次のようなログがコンソールに出力されます。

```
[Thread-0] INFO org.eclipse.jetty.util.log - Logging initialized @299ms
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - == Spark has ignited ...
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - >> Listening on 0.0.0.0:4567
[Thread-0] INFO org.eclipse.jetty.server.Server - jetty-9.3.6.v20151106
[Thread-0] INFO org.eclipse.jetty.server.ServerConnector - Started ServerConnector@1353edeb{HTTP/1.1,[http/1.1]}{0.0.0.0:4567}
[Thread-0] INFO org.eclipse.jetty.server.Server - Started @678ms
```

## 補足
Logback（classic）を使いたい場合は、次の依存性を追加すれば大丈夫そうです。（上の依存性 `slf4j-simple` は不要になります。）

```
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.2.3</version>
    </dependency>
```


## 参考文献
[How do I enable logging? - Spark](http://sparkjava.com/documentation.html#add-a-logger)


## コード
[sprkgs - GitHub](https://github.com/mamorum/blog/tree/master/code/sprkgs)
