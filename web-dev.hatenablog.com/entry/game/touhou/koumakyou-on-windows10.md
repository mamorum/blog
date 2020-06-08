---
Title: 東方紅魔郷：Windows10でプレイする方法
Category:
- ゲーム
Date: 2020-06-08T04:15:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/koumakyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600099675
---

東方Project の紅魔郷を、Windows10 64bit でプレイする方法をまとめていきます。

※ フルスクリーンで遊ぶ手順を書いています。


## 注意点
- 非公式の手順で、動作しないＰＣもあります。
- 作品未購入の場合は、体験版での動作確認をお勧めします。


## 参考文献
以下のページを参考にさせて頂きました。

- <a target="_blank" href="http://ch.nicovideo.jp/sapils275/blomaga/ar1236895">Windows10 Creators Update後に東方紅魔郷を動かすメモ</a>
- <a target="_blank" href="http://ch.nicovideo.jp/k2snd/blomaga/ar1004442">【紅魔郷・妖々夢・永夜抄・花映塚】東方をWindows10環境でフルスクリーン</a>

また、コメント欄（ページ下部）で、個別のトラブル解決方法が報告されています。必要に応じて、リンク先やコメントを参照して頂ければと思います。


## 環境
以下の環境で動作を確認しました。

- OS: Win10 Home 64bit Version2004
- PC: ASUS VC66-BB062M
- CPU: Intel Core i5-7400 3.0GHz
- GPU: Intel HD Graphics 630
- メモリ: 8GB（4GB × 2）
- ストレージ: SSD256GB

PCはベアボーンで、GPUはオンボードです。


## 手順1. 紅魔郷のインストール
紅魔郷をインストールして、[最新版のアップグレードパッチ](https://www16.big.or.jp/~zun/html/th06.html) を適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c June 2010 のランタイムをインストールしておきます。

[https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10:embed:cite]


## 手順3. 設定変更
紅魔郷をインストールしたフォルダ内の `custom.exe` を実行すると画面が表示されるので、

[f:id:mamorums:20200608041105p:plain]

- 強制的に６０フレームにする
- フルスクリーン
- 毎回（通常）
- 32Bits

が選択されている状態で、決定ボタンをクリックします。

※ 「強制的に６０フレームにする」のチェックが外れてても正常に動きました。あと、以前は画面モード「16Bits」でも動いた気がしたのですが、今は「32Bits」にしないとエラー終了しました。色々と試してみると良い気がします。


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

