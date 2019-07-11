---
Title: 解決済：YQLでフィードが取得できない
Category:
- JS/CSS/HTML
Date: 2017-09-05T09:40:24+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/yql-returns-no-feed
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812292069505
---

2017年の8/24～8/30頃まで、[YQL](https://developer.yahoo.com/yql/) でフィードが取得できないことがありました。この記事は、その詳細についてまとめています。


## 経過
- 8/24頃: フィードが取得できなくなった。
- 8/28頃: 何回か取得できたが安定しない。
- 8/30以降: フィードが取得できるようになった。

8/30くらいから、対応なしで復旧しました。フィード取得用のURL（YQL の API）は変更しなくて大丈夫そうです。


## 1. 事象
突然、YQL の API がエラーを返すようになりました。

### 1.1. API
該当の API（URL）は以下の通りです。

[https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D'https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys](https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D'https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys)

エラーになる前は、Yahoo ニュース（[https://news.yahoo.co.jp/pickup/rss.xml](https://news.yahoo.co.jp/pickup/rss.xml)）のフィードを返してくれていました。

### 1.2. エラー内容
レスポンスの XML には、`Bad Request` というメッセージがありました。

[f:id:mamorums:20170826101728p:plain]


## 2. エラー発生時の対応
今回は対応なしで復旧したんですが、フィードが取得できないときに試したことを残しておきます。

### 2.1. 対応
YQL コンソールで API（URL）を再作成しました。

[f:id:mamorums:20170826101747p:plain]

`Test` ボタンを押すと、`Formatted View` にフィードが表示されました。一番下の `THE REST QUERY` が再作成した API になります。

[https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D%22https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml%22](https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D%22https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml%22)


### 2.2. 結果
新しい API（URL）でも、フィードは取得できませんでした。エラー内容は以下の通りす。

[f:id:mamorums:20170826101805p:plain]

エラーではないんですが、中身が空っぽみたいです。YQL コンソールの結果と異なるようです。


## 関連記事
[JS：クロスドメインとYQL](/entry/js/cross-domain-and-yql)
