---
Title: Unity開発環境：文字がにじむ場合の対応
Category:
- ゲーム
Date: 2018-06-07T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/unity/fix-editor-moji-boyake
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971651228228
---

Windows のディスプレイ設定（表示スケールの設定）で文字を大きくしていると、Unity の開発環境の文字がぼやけるすることがありました。これから、文字のにじみを修正する方法を書いていきます。


## 環境
OS と Unity のバージョンは以下の通りです。

- Windows10 64bit
- Unity 2018.1.1f1

Windows のスケール設定は「125%」にしていました。

[f:id:mamorums:20180605115852p:plain]


## 対応前
開発環境の文字は大きいんですが、少しぼやけている感じです。

[f:id:mamorums:20180605115931p:plain]

[f:id:mamorums:20180605115945p:plain]

上の画像のように、右クリックで表示されるメニューもぼやけていました。


## 対応後
文字は小さくなりますが鮮明になります。

[f:id:mamorums:20180605120003p:plain]

[f:id:mamorums:20180605120013p:plain]

__※ 注意事項__  
文字がぼやけてても大きいほうが良い場合は、今回の対応をしないほうが良いかと思います。


## 対応内容
Unity の開発環境（Unity エディタ）のアプリだけ、125% のスケーリングを無効にしました。対応手順は以下の通りです。

### 1. Unity.exe のプロパティを開く
Unity.exe を右クリックして、プロパティを選択します。

[f:id:mamorums:20180605120029p:plain]

Unity.exe は、デフォルトだと「`C:\Program Files\Unity\Editor`」にありました。

### 2. 高DIP設定を開く
プロパティのウィンドウで、互換性タブを選択して「高DIP設定の変更」をクリックします。

[f:id:mamorums:20180605120547p:plain]

### 3. スケールの上書きを有効にする
クリックすると下のウィンドウが表示されます。

[f:id:mamorums:20180605120556p:plain]

そこで「高いDPIスケールの動作を上書きします。」にチェックを入れます。あとは「OK」を押してウィンドウを閉じていきます。

これで Unity を起動すると、文字が鮮明になります。
