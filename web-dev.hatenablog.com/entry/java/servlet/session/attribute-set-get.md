---
Title: Servlet：セッションを使う
Category:
- Java
Date: 2017-10-05T08:37:51+09:00
URL: https://web-dev.hatenablog.com/entry/java/servlet/session/attribute-set-get
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812304939203
---

Servlet API のセッション（`HttpSession`）を使うと、リクエストをまたがって値を保持することができます。これから,
セッションに値を設定して取得する方法を書いていきます。


## 前提
記事内のコードを実行する場合、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. 値を設定するサーブレットの作成

`ssjp/src/main/java/ssjp/session/SetSessionServlet.java`

```java
package ssjp.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/set")
@SuppressWarnings("serial")
public class SetSessionServlet extends HttpServlet {
  public void doGet(
    HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    //-> パラメータを取得してセッションに設定
    String val = req.getParameter("param");
    HttpSession ssn = req.getSession();
    ssn.setAttribute("ssn", val);
    //-> HTMLを返す
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body>設定完了</body></html>"
    );
  }
}
```


リクエストパラメータ `param` の値を取得してセッションに設定しています。セッションに設定するために、キー（`ssn`）を指定しています。


## 手順2. 値を取得するサーブレットの作成

`ssjp/src/main/java/ssjp/session/GetSessionServlet.java`

```java
package ssjp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/get")
@SuppressWarnings("serial")
public class GetSessionServlet extends HttpServlet {
  public void doGet(
    HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    //-> セッションから値を取得してHTMLを返す
    HttpSession ssn = req.getSession(false);
    if (ssn == null) {
      html("セッションなし", res);
    } else {
      String val = (String) ssn.getAttribute("ssn");
      html(val, res);
    }
  }
  private void html(
    String msg, HttpServletResponse res)
  throws IOException {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    PrintWriter o = res.getWriter();
    o.print("<html><body>");
    o.print(msg);
    o.println("</body></html>");
  }
}
```

キー（`ssn`）で保存した値をセッションから取得します。取得した値を使って HTML を返しています。


## 手順3. 確認
コンテナ（Jetty Plugin など）を起動して以下の通り確認します。

### 3.1. 値の設定
ブラウザ等で `http://localhost:8080/session/set?param=test` を開いて、セッションにパラメータ（`param`）の値（`test`）を保存します。

### 3.2. 値の取得
次に `http://localhost:8080/session/get` を開くと、保存された値が画面に表示されます。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog-code/tree/master/servlet/ssjp)（※ Servlet Sample Jetty Plugin）

