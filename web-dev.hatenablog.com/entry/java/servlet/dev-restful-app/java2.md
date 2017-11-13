---
Title: Servletアプリ開発：4.Java開発２（RESTful API）
Category:
- Java
Date: 2017-11-11T07:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/java2
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315713579
---

サーブレットアプリ（RESTful API）の Java開発について書いていきます。Java開発は２つの記事に分けていて、[前回](/entry/java/servlet/dev-restful-app/java1) はモデルとリポジトリをつくって、メモのデータを操作できるようにしました。

今回はサーブレットを使って RESTful API をつくっていこうと思います。


## メモの全件表示・作成クラス（GET, POST）
メモの全件表示と作成を実装する API を作成します。

`servlet-rest/src/main/java/http/MemoApi.java`

```java
package http;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MemoRepository;
import model.Memo;

@WebServlet("/memo")
@SuppressWarnings("serial")
public class MemoApi extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    List<Memo> memo = MemoRepository.readAll();
    Res.json(
      res, Collections.singletonMap("memo", memo)
    );
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    Memo memo = MemoRepository.create(
      req.getParameter("txt")
    );
    Res.json(
      res, Collections.singletonMap("memo", memo)
    );
  }
}
```

リクエストとそれを処理するメソッドのマッピングは以下の通りです。

| リクエストメソッド | リクエストURI | Javaメソッド |
|----------------------|-----------------|----------------|
| GET                      | /memo          | doGet           |
| POST                    | /memo          | doPost          |

どちらもレスポンスは JSON を返していて、実処理は下の `Res` クラス移譲しています。

`servlet-rest/src/main/java/http/Res.java`

```java
package http;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Res {
  static Gson gson = new Gson();
  static void json(HttpServletResponse res, Object toJson)
    throws IOException
  {
    res.setContentType("application/json");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      gson.toJson(toJson)
    );
  }
}
```


## メモの更新・削除クラス（PUT, DELETE）
メモの更新・削除ができる API を作成します。

`servlet-rest/src/main/java/http/MemoIdApi.java`

```java
package http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MemoRepository;

@WebServlet("/memo/*") //-> "/memo/:id"
@SuppressWarnings("serial")
public class MemoIdApi extends HttpServlet {
  public void doPut(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    MemoRepository.update(
      id(req), req.getParameter("txt")
    );
  }
  public void doDelete(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    MemoRepository.delete(
      id(req)
    );
  }
  //-> Get id from URI. (ex."/memo/1" -> return 1)
  private Long id(HttpServletRequest from) {
    String[] uri = from.getRequestURI().split("/");
    if (uri.length != 3) return null;
    return Long.valueOf(uri[2]);
  }
}
```

リクエストとそれを処理するメソッドのマッピングは以下の通りです。

| リクエストメソッド | リクエストURI | Javaメソッド |
|----------------------|-----------------|----------------|
| PUT                      | /memo/*       | doPut           |
| DELETE                | /memo/*        | doDelete      |

リクエストURI の「`*`」は可変で、`/memo/1`, `/memo/2` などの ID が設定される想定です。レスポンスは、サーブレットのコード上だと何も設定してませんが、正常終了すると要求元に HTTPステータス200 が送信されます。


## 補足
サンプルアプリなので、あまり異常系とか入力値検証（バリデーション）のことは考慮していません。

例えば、クライアントからメモの内容が空のリクエストが来るかもしれません。また、ユーザがURLを直打ちしたら `/memo/abc` など、IDが数値じゃない要求もきたりします。
