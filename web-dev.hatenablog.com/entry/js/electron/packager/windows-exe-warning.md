---
Title: Electron：アプリ実行時の警告（windows, exe）
Category:
- JS
Date: 2018-03-06T13:57:16+09:00
URL: https://web-dev.hatenablog.com/entry/js/electron/packager/windows-exe-warning
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971622555977
---

Electron アプリをネットからダウンロードして実行すると、Windows10 の警告が出てきました。これからその内容と、アプリの実行方法についてまとめていきます。


## アプリの詳細
[electron-packager](https://github.com/electron-userland/electron-packager) でパッケージングしたアプリになります。

Windows 向けのパッケージを GitHub のリリースページで公開していて、ダウンロード後に exe を実行するとアプリが起動します。


## 警告
Windows10 だと、以下の警告が出ました。

[f:id:mamorums:20180306135628p:plain]


## アプリの実行方法
上画面の「詳細情報」をクリックすると、画面の内容が変わって下のようになります。

[f:id:mamorums:20180306135641p:plain]

そこで「実行」を押すとアプリが起動しました。
