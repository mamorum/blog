---
Title: Windows：cURL でリクエスト送信
Category:
- Windows
Date: 2017-12-11T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/use-curl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812323632096
---

[Windows にインストールした cURL](/entry/windows/install-curl) を使うと、コマンド `curl http://....` でHTTPリクエストを送信できます。今回はそのときによく使うオプションをまとめていこうと思います。

大まかな内容は以下の通りです。

- メソッドの指定方法
- パラメータの指定方法
- JSONの指定方法（リクエストボディ）

※ コマンドの例では、URLを `http://localhost:8080/...` にしています。必要に応じて変更して頂ければと思います。


## HTTPメソッドの指定方法
### GET
オプション `-X` を指定しない場合は、GET メソッドになります。

```
curl http://localhost:8080/
```

### GET 以外
メソッドをオプション `-X {メソッド名}` で指定します。

```
curl http://localhost:8080/ -X POST
```

よく使いそうなものとしては `POST`, `PUT`, `DELETE` などがあります。


## HTTPパラメータを指定
### クエリ文字列
URL にクエリを含めて送信します

```
curl http://localhost:8080/app/memo?txt=hello
```

パラメータは、`名=値` で指定します。

### FORM
コンテントタイプが `application/x-www-form-urlencoded` のリクエストを送る場合、`-d` オプションでパラメータを指定します。

```
curl http://localhost:8080/app/memo -X POST -d "txt=Hello"
```

## JSONを指定
オプション `-H` でコンテントタイプ `application/json` を指定して、`-d` で送りたい JSON を指定します。

```
curl http://localhost:8080/app/memo -X PUT -H "Content-Type: application/json" -d "{"id":18, "txt":"Hello"}"
```

## JSONの注意点
JSON を送信すると、次のようにエラー？（`curl: (3) [globbing] unmatched ...`）が表示されることがあります。

```
> curl http://localhost:8080/app/memo -X PUT -H "Content-Type: application/json" -d "{"id":18, "txt":"Hello World"}"

curl: (3) [globbing] unmatched close brace/bracket in column 6
```

JSON の値などで空白文字列があるとダメみたいです。Windows の場合、以下のように二重引用符をエスケープしてあげると上手くいきます。

- 変更前の値: "txt":"Hello World"
- 変更後の値: "txt":\"Hello World\"

下のコマンドだと、先ほどのエラーが発生しません。

```
curl http://localhost:8080/app/memo -X PUT -H "Content-Type: application/json" -d "{"id":18, "txt":\"Hello World\"}"
```


## 補足. 詳細表示（-v オプション）
HTTP のリクエストヘッダやレスポンスヘッダを表示したい場合は、`-v` オプションを付けると良さそうです。

```
curl http://localhost:8080/app/memo -v
```
