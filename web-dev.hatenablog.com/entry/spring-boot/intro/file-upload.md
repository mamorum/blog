---
Title: SpringBoot入門：ファイルアップロード
Category:
- Spring
Date: 2017-02-17T17:03:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/file-upload
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179111360
---

Spring Boot の Webアプリで、ファイルアップロードを受け付ける方法を書きます。手順としては、次の資源を作成していきます。

1. アップロードを受け付けるコントローラ
2. アップロードする画面


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
アップロードを受け付けるクラスを作成します。

`gssb/src/main/java/gssb/controller/FileUploadController.java`

```java
package gssb.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    
  // 引数名 `file` は、ファイルのリクエストパラメータ名と一致させる。
  @RequestMapping(value="/upload", method=RequestMethod.POST)
  public void handle(
    HttpServletResponse response,
    @RequestParam MultipartFile file
  ){
    // ファイルが空の場合は HTTP 400 を返す。
    if (file.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    // アップロードされたファイルを保存。
    try {
      BufferedInputStream in =
        new BufferedInputStream(file.getInputStream());
      BufferedOutputStream out =
        new BufferedOutputStream(
          new FileOutputStream(file.getOriginalFilename()));
      FileCopyUtils.copy(in, out);
    } catch (IOException e) {
      throw new RuntimeException("Error uploading file.", e);
    }
  }
}
```


## 手順2. 画面の作成
アップロードボタンのある画面を作成します。

`gssb/src/main/resources/public/file-upload.html`

```
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>File Upload</title>
</head>
<body>
<div>
  <form id="form" enctype="multipart/form-data">
    <p><input type="file" name="file"></p>
    <p><input type="button" id="upload" value="アップロード"></p>
  </form>
  <span id="result" style="padding:3px;"></span>
</div>
</body>
<script src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
$(function() {
  // アップロードボタンが押されたら実行。
  $('#upload').click(function() {
    var formData = new FormData(
      $('#form').get()[0]
    );
    $.ajax({
      url:'/upload',
      method:'post',
      data:formData,
      processData:false,
      contentType:false,
      cache: false
    }).done(function(data, status, jqxhr) {
      $('#result').text('結果：成功');
    }).fail(function(data, status, jqxhr) {
      $('#result').text('結果：失敗');
    }); 
  });
});
</script>
</html>
```


## 手順3. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
```


## 手順4. 確認
ブラウザで `http://localhost:8080/file-upload.html` を開いてアップロードすると、下の画像のように「成功」と表示されます。ファイルは `gssb` ディレクトリの下に保存されます。

![page-file-upload](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814222022.png)

ファイルを選択しないでアップロードしたり、０バイトのファイルをアップロードすると、下の画像のように「エラー」と表示されます。

![error-file-upload](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814222023.png)


## 課題
ファイルアップロードでは、次のような点を検討する必要があると思います。

- 保存先と名称
- サイズの上限
- 等々

Spring Boot の場合、設定ファイル（`application.properties`）で、ファイルサイズを制限できたりするようです。設定値は、[Spring Boot のドキュメント - Common application properties](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#common-application-properties) が参考になりそうです。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
