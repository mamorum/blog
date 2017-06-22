---
Title: JS：クロスドメインとiframe
Category:
- JavaScript
Date: 2017-06-22T14:54:09+09:00
URL: http://web-dev.hatenablog.com/entry/js/cross-domain-and-iframe
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812272842522
---

Webページ（JS）から、違うドメインの XML（RSS フィード）を取得したいことがありました。そこで、iframe で別ドメインの XML を取得して、その内容を操作できないか検証してみました。


## 検証結果
結果としては、エラーが発生して無理そうでした。


## エラー内容
Chrome のコンソールに次のようなエラーが表示されました。

```
Uncaught DOMException:
 Failed to read the 'contentDocument' property
 from 'HTMLIFrameElement':
Blocked a frame with origin "http://localhost:3000"
 from accessing a cross-origin frame.
```

`http://localhost:3000/index.html` で iframe（`src="https://news.yahoo.co.jp/pickup/rss.xml"`）の内容を操作するところでエラーが発生しました。（iframe の枠には一応 `src` のコンテンツが表示できてました。）


## コード
検証で使ったコードは、GitHub にあります。

[cdi - GitHub](https://github.com/mamorum/blog/tree/master/code/js/cdi)

iframe で同じドメインの XML を取得した場合は、エラー発生せずに操作できました。


## 関連記事
[JS：クロスドメインとYQL](/entry/js/cross-domain-and-yql)

iframe はダメだったので、YQL（Yahoo Query Language）というサービスを使ってクロスドメインの XML を取得しました。YQL は Google Feed API の代替みたいな感じで使えました。
