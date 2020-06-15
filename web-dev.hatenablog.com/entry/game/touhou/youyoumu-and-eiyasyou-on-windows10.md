---
Title: 東方妖々夢・永夜抄：Windows10でプレイする方法
Category:
- ゲーム
Date: 2020-06-14T22:15:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/youyoumu-and-eiyasyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600422620
---

東方Project の妖々夢と永夜抄を、Windows10 で動かしてプレイする方法をまとめていきます。

※ フルスクリーンで遊ぶ手順を書いています。


## 前提
同じ OS でも動かない場合があります。注意点などを下の記事に書いているので、事前に参照して頂けると嬉しいです。

[https://web-dev.hatenablog.com/entry/game/touhou/koumakyou-on-windows10:embed:cite]


## 手順1. インストール
妖々夢（or 永夜抄）をインストールして、最新版のアップグレードパッチを適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c (June 2010) のランタイムをインストールしておきます。

[https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10:embed:cite]


## 手順3. 設定変更
インストールしたフォルダ内の `custom.exe` を実行して、

[f:id:mamorums:20180712111815p:plain]

- ウィンドウスタイル：フルスクリーン
- 描画間隔：毎回

を選択した状態で、決定をクリックします。


## 手順4. プロパティ設定
インストールしたフォルダ内の `th07.exe`（or `th08.exe`）を右クリックして、プロパティを選択します。

[f:id:mamorums:20180712111826p:plain]

下のようなウィンドウが開くので、互換性タブをクリックして、

[f:id:mamorums:20180712111841p:plain]

- 640×480の解像度で実行する

をチェックします。


## 手順5. DirectX コンバータのインストール
DirectX のレンダリングを 8 から 9 に変換する資源をインストールします。

[https://web-dev.hatenablog.com/entry/game/directx/install-converter:embed:cite]

妖々夢と永夜抄、両方のフォルダにそれぞれ資源をコピーする感じです。


## 手順6. 遊ぶ
ゲームを起動してプレイします。


## 補足1. ゲームパッド
下の記事に、使用できたパッドを書いています。

[https://web-dev.hatenablog.com/entry/hardware/gamepad/hori:embed:cite]


