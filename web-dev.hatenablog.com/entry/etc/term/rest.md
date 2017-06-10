---
Title: 用語：REST, RESTful Webサービス
Category:
- etc
Date: 2016-03-18T22:25:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/term/rest
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178928733
---

REST，RESTful Webサービス といった用語や、RESTの設計原則，RESTの具体例 について、少しまとめてみました。


## REST とは？
REST は「REpresentational State Transfer」の略で、Roy Fielding 氏が提唱した「分散システム（ネットワークベース）の設計原則」です。


## RESTful Webサービスとは？
RESTful Webサービスは、RESTの設計原則に沿って実装された Webサービスのことです。


## RESTの設計原則
Web サービスに適用される、RESTの設計原則は次の通りです。

- リソースを一意に識別する URI を用いる。
- インターネットのメディアタイプでデータを転送する（JSON, XML, Atom, etc）。
- 標準的な HTTPメソッド（POST, GET, PUT, DELETE）と、操作（CRUD）を関連付ける。
- 等々。


## RESTの具体例
具体的な URI と HTTP メソッドを使って、RESTful Webサービスの例（インターフェイス）をまとめてみました。

### URI が http://・・・/resouces/item17 の場合
- POST：あまり使わない
- GET：特定のリソース item17 を返却（Read）
- PUT：特定のリソース item17 を更新（Update）
- DELETE：特定のリソース item17 を削除（Delete）

### URI が http://・・・/resouces/ の場合
- POST：リソースに要素を追加（Create）
- GET：リソースを全て返却（Read）
- PUT：リソースを全て更新（Update）
- DELETE：リソースを全て削除（Delete）

HTTP リクエストパラメータは、Read の条件だったり、Create の値になったりします。


## 参考文献
[REST - Wikipedia](https://ja.wikipedia.org/wiki/REST)

[Representational state transfer - Wikipedia, the free encyclopedia](https://en.wikipedia.org/wiki/Representational_state_transfer)
