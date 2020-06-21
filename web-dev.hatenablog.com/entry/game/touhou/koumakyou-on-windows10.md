---
Title: 東方紅魔郷：Windows10でプレイする方法
Category:
- ゲーム
Date: 2020-06-09T22:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/koumakyou-on-windows10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132600099675
---

東方Project の紅魔郷を、Windows10 64bit でプレイする方法をまとめていきます。


## 注意点
- 非公式の手順で、動作しないＰＣもあります。
- 作品未購入の場合は、体験版での動作確認をお勧めします。


## 参考文献
以下のページを参考にさせて頂きました。

- <a target="_blank" href="http://ch.nicovideo.jp/sapils275/blomaga/ar1236895">Windows10 Creators Update後に東方紅魔郷を動かすメモ</a>
- <a target="_blank" href="http://ch.nicovideo.jp/k2snd/blomaga/ar1004442">【紅魔郷・妖々夢・永夜抄・花映塚】東方をWindows10環境でフルスクリーン</a>

また、コメント欄（ページ末尾）で、動作確認の結果やトラブル解決方法を書いてくれた方々がいます。動かない場合は、上のページやコメント欄を参照して頂ければと思います。


## 環境
以下の環境で動作を確認しました。

- OS: Win10 Home 64bit Version1903
- PC: ASUS VC66-BB062M
- CPU: Intel Core i5-7400 3.0GHz
- GPU: Intel HD Graphics 630
- メモリ: 8GB（4GB×2）
- ストレージ: SSD256GB
- モニター: DELL P2719H（1920×1080 @60Hz）

PCはベアボーンで、GPUはオンボードです。


## 手順1. 紅魔郷のインストール
紅魔郷をインストールして、[最新版のアップグレードパッチ](https://www16.big.or.jp/~zun/html/th06.html) を適用しておきます。


## 手順2. DirectX9 のインストール
DirectX 9.0c June 2010 のランタイムをインストールしておきます。手順は下のリンク先にもまとめています。

[https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10:embed:cite]


## 手順3. コンバーターのインストール
DirectX のレンダリングを 8 から 9 に変換する資源を、紅魔郷のインストール先に配置（コピー）します。

[https://web-dev.hatenablog.com/entry/game/directx/install-converter:embed:cite]


## 手順4. 設定変更
インストール先の `custom.exe` を実行して、

[f:id:mamorums:20200608041105p:plain]

- 強制的に６０フレームにする
- 毎回（通常）
- 32Bits

を選択した状態で、決定ボタンをクリックします。


## 手順5. 解像度設定
※ フルスクリーンの場合だけ解像度設定をします。

紅魔郷をインストールしたフォルダ内の `東方紅魔郷.exe` を右クリックして「プロパティ」を選択します。

[f:id:mamorums:20180711091032p:plain]

ウィンドウが開いたら「互換性」のタブをクリックして、

[f:id:mamorums:20200224135621p:plain]

- 640×480の解像度で実行する

にチェックを入れて、OKボタンを押します。


## 手順6. 遊ぶ
紅魔郷を起動してプレイします。


## 補足1. ゲームパッド
下の記事に、使用できたパッドを紹介してます。

[https://web-dev.hatenablog.com/entry/hardware/gamepad/hori:embed:cite]

家庭用ゲーム機のコントローラーは試せてないです。


## 補足2. ゲーム終了後
タイトル画面で Quit を押すと、少しだけ画面表示（OS のウィンドウなどが）が大きくなることがあります。その場合は、少し待てば大丈夫です。

あと、ゲーム起動前に表示していた、

- ウィンドウ
- ウィンドウの文字

が、下の画像のように小さくなることがあります。

[f:id:mamorums:20180711091110p:plain]

この場合、ウィンドウを一度閉じて開きなおすと元に戻ったりします。

