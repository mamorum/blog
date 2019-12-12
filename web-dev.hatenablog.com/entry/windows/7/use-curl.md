---
Title: Windows7：curl でリクエスト送信
Category:
- Windows
Date: 2019-12-12T12:50:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/7/use-curl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812323632096
---

Windows7 にインストールした curl で、リクエストを送信する方法を書いていきます。大まかな内容は以下の通りです。

- HTTPメソッドの設定方法
- HTTPパラメータの設定方法
- JSONの設定方法（リクエストボディ）

## 注意事項
記事の内容は、Windows7 にインストールした curl で動作確認しています。

[https://web-dev.hatenablog.com/entry/windows/7/install-curl:embed:cite]

Windows10 にバンドルされている curl では動作確認できていません。


## HTTPメソッドの設定方法
メソッドはオプション `-X {メソッド名}` で設定できます。

```
curl http://localhost:8080/ -X POST
```

よく使いそうなものとしては `GET`, `POST`, `PUT`, `DELETE` などがあります。オプション `-X` を指定しない場合は、GET メソッドになります。


## HTTPパラメータの設定方法
### クエリ文字列
URL にクエリを含めて送信します。

```
curl http://localhost:8080/app/memo?txt=hello
```

パラメータは、`名=値` で指定します。

### FORM
コンテントタイプが `application/x-www-form-urlencoded` のリクエストを送る場合、`-d` オプションでパラメータを指定します。

```
curl http://localhost:8080/app/memo -X POST -d "txt=Hello"
```

## JSONの設定方法
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
