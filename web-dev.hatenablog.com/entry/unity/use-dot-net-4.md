---
Title: Unity：.NET4.xを使う（C#スクリプトのランタイム）
Category:
- Unity
Date: 2019-02-11T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/use-dot-net-4
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/98012380842661625
---

Unity の C#スクリプトで、ランタイムを .NET 4.x する方法を書いていきます。

環境は以下の通りで、

- Unity 2018.2.13f1
- Visual Studio 2017

ターゲットプラットフォームは PC（Standalone）です。


## 手順1. Player Settings を開く
Unity のメニューで `File` をクリックして、`Build Settings...` を選択します。

[f:id:mamorums:20190127231831p:plain]

上のウィンドウが表示されるので、ボタン `Player Settings...` をクリックします。これで、インスペクタに `Player Settings` が表示されます。


## 手順2. ランタイムバージョンの変更
インスペクタで `Other Settings` をクリックして、`Configuration` のところまで移動します。

[f:id:mamorums:20190127231841p:plain]

次に、上のように `Scripting Runtime Version` をクリックして、`.NET 4.x Equivalent` を選択します。変更すると再起動を求められるので、指示通りに進めます。


## 手順3. 確認
もう一度設定を開いて、`.NET 4.x Equivalent` になっていることを確認します。

[f:id:mamorums:20190127231852p:plain]

再起動すると、上の画像のように `Api Compatibility Level*` も `.NET 4.x` に変更されていました。


## 手順4. Visual Studio の再起動
最後に Visual Studio も再起動しておきます。

これで作業は完了です。

