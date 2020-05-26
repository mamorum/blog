---
Title: GitHub Desktop：日本語入力がエリア外に表示される
Category:
- etc
Date: 2020-05-23T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/git/github/desktop-japanese-input
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613556790862
---

Windows10 で GitHub Desktop を使っていたら、日本語が入力エリア外に表示されることがありました。


## 事象
その時の画面イメージは以下の通りです。

[f:id:mamorums:20200427004616p:plain]

左の枠内で入力すると、右下に日本語が表示されます。

※ エリア外に表示されても、Enterを押せば左の枠内に反映されます。


## 対応方法
以下の手順だと、枠内で日本語を入力できました。

1. GitHub Desktop を起動
2. 他のアプリにフォーカスを当てる
3. 起動していた GitHub Desktop を使用

Alt+Tab やタスクバーで、他のアプリを選択してからだと大丈夫でした。


## 原因
今のところ、原因は分かっていません。
