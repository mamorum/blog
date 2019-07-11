---
Title: SpringBoot入門：静的コンテンツを返す
Category:
- Spring
Date: 2017-02-21T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/response-static-content
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687219967440
---

Spring Boot の Webアプリで、サーバサイドから静的コンテンツ（html, js, css, png, etc）を返却する方法を書いていきます。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. HTML の作成
次のファイルを作成します。

`gssb/src/main/resources/public/index.html`

```
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
</head>
<body>
<p>Hello, World.</p>
</body>
</html>
```

静的コンテンツは、デフォルトだと `src/main/resources/public`（or `src/main/resources/static`）に置くと公開されます。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
```


## 手順3. 確認
ブラウザで `http://localhost:8080/index.html` を開いて、次のように表示されれば成功です。

```txt
Hello, World.
```

## 補足1. ディレクトリ階層とＵＲＬ
静的コンテンツは、ディレクトリ階層を作って公開することもできます。

```
src/main/resources/public/
  - index.html
  - css/
    - style.css
  - js/
    - main.js
```

上の例だと、ディレクトリ `css`, `js` の資源は、`http://localhost:8080/css/style.css`, `http://localhost:8080/js/main.js` で公開されます。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog-code/tree/master/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
