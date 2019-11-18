---
Title: Chrome：ダウンロードのブロック対応
Category:
- etc
Date: 2019-11-18T10:39:42+09:00
URL: https://web-dev.hatenablog.com/entry/etc/chrome-blocks-download
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613467582562
---

Chrome で ZIPファイルをダウンロードしたら、問題のないファイルでもブロックされることがありました。これからその詳細を書いていきます。


## 事象
ファイルをダウンロードすると「一般的にダウンロードされているファイルではなく、危害を及ぼす可能性があります。」というメッセージが表示されました。

[f:id:mamorums:20191118103012p:plain]

上の画像はその時のもので、左下にメッセージが表示されています。


## 原因
ネットで調べたところ、問題のないファイルでも、ダウンロード数が少ないファイルだと上のように表示される可能性があるみたいです。


## 対応方法
メッセージの右にあるボタンをクリックして、「継続」を選択するとダウンロードが再開されるようです。

[f:id:mamorums:20191118103727p:plain]


## 参考文献
[https://support.google.com/chrome/forum/AAAAG2AdvocWrmGKdmLgBA/?hl=ja:title]


