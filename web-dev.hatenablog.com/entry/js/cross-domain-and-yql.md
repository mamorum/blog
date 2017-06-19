---
Title: JS：クロスドメインとYQL
Category:
- JavaScript
Date: 2017-06-19T11:25:54+09:00
URL: http://web-dev.hatenablog.com/entry/js/cross-domain-and-yql
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812271654568
---

Webアプリ（ブラウザ）のクロスドメイン問題と、その回避方法（1. レスポンスヘッダ、2. [YQL（Yahoo Query Language）](https://developer.yahoo.com/yql/) ）をまとめていこうかと思います。


## クロスドメイン問題とは？
あるドメイン（aaa.com）のページから、別ドメイン（bbb.com）への接続がブロックされる問題です。

img タグの src属性などは問題ないのですが、Ajax通信（XMLHttpRequest）などは、セキュリティ上の観点からブロックされます。


## 回避方法１. Access-Control-Allow-Origin: *
別ドメインのレスポンスヘッダに、`Access-Control-Allow-Origin: *` がついているとブロックされません。例えば、NHKニュース の RSS（[http://www3.nhk.or.jp/rss/news/cat0.xml](http://www3.nhk.or.jp/rss/news/cat0.xml)）はこれに該当してました。

[f:id:mamorums:20170619114037p:plain]

ただ、この方法はサーバサイド次第なところもあり、回避できない場合もあると思います。


## 回避方法2. YQL を利用
[YQL](https://developer.yahoo.com/yql/) というサービスを使う方法です。Google Feed API（サービス終了）の代替とする人も多く、使用方法などは以下の記事を参考にさせて頂きました。

[Google Feed API から YQL API へ移行したお話 - Qiita](http://qiita.com/nyatto/items/94c3f7cac14e8e8ef50f)

YQL を使うと、Yahoo ニュースの RSS（[https://news.yahoo.co.jp/pickup/rss.xml](https://news.yahoo.co.jp/pickup/rss.xml)）を以下のURLで取得することができました。 

[https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D'https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys](https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D'https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys)

※ YQL のレスポンスヘッダにも `Access-Control-Allow-Origin: *` が付いています。


## コード例
回避方法1 と 2 の例です。コードはローカルに保存（拡張子html）して、ダブルクリックで動くと思います。

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cross Domain</title>
</head>
<body>
<h2>NHK RSS</h2>
<textarea id="nhk-rss" cols="80" rows="10"></textarea>
<h2>Yahoo RSS (Using YQL)</h2>
<textarea id="yql-rss" cols="80" rows="10"></textarea>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
  $.ajax(  // 1.direct
    'http://www3.nhk.or.jp/rss/news/cat0.xml'
  ).done(function(data) {
    $('#nhk-rss').val(
      data.documentElement.innerHTML
    );
  });
  $.ajax(  // 2.yql
    "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20where%20url%3D'https%3A%2F%2Fnews.yahoo.co.jp%2Fpickup%2Frss.xml'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"
  ).done(function(data) {
    $('#yql-rss').val(
      data.documentElement.innerHTML
    );
  });
});
</script>
</body>
</html>
```

Ajax で取得した RSS を、テキストエリアに表示します。


## サンプルアプリ
回避方法1 と 2 を使ったフィードリーダー（自分用）です。

[Feed Paper](http://mamorum.github.io/feed-paper/public/)

ソースは GitHub にあります。

[feed-paper - GitHub](https://github.com/mamorum/feed-paper)

## 補足
他の回避方法として、自前のサーバサイドを用意する方法などもあると思います。
