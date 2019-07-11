---
Title: 組込Jetty：Filterを使う
Category:
- Java
Date: 2017-10-11T10:20:01+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/servlet/use-filter
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812306834949
---

組み込み Jetty（Embedded Jetty）でフィルターを使って、Servlet などに前後処理を追加する方法を書いていきます。


## 前提
今回のコードを動かす場合、[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world) の資源（ディレクトリ構成、pom.xml、等）が必要になります。


## 手順1. フィルターの作成
簡単なログを出力して、サーブレット（or 次の Filter）に処理を渡すクラスを作成します。

`ejs/src/main/java/ejs/LogFilter.java`

```java
package ejs;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
  @Override public void doFilter(
    ServletRequest rq, ServletResponse rs, FilterChain chain)
  throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) rq;
    String log = (new StringBuilder()
      .append(LocalDateTime.now())
      .append(" ").append(req.getMethod())
      .append(" ").append(req.getRequestURI())
    ).toString();
    System.out.println(log);
    chain.doFilter(rq, rs);
  }
  @Override public void init(FilterConfig c) throws ServletException {}
  @Override public void destroy() {}
}
```

今回は例として、日時・HTTPメソッド・リクエストのパスを標準出力に出します。


## 手順2. サーバ起動クラスの編集
記事「[組込Jetty：ServletでHelloWorld](/entry/jetty/embed/servlet/hello-world)」のクラスを編集して、組込Jetty（サーバー）にフィルターを登録します。

`ejs/src/main/java/ejs/AppServer.java`

```java
package ejs;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

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
    ctx.addServlet(HelloServlet.class, "/hello");
    ctx.addFilter(
      LogFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST)
    );
    svr.start();
    svr.join();
  }
}
```

`ctx.addFilter(...` が今回追加した処理です。全てのリクエスト（`/*`）に対してフィルターを実行するようにしています。


## 手順3. 動作確認
AppServer クラスを実行してコンテナを起動します（Eclipse などの IDE で 実行すると楽だと思います）。

それから `http://localhost:8080/hello` などを開くと、次のようにログが出力されます。

```
2017-10-11T09:06:54.171 GET /hello
2017-10-11T09:06:54.200 GET /favicon.ico
2017-10-11T09:07:10.030 GET /hello
2017-10-11T09:07:25.844 GET /h
・・・
```
