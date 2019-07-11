---
Title: Gimp：起動画面の変更（スプラッシュ変更）
Category:
- etc
Date: 2019-01-21T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gimp/change-splashscreen
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132690937675
---

画像編集ソフトの GIMP で、スプラッシュスクリーンを変更する方法を書いていきます。


## 変更後のイメージ
スプラッシュを変えると、GIMP 起動時の画像が変わります。

[f:id:mamorums:20181227142853p:plain]

変更前のデフォルトだと、キノコの画像が表示されてました。


## 前提
以下の環境で動作確認しました。

- Windows10（64bit）
- GIMP 2.10.8


## 画像の場所
Windows の場合、以下の場所にスプラッシュの PNGファイルがありました。

- フォルダ：`C:\Program Files\GIMP 2\share\gimp\2.0\images`
- ファイル：`gimp-splash.png`


## 画像の準備
上の画像を元に、表示させたい画像を準備します。上のフォルダは管理者権限が必要なので、他の場所で画像を編集・準備したほうが良さそうです。

自分はこんな感じのファイルを準備してみました。

[f:id:mamorums:20181227142755p:plain]

オリジナルのサイズは、`1920×1080（ピクセル）` でした。


## 画像の上書き
準備した画像を、先ほどの場所に同じ名前で上書きします。元のファイルは必要に応じてバックアップしておきます。


## 参考文献
[6. 自分流のスプラッシュスクリーン - GIMP](https://docs.gimp.org/2.10/ja/customize-splashscreen.html)
