---
Title: Eclipse：インデントを空白に設定
Category:
- Eclipse
Date: 2017-06-23T09:15:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/preferences/indent-space
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958055339223
---

Eclipse のエディタで、インデントを空白（半角スペース）に設定する方法を書いていきます。今回は、

1. Java の Formatter
2. Text Editors
3. XML Editor

について書いています。


## 補足
この記事では、インデントのサイズは半角２つに設定しています。お好みで調整して頂ければと思います。


## 事前作業
Eclipse メニューバーの ウィンドウ（Window）から、プリファレンス（Preferences）を開いておきます。


## 設定1. Java の Formatter
### 1-1. Formatter のプロファイル作成
Preferences で Java の Formatter を選択して、新しいプロファイルを作成しておきます。

[f:id:mamorums:20170613082250p:plain]

今回は user というプロファイルを、Eclipse [built-in] をもとに作成しました。


### 1-2. インデントの設定
作成したプロファイルの Edit ボタンを押すと新しいウィンドウが開きます。そこで、以下の通り設定します。

- Tab policy: Spaces only
- Indentation size: 2
- Tab size: 2

[f:id:mamorums:20170613082304p:plain]


## 設定2. テキストエディタ
Preferences で Text Editors を選択して、以下の通り設定します。

- Displayed tab width: 2
- Insert spaces for tabs: チェックを入れる

[f:id:mamorums:20170613082235p:plain]


## 設定3. XML エディタ
Preferences で XML の Editor を選択して、以下の通り設定します。

- Indent using spaces: チェックを入れる
- Indentation size: 2

[f:id:mamorums:20170623091545p:plain]
