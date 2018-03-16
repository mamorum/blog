---
Title: 組込みJetty：ローカルだけアクセスできるようにする
Category:
- Java
Date: 2018-03-23T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/jetty/embed/handle-local-request-only
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971626146632
Draft: true
---

組込み Jetty で、ローカルのリクエストだけ受け付ける方法を書いていきます。


## 設定方法
Jetty を起動する際に、Listen する IP を `127.0.0.1` に設定してあげると良さそうです。そうすると、外部からのリクエストを受け付けなくなるみたいです。


## コード例
Jetty の `ServerConnector` を使って、Listen する IP を設定しました。

```java
package ejs;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class LocalServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server();
    ServerConnector con = new ServerConnector(svr);
    svr.addConnector(con);
    con.setHost("127.0.0.1");
    con.setPort(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    ctx.getSessionHandler().setMaxInactiveInterval(1800);
    ctx.addServlet(HelloServlet.class, "/hello");
    ctx.addFilter(
      LogFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST)
    );
    svr.start();
    svr.join();
  }
}
```

具体的には、`con.setHost("127.0.0.1");` のところになります。


## コードの実行方法
上のコードを動かす場合、[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world) の資源（ディレクトリ構成、pom.xml、等）が必要になります。

必要に応じて参照して頂けると嬉しいです。


## 参考文献
今回の設定方法は、以下の記事を参考にさせて頂きました。

[セキュリティのためのApache Solrアクセス制限あれこれ ](https://ameblo.jp/itboy/entry-11592487115.html)

Apache Solr の記事なんですが、Solr（4.2）が Jetty を使っているみたいです。
