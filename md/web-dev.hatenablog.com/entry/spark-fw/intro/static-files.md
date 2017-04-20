---
Title: Spark FW：静的コンテンツを返す
Category:
- Spark FW
Date: 2017-04-20T12:35:34+09:00
URL: http://web-dev.hatenablog.com/entry/spark-fw/intro/static-files
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687238297447
---


Java の [Spark Framework](http://sparkjava.com/) を使って、サーバサイドから静的コンテンツを返してみます。


## 前提. アプリ資源について
この記事では、[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world) の資源（ビルドファイル、コード）を使っています。必要に応じて参照して頂けると嬉しいです。


## 手順1. メインクラスの編集
記事「[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world)」で作成した `Main.java` を編集します。

```java
package sprkgs;

import static spark.Spark.*;

public class Main {
  public static void main(String[] args) {
    staticFiles.location("/public");
    get("/hello", (req, res) -> "Hello World");
  }
}
```

main メソッド内の `staticFiles.location("/public");` を追加しています。これで `src/main/resources/public` を、静的コンテンツの配置場所だと認識してくれるみたいです。


## 手順2. HTML の作成
静的コンテンツの例として、簡単な HTMLを作成しました。

`src/main/resources/public/index.html`

```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Index Page</title>
</head>
<body>
  <p>Hi.</p>
</body>
</html>
```


## 手順3. アプリ起動
上の `Main.java` を Java アプリとして実行します。

コマンドラインからの実行方法は、HelloWorld の記事にも書いてあります。


## 手順4. 確認
`http://localhost:4567/index.html` にアクセスすると、作成した HTML が返ってきます。


## 補足. 静的コンテンツの場所
次のメソッドを使うと、静的コンテンツの場所をファイルシステムのパス（`C:\var\www`, `/var/www`, etc）で設定できるようです。

```
staticFiles.externalLocation(String);
```


## 参考文献
[Static Files - Spark](http://sparkjava.com/documentation.html#static-files)


## コード
[sprkgs - GitHub](https://github.com/mamorum/blog/tree/master/code/sprkgs)
