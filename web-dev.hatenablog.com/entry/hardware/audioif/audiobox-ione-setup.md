---
Title: AudioBox iOne のセットアップ
Category:
- ハード
Date: 2018-10-25T21:56:00+09:00
URL: https://web-dev.hatenablog.com/entry/hardware/audioif/audiobox-ione-setup
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132659492569
---

PreSonus の AudioBox iOne を、Windows の Studio One で使えるように、セットアップしていく方法を書いていきます。

[asin:B00OITHWDW:detail]

大まかな手順としては、

1. USBで接続
2. Universal Control のインストール
3. Studio One で使用

といった感じになります。

※ Studio One はインストール済みの前提で書いていきます。


## 事前準備
[My PreSonus](https://my.presonus.com/) にログインして、

- AudioBox iOne の登録
- Universal Control のダウンロード

をしておきます。

AudioBox iOne を登録すると、Universal Control がダウンロードできるようになります。登録した AudioBox iOne の詳細を表示すると、

[f:id:mamorums:20181025215748p:plain]

上のようにインストーラーがダウンロードできます。


## 手順1. USBで接続
AudioBox iOne を PC に USB で接続します。


## 手順2. Universal Control のインストール
ダウンロードしたインストーラを実行します。指示通り進めていくと、途中でコンポーネントを選択する画面が表示されるので、

[f:id:mamorums:20181025215847p:plain]

上のように「AudioBox USB Driver」だけチェックして、ボタン「インストール」を押します。


## 手順3. StudioOne で使用
Sutio One を起動すると、オーディオデバイスで AudioBox が選択できるようになります。

[f:id:mamorums:20181025215902p:plain]

これで使えるようになります。

Studio One のボタン「コントロールパネル」をクリックすると、先ほどインストールした Universal Control が表示されます。

