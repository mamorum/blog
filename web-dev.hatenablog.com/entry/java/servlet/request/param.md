---
Title: Servlet：リクエストパラメーターの取得
Category:
- Java
Date: 2017-08-19T19:41:30+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/request/param
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812290163743
---

Java のサーブレットで、リクエストパラメータを取得する方法を書いてみます。


## 前提
記事内のコードを実行する場合、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. サーブレットの作成
パラメータ名 `msg` の値を取得するサーブレットを作成します。

`ssjp/src/main/java/ssjp/servlet/ParamServlet.java`

```java
package ssjp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/param")
@SuppressWarnings("serial")
public class ParamServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/plain");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(req.getParameter("msg"));
  }
}
```

`@WebServlet` を付けて、`/req/param` のリクエストを処理するようにしています。


## 手順2. 確認
コンテナ（Jetty Plugin など）を起動して、ブラウザで `http://localhost:8080/req/param?msg=Hello` を開きます。

サーブレットが実行されて、文字列 `Hello` が表示されれば成功です。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
