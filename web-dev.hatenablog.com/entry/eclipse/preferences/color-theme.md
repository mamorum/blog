---
Title: Eclipse：カラーテーマの変更
Category:
- Java
Date: 2017-06-07T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/preferences/color-theme
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958055337536
---

Eclipse のカラーテーマ（Color Theme）を変更する方法を書いていきます。今回は例として、エディタの背景色と文字色を Sublime Text に設定してみます。


## 手順1. Eclipse Color Theme のインストール
メニュバーの「Help → Eclipse Marketplace」でマーケットプレイスを開きます。

次に「color theme」検索して、Eclipse Color Theme をインストールします。

![eclipse-market](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092801.png)

Install ボタンを押して、指示通りインストールと再起動を行います。


## 手順2. Color Theme の設定
メニューバーの「ウィンドウ（Window）」から「プリファレンス（Preferences）」を開きます。

そこで「Color Theme」を選択して、Sublime Text 2 に設定します。

![color-theme](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092802.png)


## 補足1. Search Results の色
デフォルトの設定だと、検索結果（Search Results）のハイライトが白くて見づらかったりします。

[f:id:mamorums:20170613081337p:plain]

Preferences の Annotations を開いて、 Search Results の色を黒などにすると見やすいかと思います。

[f:id:mamorums:20170613081351p:plain]


## 補足2. Current line の色
あと、フォーカスを当てている行（Current line highlight）も明るいと見づらかったりします。

[f:id:mamorums:20170613081404p:plain]

Preferences の Text Editors を開いて、Current line highlight で変更することができます。
