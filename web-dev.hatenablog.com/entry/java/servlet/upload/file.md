---
Title: Servlet：ファイルアップロード
Category:
- Java
Date: 2017-09-07T08:04:53+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/upload/file
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812295702900
---

Servlet API（バージョン 3.1）のファイルアップロードを使って、サーバー上にファイルを保存する方法を書いていきます。


## 前提
記事内のコードを実行する場合、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. サーブレットの作成
プロジェクトのルートディレクトリ `ssjp` の下にサーブレット作成します。

`ssjp/src/main/java/ssjp/servlet/FileUploadServlet.java`

```java
package ssjp.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/upload/file")
@MultipartConfig(maxFileSize=1048576)  // 最大1M
public class FileUploadServlet extends HttpServlet {
  final File uploadDir = new File("upload");  // ファイル保存先
  public void init() throws ServletException {
    uploadDir.mkdir();
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    // ファイルの保存 ->
    String id = req.getParameter("id");
    Part fPart = req.getPart("file");
    String fName = (new StringBuilder(id)
      .append("_").append(System.currentTimeMillis())
      .append("_").append(fPart.getSubmittedFileName()
    ).toString());
    save(fPart, new File(uploadDir, fName));
    // HTML を返す ->
    res.setContentType("text/html; charset=utf-8");
    res.getWriter().write(
      "<html><body><p>保存完了</p></body></html>"
    );
  }
  public void save(Part in, File out) throws IOException {
    BufferedInputStream br
      = new BufferedInputStream(in.getInputStream());
    try (BufferedOutputStream bw =
      new BufferedOutputStream(new FileOutputStream(out))
    ) {
      int len = 0;
      byte[] buff = new byte[1024];
      while ((len = br.read(buff)) != -1) {
        bw.write(buff, 0, len);
      }
    }
  }
}
```

`@WebServlet` を付けて `/upload/file` のリクエストを処理するサーブレットにしています。それから `@MultipartConfig` を付けて、ファイルアップロードを使えるようにしています。

ファイルは `upload` ディレクトリに、`ID_ミリ秒_送信ファイル名`という名称で保存されます。


## 手順2. 画面の作成
ファイルアップロード画面を HTML で作成します。

`ssjp/src/main/webapp/upload.html`

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"></head>
<body>
<form method="POST" enctype="multipart/form-data" action="/upload/file">
  <p><b>ID</b>：<input type="text" name="id"></p>
  <p><input type="file" name="file"></p>
  <p><input type="submit" value="送信"></p>
</form>
</body>
</html>
```

画面項目のID（`name="id"`）は、いつものように `req.getParameter("id")`（サーバサイド）で取得できるみたいです。ファイルは `Part` クラスを使います。

※ サンプルなので、画面内容や項目が微妙なのは勘弁してください。


## 手順3. 確認
まずは、コンテナ（Jetty Plugin など）を起動します。

```
ssjp> mvn jetty:run
```

それからブラウザで `http://localhost:8080/upload.html` を開いて、次の手順で確認していきます。

1. IDを入力
2. ファイルを選択
3. 送信ボタン押下

`ssjp/upload` にファイルが保存されれば成功です。


## 補足
ファイルを一時ファイルとして保存したい場合は、`@MultipartConfig(location=...)` と `Part#write(...)` を使うと良いかと思います。

あと、今回のコードはサンプルなので、エラーやセキュリティ面などは考慮していないです。


## 参考文献
[Servlet3.1のファイルアップロードが思いの外簡単だった件 - mike-neckのブログ](http://mike-neck.hatenadiary.com/entry/2014/10/30/144902)


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
