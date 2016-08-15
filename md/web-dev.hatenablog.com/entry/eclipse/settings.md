---
Title: Eclipse：使いやくする設定
Category:
- Eclipse
Date: 2016-02-12T13:13:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/settings
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179020635
---

Eclipse を使いやすくする設定をいくつか書いていきます。興味のある設定を参考にして頂けると幸いです。

今回の設定は、Eclipse メニューの「ウインドウ（Window）→ プリファレンス（Preferences）」を開いて行います。


## エンコーディング
最近は UTF-8 に設定することが多そうです。Windows 7 だと MS932 がデフォルトでした。

![encoding](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092755.png)


## メモリ使用状況の表示
画面下に、Eclipse のヒープ使用状況が表示されます。

![heap-status](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092756.png)


## エディタの行数表示
行数は最初から表示されてた気もします。

![line-number](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092757.png)


## エディタの切り替え（Ctrl + Tab）
Sublime Text のように、`Ctrl + Tab` でエディタを切り替える設定です。まずは、キー（key）の設定で、次のエディタ（Next Editor）を検索してコピー（Copy Command）します。

![next-editor-copy](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092758.png)

コピーしたコマンドをクリックします。それから、バインディング（Binding）のテキストにフォーカスを当てて `Ctrl + Tab` を押します。

![next-editor-binding](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092759.png)

最後にOK を押して完了します。


## フォント
色とフォント（Colors and Fonts）で、基本（Basic）→ テキストフォント（Text Font）を設定します。設定を変更すると、色々なエディタのフォントが変わります。

![fonts](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092800.png)


## テーマ・背景色
Eclipse Color Theme を使うと、エディタの背景色を変更することができます。まずは、マーケットプレイスで Eclipse Color Theme をインストールします。

![eclipse-market](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092801.png)

それから、プリファレンスで好きなテーマを設定します。

![color-theme](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092802.png)
