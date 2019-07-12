---
Title: ServletRequestListener：リクエストの前後処理
Category:
- Java
Date: 2017-08-21T10:24:48+09:00
URL: https://web-dev.hatenablog.com/entry/java/servlet/listener/servlet-request
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812290606592
---

`ServletRequestListener` を使うと、サーブレット（or フィルタ）の処理前後に通知を受けることができます。


## 前提
記事内のコードを実行するには、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. リスナーの作成
`ServletRequestListener` を実装するリスナーを作成します。

`ssjp/src/main/java/ssjp/listener/RequestListener.java`

```java
package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
  @Override public void requestInitialized(ServletRequestEvent sre) {
    HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
    System.out.print(LocalDateTime.now());
    System.out.print(" Request initialized ");
    System.out.println(req.getRequestURI());
  }
  @Override public void requestDestroyed(ServletRequestEvent sre) {
    HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
    System.out.print(LocalDateTime.now());
    System.out.print(" Request destroyed ");
    System.out.println(req.getRequestURI());
  }
}
```

メソッド `#requestInitialized(ServletRequestEvent)` が処理の前、`requestDestroyed(ServletRequestEvent)` が処理の後で実行されます。

また、`@WebListener` を付けて、サーバーに見つけてもらうようにしています。


## 手順2. 確認
コンテナ（Jetty Plugin など）を起動して、ブラウザで `http://localhost:8080/res/html` を開きます。

すると以下の文字列が標準出力されます。

```
2017-08-21T10:19:01.437 Request initialized /res/html
2017-08-21T10:19:01.440 Request destroyed /res/html
```

※ `/res/html` を処理するサーブレットは、記事「[Servlet：HTMLを返す](/entry/java/servlet/response/html)」に実装例があります。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
