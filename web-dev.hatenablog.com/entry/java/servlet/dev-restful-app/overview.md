---
Title: Servletアプリ開発：1.概要
Category:
- Java
Date: 2017-11-08T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315253575
---

記事「Servletアプリ開発」でつくるアプリ（RESTful API）の概要や仕様について書いていきます。

## 機能
短いテキスト「メモ」の「表示・作成・更新・削除」ができるアプリになります。


## API
機能ごとに４つのAPIを準備することにしてます。詳細は以下の通りです。

|    機能    | リクエストメソッド | リクエストURI |
|-----------|-----------------------|------------------|
| 全件表示 | GET                       | /memo            |
| 作成       | POST                      | /memo            |
| 更新       | PUT                        | /memo/:id      |
| 削除       | DELETE                  | /memo/:id      |

リクエストURIの「`:id`」は、0, 1, 2... などの数字になります。更新したいメモのIDや、削除したいメモのIDが入ります。

APIの処理が正常終了したら、HTTPステータス200を返します。あと、全件表示などはメモのデータをレスポンスボディに設定して返します。データの形式は JSON にしようと思います。


## 画面について
現時点では画面がなくて、API だけ実装しています。そのうちメモを入力したり、API を呼び出したりできる画面を追加したいと思います。


## データについて
現時点ではDBなどにメモを永続化せず、メモリでメモを保持するようにしています。Servlet のことを中心に書いていこうと思って、DBアクセス等は省略しています。


## 環境について
開発環境としては、JDK8・Maven がインストールされていることが前提となります。

- [JDK のインストール方法など](/entry/java/jdk/table-of-contents)
- [Maven のインストール方法など](/entry/maven/table-of-contents)

あと、Eclipse などの IDE をインストールしておくと便利だったりします。

- [Eclipse のインストール方法など](/entry/eclipse/table-of-contents)
