MuseScore を使っていて、音符にドレミ（補助）をつけてくれる [Shakuhachi notation](https://musescore.org/en/project/shakuhachi)（[※日本語ページ](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/)）という素晴らしいプラグインを見つけました。下の画像は、**Shakuhachi notation** で楽譜にドレミをつけたイメージです。

result

これから、**Shakuhachi notation** のインストール手順（Windows 7 の 64bit）と、使用方法を書いていこうと思います。


## 手順1. ダウンロード
[Shakuhachi notation の 日本語ページ](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/) から、プラグインとフォントをダウンロードします。

### 1.1. プラグイン
`Shakuhachi_Notation_v2_02.qml` というプラグインをダウンロードします。（下の画像は日本語ページの抜粋です。青字のリンクからダウンロードします。）

plg

### 1.2. フォント
ドレミのフォントを２つダウンロードします。名前は `Doremi.ttf` と `Doremib.ttf` になります。（下の画像は日本語ページの抜粋です。7. と 8. がダウンロード対象です。）

font


## 手順2. インストール
ダウンロードしたプラグインとフォントをインストールします。

### 2.1. プラグイン
`Shakuhachi_Notation_v2_02.qml` を `C:\Program Files (x86)\MuseScore 2\plugins` にコピーします。

cp

### 2.2. フォント
フォントを保存した場所で、ファイルの上で右クリックして「インストール」を選択します。

inst

この操作は、ファイル２つ（`Doremi.ttf` と `Doremib.ttf`）に対して行います。


## 手順3. MuseScore での設定
MuseScore を起動して、メニューの「プラグイン → プラグインマネージャ」をクリックします。

pm

上のようなウィンドウが開くので、`Shakuhachi_Notation...` にチェックを入れて「OK」ボタンを押します。

その後、メニューの「プラグイン」をクリックすると、`Shakuhachi_Notation` が表示されるようになります。

menu


## 使用方法
MuseScore で、ドレミをつけたい楽譜を開いておきます。

before

それから、メニューの「プラグイン」で `Shakuhachi_Notation` をクリックします。クリックすると、プラグインのウィンドウが表示されるので、`Font` で `DoReMi ...` を選択します。

syaku

最後に「OK」ボタンを押すと、冒頭の画像のようにドレミがついた状態になります。


## 参考文献
今回の記事では、プラグインについての一部の情報しか書けませんでした。詳細は、下のリンク先を見て頂ければ幸いです。

[Shakuhachi notation 日本語ページ](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/) 
