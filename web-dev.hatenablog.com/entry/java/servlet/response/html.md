---
Title: Servlet：HTMLを返す
Category:
- Java
Date: 2017-07-19T09:28:01+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/response/html
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812280899656
---

Java のサーブレットで、HTML を返す方法を書いてみます。


## 前提
今回の例は、下の記事の資源（`pom.xml`, `Main.java`, etc）を利用しています。必要に応じて参照して頂けると嬉しいです。

[Servlet：組込Jettyの起動](/entry/java/servlet/run-embedded-jetty)


## 手順1. サーブレットの作成
プロジェクトのルートディレクトリ `ssej` の下にサーブレット作成します。

`ssej/src/main/java/ssej/servlet/res/HtmlServlet.java`

```java
package ssej.servlet.res;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/res/html")
@SuppressWarnings("serial")
public class HtmlServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body><p>Hello!</p></body></html>"
    );
  }
}
```

`@WebServlet` を付けて、`/res/html` のリクエストを処理するサーブレットにしています。


## 手順2. 確認
コンテナ（組み込み Jetty）を起動して、ブラウザで `http://localhost:8080/res/html` を開きます。

サーブレットが実行されて、文字列 `Hello!` が表示されれば成功です。


## コード
今回のコードは GitHub にも置いています。

[ssej - Github](https://github.com/mamorum/blog/tree/master/code/servlet/ssej)
