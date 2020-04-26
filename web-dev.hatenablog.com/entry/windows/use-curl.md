---
Title: Windows：curl を使う
Category:
- Windows
Date: 2020-04-13T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/use-curl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613548287769
---

Windows10 の `curl` で、リクエストを送信する方法を書いていきます。大まかな内容は以下の通りです。

1. HTTPメソッドの設定方法
2. HTTPパラメータの送信（クエリ、フォーム）
3. JSONの送信（リクエストボディ）

※ Windows で必要なエスケープについても書いてます。


## 1. HTTPメソッドの設定方法
メソッドは `-X` で設定します。

```
> curl http://localhost/api/person/2 -X DELETE
```

指定がないと `GET` になるみたいです。


## 2. HTTPパラメータの送信
### 2.1. クエリ文字列
URLにパラメータ（`名=値`）を含めて送信します。

```
> curl http://localhost/api/person?id=1^&name=Jhon%20Doe
```

アンパサンドは `^` でエスケープ、スペースは `%20` で送信できます。上の実データは、`id=1&name=Jhon Doe` となります。


### 2.2. フォーム
`application/x-www-form-urlencoded` のリクエストは、`-d` でパラメータを指定します。

```
> curl http://localhost/api/person -d "id=1&name=Jhon Doe"
```

`&` とスペースは、そのままで大丈夫でした。`-d` を付けると、自動で `POST` になるみたいです。


## 3. JSONの送信
`-H` でコンテントタイプ、`-d` で JSON を指定します。

```
> curl http://localhost/api/person -H "Content-Type: application/json" -d "{\"id\":1, \"name\":\"Jhon Doe\"}"
```

JSON の名前と値の二重引用符は、`\` でエスケープします。上の実データは以下の通りです。

```
{"id":1, "name":"Jhon Doe"}
```


## 補足. 詳細表示（-v オプション）
HTTP のリクエストヘッダやレスポンスヘッダを表示したい場合は、`-v` オプションを付けると良さそうです。

```
> curl http://localhost/ -v
```
