---
Title: 組込Jetty：HelloWorldの表示
Category:
- Java
Date: 2017-07-12T10:21:30+09:00
URL: http://web-dev.hatenablog.com/entry/jetty/embed/hello-world
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812278924031
---

Embedded Jetty（組み込み Jetty）で、Http リクエストに対して Hello World を返す例を書いていきます。


## 手順1. Jar のダウンロード
jetty-all.jar を、[こちら](http://www.eclipse.org/jetty/documentation/9.4.6.v20170531/advanced-embedding.html) からダウンロードします。

自分がダウンロードしたときは  `jetty-all-9.4.6.v20170531-uber.jar` という名前でした。保存先は `jetty-embedded` というディレクトリにしてみました。


## 手順2. HelloWorld クラスの作成
Jetty の `AbstractHandler` を継承しつつ、main でサーバを起動するコードを用意します。

`jetty-embedded/HelloWorld.java`

```java
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorld extends AbstractHandler {
  @Override public void handle(
    String target, Request baseRequest,
    HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().println("<h1>Hello World</h1>");
    baseRequest.setHandled(true);
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    server.setHandler(new HelloWorld());
    server.start();
    server.join();
  }
}
```

## 手順3. コンパイル
コンパイル先 `classes` を作成して、javac コマンドでコンパイルします。

```
jetty-embedded> mkdir classes
jetty-embedded> javac -d classes -cp jetty-all-9.4.6.v20170531-uber.jar HelloWorld.java
```


## 手順4. 実行・確認
次のコマンドで実行します。

```
jetty-embedded> java -cp classes;jetty-all-9.4.6.v20170531-uber.jar HelloWorld
```

※ Windows はセミコロン `;` で `-cp` オプションのクラスパスを区切ります。Linux 系はコロン `:` で区切ります。

Jetty が起動したら `http://localhost:8080/` にアクセスして、Hello World と表示されれば成功です。


## 参考文献
[Jetty Embedded HelloWorld - Jetty](http://www.eclipse.org/jetty/documentation/9.4.6.v20170531/advanced-embedding.html)
