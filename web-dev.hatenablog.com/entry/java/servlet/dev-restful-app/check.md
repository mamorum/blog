---
Title: Servletアプリ開発：5.動作確認
Category:
- Java
Date: 2017-11-12T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/check
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315996787
---

[前回](/entry/java/servlet/dev-restful-app/java2) までに開発したサーブレットアプリ（RESTful API）を起動して、手動で動作確認をしていこうと思います。

※ サーブレットアプリの概要は、以下のリンク先に書いてあります。

[Servletアプリ開発：1.概要](/entry/java/servlet/dev-restful-app/overview)


## 前提
動作確認は `curl` を使ってサーブレットに Httpリクエストを送信します。

[Windows：cURL のインストール](/entry/windows/install-curl)


## アプリの起動
`pom.xml` で定義していた Jetty Maven Plugin でアプリを起動します。

```
servlet-rest> mvn jetty:run
```

上のコマンドを `servlet-rest` ディレクトリで実行します。実行すると、コンテナ（Jetty）とサーブレットアプリが起動します。


## メモの登録
以下のコマンドでメモを登録してみます。

```
> curl http://localhost:8080/memo -X POST -d "txt=Memo1"
```

コマンドの内容は以下の通りです。

- `-X POST`: Http メソッドは POST
- `-d "txt=Memo1"`: リクエストパラメータ

メモを登録できると、以下のようなレスポンスが返ってきます。

```
{"memo":{"id":0,"txt":"Memo1","updated":"Nov 9, 2017 9:13:54 AM","created":"Nov 9, 2017 9:13:54 AM"}}
```

複数件登録することもできます。

```
> curl http://localhost:8080/memo -X POST -d "txt=Memo2"
```


## メモの参照
以下のコマンドでメモを参照（全件取得）できます。

```
> curl http://localhost:8080/memo -X GET
{"memo":[{"id":0,"txt":"Memo1","updated":"Nov 9, 2017 9:13:54 AM","created":"Nov 9, 2017 9:13:54 AM"},{"id":1,"txt":"Memo2","updated":"Nov 9, 2017 9:15:01 AM","created":"Nov 9, 2017 9:15:01 AM"}]}
```

複数件登録していると、レスポンスの memo も複数返ってきます。


## メモの更新
以下のコマンドで、ID が 0 のメモを更新します。

```
> curl http://localhost:8080/memo/0 -X PUT -d "txt=Memo0" -v

*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> PUT /memo/0 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.46.0
> Accept: */*
> Content-Length: 9
> Content-Type: application/x-www-form-urlencoded
>
* upload completely sent off: 9 out of 9 bytes
< HTTP/1.1 200 OK
< Date: Thu, 09 Nov 2017 00:23:05 GMT
< Content-Length: 0
< Server: Jetty(9.4.6.v20170531)
<
* Connection #0 to host localhost left intact
```

`-v` オプションで HTTP ヘッダの内容を表示してみました。結果はステータス200なので、処理が正常に終了しています。


## メモの削除
以下のコマンドで、ID が 1 のメモを削除します。

```
> curl http://localhost:8080/memo/1 -X DELETE -v

*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> DELETE /memo/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.46.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Thu, 09 Nov 2017 00:25:26 GMT
< Content-Length: 0
< Server: Jetty(9.4.6.v20170531)
<
* Connection #0 to host localhost left intact
```

こちらも正常終了しています。


## 更新・削除の確認
最後にもう一度メモを全件取得してみます。

```
> curl http://localhost:8080/memo -X GET
{"memo":[{"id":0,"txt":"Memo0","updated":"Nov 9, 2017 9:23:05 AM","created":"Nov 9, 2017 9:13:54 AM"}]}
```

先に登録したメモ（id=0）が更新されて、後に登録したのは削除されています。


## アプリの終了
`mvn jetty:run` で起動したアプリは、`Ctrl+C` を押すと終了します。アプリを終了すると、登録したメモのデータが（メモリから）消えます。
