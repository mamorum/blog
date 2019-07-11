---
Title: 東方妖々夢・永夜抄：Windows10でプレイする方法
Category:
- ゲーム
Date: 2019-05-08T11:52:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/youyoumu-and-eiyasyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600422620
---

東方Project の妖々夢と永夜抄を、Windows10 で動かしてプレイする方法をまとめていきます。

※ フルスクリーンで遊ぶ手順を書いています。


## 前提
以下の記事に、使用中のPCスペックや、OSのバージョン・ビルド番号などを書いています。

[紅魔郷：Windows10でプレイする方法](/entry/game/touhou/koumakyou-on-windows10)

※ 他の環境で動くかは検証できていません。ご了承頂ければと思います。


## 手順1. インストール
妖々夢（or 永夜抄）をインストールして、最新版のアップグレードパッチを適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c (June 2010) のランタイムをインストールしておきます。手順は以下の記事にも書いてあります。

[DirectX 9.0c：Windows10にインストール](https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10)

インストール済みの場合は、スキップして頂いて大丈夫です。


## 手順3. 設定変更
インストールしたフォルダ内の `custom.exe` を実行して、

- ウィンドウスタイル：フルスクリーン
- 描画間隔：毎回

をチェックしている感じにします。既にチェックされていたら、そのままで大丈夫です。

[f:id:mamorums:20180712111815p:plain]

画像の上が妖々夢で、下が永夜抄です。


## 手順4. プロパティ設定
妖々夢（+ 永夜抄）をインストールしたフォルダ内の `th07.exe`（+ `th08.exe`）を右クリックして、

[f:id:mamorums:20180712111826p:plain]

プロパティを選択します。

ウィンドウが開いたら、互換性タブをクリックして、

- 640×480の解像度で実行する

をチェックします。

[f:id:mamorums:20180712111841p:plain]

画像の左が妖々夢で、右が永夜抄です。


## 手順5. DirectX コンバータの配置
DirectX のレンダリングを 8 から 9 に変換する資源を、妖々夢（or 永夜抄）をインストールしたフォルダに配置（コピー）します。手順は以下のリンク先に書いてあります。

[DirectX：コンバーターのインストール（ver8 to 9）](https://web-dev.hatenablog.com/entry/game/directx/install-converter)


## 手順6. 遊ぶ
妖々夢（or 永夜抄）を起動してプレイします。


## 補足
ゲーム終了時に、ちょっとだけ画面が大きくなったり乱れることがあります。詳細は、[紅魔郷の記事](/entry/game/touhou/koumakyou-on-windows10) の「注意事項」に記載しています。
