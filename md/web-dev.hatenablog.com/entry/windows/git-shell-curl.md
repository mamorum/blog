---
Title: Windows：git の curl を使う
Category:
- Windows
Date: 2017-03-10T11:14:18+09:00
URL: http://web-dev.hatenablog.com/entry/windows/git-shell-curl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687225591527
---

Windows に [GitHub Desktop](https://desktop.github.com/) などをインストールしている場合、Git Shell で `curl` を使うことができました。今回は、その手順を書いていきます。

## 手順1. Git Shell を起動
Windows のスタートメニューから、GitHub Desktop などに付属している Git Shell を起動します。

[f:id:mamorums:20170310111321p:plain]


## 手順2. curl を実行
起動した PowerShell で `curl` を使います。

下の画像は、コマンド `which curl` と `curl www.google.co.jp` を実行したときのものです。

[f:id:mamorums:20170310111331p:plain]

PowerShell のバージョンが古くて警告が出ているのと、日本語の文字化けがちょっと気になるところです。PowerShell のバージョンが新しいと、日本語の文字化けも解消されそうでした。


## 関連記事
- [Windows：cURL のインストール](/entry/windows/install-curl)
