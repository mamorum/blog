---
Title: 東方紅魔郷：Windows10でプレイする方法
Category:
- ゲーム
Date: 2020-02-24T14:35:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/koumakyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600099675
---

東方Project の紅魔郷を、Windows10 64bit で動かしてプレイする方法をまとめていきます。

※ フルスクリーンで遊ぶ手順を書いています。


## 参考文献等
手順をまとめる際に、以下のページを参考にさせて頂きました。

[http://ch.nicovideo.jp/sapils275/blomaga/ar1236895:embed:cite]

[http://ch.nicovideo.jp/k2snd/blomaga/ar1004442:embed:cite]

また、コメント欄（ページ下部）で、個別のトラブル解決方法などを報告して下さった方もいます。必要に応じて、上の記事やコメントを参考にして頂ければと思います。


## 環境・注意点
以下の環境で動作を確認しました。

- OS: Win10 64bit Version1903
- CPU: Intel Core i5-7400 3.0GHz
- GPU: Intel HD Graphics 630（オンボード）
- 記憶装置: メモリ8GB（4GB × 2）, SSD256GB

他のPCで動くかは分かりません。作品未購入の場合は、体験版で動作確認して頂いたほうが良いかと思います。


## 手順1. 紅魔郷のインストール
紅魔郷をインストールして、[最新版のアップグレードパッチ](https://www16.big.or.jp/~zun/html/th06.html) を適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c June 2010 のランタイムをインストールしておきます。

[https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10:embed:cite]


## 手順3. 設定変更
紅魔郷をインストールしたフォルダ内の `custom.exe` を実行すると画面が表示されるので、

[f:id:mamorums:20200224133949p:plain]

- 強制的に６０フレームにする
- フルスクリーン

をチェックして、決定ボタンをクリックします。


## 手順4. プロパティ設定
上と同じフォルダ内の `東方紅魔郷.exe` を右クリックして「プロパティ」を選択します。

[f:id:mamorums:20180711091032p:plain]

ウィンドウが開いたら「互換性」のタブをクリックして、

[f:id:mamorums:20200224135621p:plain]

- 640×480の解像度で実行する

にチェックを入れて、OKボタンを押します。


## 手順5. DirectX コンバータの配置
DirectX のレンダリングを 8 から 9 に変換してくれるコンバーターを、紅魔郷をインストールしたフォルダに配置（コピー）します。手順は下のリンク先に書いてあります。

[https://web-dev.hatenablog.com/entry/game/directx/install-converter:embed:cite]


## 手順6. 遊ぶ
紅魔郷を起動してプレイします。


## 補足1. ゲームパッド
最近は「HORI ファイティングコマンダー」を使っています。

[https://web-dev.hatenablog.com/entry/hardware/gamepad/hori-fighting-commander:embed:cite]

以前は「HORI EDGE 301」を使っていました。

[https://web-dev.hatenablog.com/entry/hardware/gamepad/hori-edge-301:embed:cite]

自分の環境だと、どちらも十字キーを使えました。

家庭用ゲーム機のコントローラーも使ってみたいんですが手を出せていません。


## 補足2. ゲーム終了後
タイトル画面で Quit を押すと、少しだけ画面表示（OS のウィンドウなどが）が大きくなることがあります。その場合は、少し待てば大丈夫です。

あと、ゲーム起動前に表示していた、

- ウィンドウ
- ウィンドウの文字

が、下の画像のように小さくなることがあります。

[f:id:mamorums:20180711091110p:plain]

この場合、ウィンドウを一度閉じて開きなおすと元に戻ったりします。

