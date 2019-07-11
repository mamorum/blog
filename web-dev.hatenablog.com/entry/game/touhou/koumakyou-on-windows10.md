---
Title: 東方紅魔郷：Windows10でプレイする方法
Category:
- ゲーム
Date: 2019-05-07T12:58:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/koumakyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600099675
---

東方Project の紅魔郷を、Windows10 64bit で動かしてプレイする方法をまとめていきます。

※ フルスクリーンで遊ぶ手順を書いています。


## 前提・環境
現在使用中のPCスペックは以下の通りです。

- CPU: Intel Core i5-7400 3.0GHz
- GPU: Intel HD Graphics 630（オンボード）
- 記憶装置: メモリ8GB（4GB × 2）, SSD256GB

Windows10 のバージョンは以下の通りでした。

- エディション：Windows 10 Home（64bit）
- バージョン：1809
- インストール日：2018/10/22
- OS ビルド：17763.475

※ 他の環境で動くかは検証できていません。ご了承頂ければと思います。


## 手順1. 紅魔郷のインストール
紅魔郷をインストールして、最新版のアップグレードパッチを適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c (June 2010) のランタイムをインストールしておきます。手順は以下の記事にも書いてあります。

[DirectX 9.0c：Windows10にインストール](https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10)

インストール済みの場合は、スキップして頂いて大丈夫です。


## 手順3. 設定変更
紅魔郷をインストールしたフォルダ内の `custom.exe` を実行して、

- 強制的に６０フレームにする
- フルスクリーン

をチェックしている感じにします。

[f:id:mamorums:20180711091017p:plain]


## 手順4. プロパティ設定
上と同じフォルダ内の `東方紅魔郷.exe` を右クリックして、

[f:id:mamorums:20180711091032p:plain]

プロパティを選択します。

ウィンドウが開いたら、互換性タブをクリックして、

- 640×480の解像度で実行する

をチェックします。

[f:id:mamorums:20180711091054p:plain]


## 手順5. DirectX コンバータの配置
DirectX のレンダリングを 8 から 9 に変換してくれるコンバーターを、紅魔郷をインストールしたフォルダに配置（コピー）します。手順は以下のリンク先に書いてあります。

[DirectX：コンバーターのインストール（ver8 to 9）](https://web-dev.hatenablog.com/entry/game/directx/install-converter)


## 手順6. 遊ぶ
紅魔郷を起動してプレイします。


## 補足1. ゲームパッド
自分は「HORI EDGE 301」を使っていて、下のリンク先にレビューを書いています。

[https://web-dev.hatenablog.com/entry/hardware/gamepad/hori-edge-301:embed:cite]

軽くて十字キーも使えるのでありがたいです。


## 補足2. ゲーム終了後
タイトル画面で Quit を押すと、少しだけ画面表示（OS のウィンドウなどが）が大きくなることがあります。その場合は、少し待てば大丈夫です。

あと、ゲーム起動前に表示していた、

- ウィンドウ
- ウィンドウの文字

が、下の画像のように小さくなることがあります。

[f:id:mamorums:20180711091110p:plain]

この場合、ウィンドウを一度閉じて開きなおすと元に戻ったりします。


## 参考文献
- [Windows10 Creators Update後に東方紅魔郷を動かすメモ - さぴまが](http://ch.nicovideo.jp/sapils275/blomaga/ar1236895)
- [【紅魔郷・妖々夢・永夜抄・花映塚】東方をWindows10環境でフルスクリーン【萃夢想・文花帖】- null](http://ch.nicovideo.jp/k2snd/blomaga/ar1004442)
