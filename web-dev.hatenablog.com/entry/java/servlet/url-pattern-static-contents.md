---
Title: Servlet：URLパターンと静的コンテンツ
Category:
- Java
Date: 2017-07-29T09:26:38+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/url-pattern-static-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812283618785
---

Servlet のURLパターンと静的コンテンツのパスが同じ場合、どちらのコンテンツが返ってくるか確認してみました。


## 1. 結果
Servlet 3.1 の場合、Servlet のコンテンツが返ってきました。URL がかぶった場合、サーブレットの処理が優先されるみたいです。


## 2. 検証資源
`index.html` を処理するサーブレットと、その名前の HTML で検証しました。war のイメージは以下の通りです。

```
war
  - WEB-INF/classes/servlet/IndexServlet.class
  - index.html
```

サーブレットのコードはこんな感じで、URLパターンはアノテーションで指定しています。

```java
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body><p>Index Servlet</p></body></html>"
    );
  }
}

```


## 3. 検証環境（コンテナ）
- Jetty 9.4.6.v20170531（Embedded Jetty を使用）
- Tomcat 8.5.16


## 4. 他のプロダクト
### 4.1. Spark Framework（2.5.5）
静的コンテンツが優先されるようでした。

### 4.2. Express（4.15.3）
サーブレットではないですが、設定順に処理されました。

ルーティングを先に設定すると、ルーティングが優先されました。静的コンテンツが先だと、静的コンテンツが優先されました。

以下のコードはルーティングが先なので、ルーティングの処理が優先されます。

```javascript
const express = require('express')
const app = express()

// ルーティング
app.get('/index.html', function (req, res) {
  res.send('Hello World!')
})

// 静的コンテンツ
app.use(express.static('public'))

app.listen(3000, function () {
  console.log('Example app listening on port 3000!')
})
```
