---
Title: Eclipse：行末尾の空白削除
Category:
- Java
Date: 2017-06-02T14:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/preferences/remove-trailing-space
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958055340953
---

Eclipse の Javaエディタでファイルを保存する際に、行末尾の空白を自動で削除する方法を書いていきます。

設定前に、メニューバーの ウィンドウ（Window）から、プリファレンス（Preferences）を開いておきます。

## 手順1. Save action の有効化
Preferences で Save Actions を開いて、以下のチェックボックスをチェックします。

- Perform the selected actions ...（一番上）
- Additional actions（一番下）

[f:id:mamorums:20170613083251p:plain]


## 手順2. 空白削除の有効化
上の画面で Configure ボタンを押すと、新しいウィンドウが開きます。そこで、Remove trailing whitespace にチェックを入れます。

[f:id:mamorums:20170613083304p:plain]


## 補足. デフォルトの Save action
デフォルトだと、空白削除以外の保管アクション（アノテーションやキャスト関連）が有効になっています。

不要な場合はそれらの設定を削除しておきます。自分も保管アクションは空白削除だけにしています。
