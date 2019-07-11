---
Title: Unity：EXE名の変更（プロダクト名変更）
Category:
- Unity
Date: 2019-03-05T08:54:18+09:00
URL: https://web-dev.hatenablog.com/entry/unity/build/change-exe-name
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117126988049797
---

Unity で開発したゲーム（アプリ）の、EXE名（プロダクト名）を変更する方法を書いていきます。


## 手順1. Build Settings を開く
Unity の開発環境で、メニューの「File」を開いて「Build Settings」をクリックします。

[f:id:mamorums:20190305085343p:plain]


## 手順2. Build Settings を開く
ウィンドウが開いたら、左下の「Player Settings」をクリックします。

[f:id:mamorums:20190305085355p:plain]


## 手順3. Product Name の変更
インスペクタに「Player Settings」が表示されるので、EXE名を「Product Name」に入力します。

[f:id:mamorums:20190305085406p:plain]

設定を保存してビルドすると、EXE名が入力した文字列になります。
