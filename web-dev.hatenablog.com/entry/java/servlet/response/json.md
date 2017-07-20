---
Title: Servlet：JSONを返す
Category:
- Java
Date: 2017-07-20T08:49:18+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/response/json
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812281144650
---

Java のサーブレットで、JSON を返す方法を書いてみます。JSON 文字列の生成には [Gson](https://github.com/google/gson) を使いました。


## 前提
今回の例は、下の記事の資源（`pom.xml`, `Main.java`, etc）を利用しています。必要に応じて参照して頂けると嬉しいです。

[Servlet：組込Jettyの起動](/entry/java/servlet/run-embedded-jetty)


## 手順1. サーブレットの作成
プロジェクトのルートディレクトリ `ssej` の下にサーブレット作成します。

`ssej/src/main/java/ssej/servlet/res/JsonServlet.java`

```java
package ssej.servlet.res;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/res/json")
@SuppressWarnings("serial")
public class JsonServlet extends HttpServlet {
  private static final Gson gson = new Gson();
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("application/json");
    res.setCharacterEncoding("utf-8");
    String name = req.getParameter("name");
    String msg = (
      new StringBuilder("Hello, ")
    ).append(name).toString();
    res.getWriter().println(gson.toJson(
      Collections.singletonMap("msg", msg)
    ));
  }
}
```

`@WebServlet` を付けて、`/res/json` のリクエストを処理するサーブレットにしています。リクエストパラメーター `name` の値を取得して、レスポンスの JSON を生成しています。


## 手順2. 確認
コンテナ（組み込み Jetty）を起動して、ブラウザで `http://localhost:8080/res/json?name=Bob` を開きます。

サーブレットが実行されて、JSON文字列 `{"msg":"Hello, Bob"}` が表示されれば成功です。


## コード
今回のコードは GitHub にも置いています。

[ssej - Github](https://github.com/mamorum/blog/tree/master/code/servlet/ssej)
