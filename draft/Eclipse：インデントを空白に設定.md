Eclipse のエディタで、インデントを空白（半角スペース）に設定する方法を書いていきます。設定は２つあって、

1. Text Editors
2. Java の Formatter

を設定していきます（インデントのサイズは半角２つに設定しました）。


## 事前作業
Eclipse メニューバーの ウィンドウ（Window）から、プリファレンス（Preferences）を開いておきます。


## 設定1. テキストエディタ
### 1-1. Formatter のプロファイル作成
Preferences で Text Editors を選択して、以下の通り設定します。

- Displayed tab width: 2
- Insert spaces for tabs: チェックを入れる

indent0


## 設定2. Java の Formatter
### 2-1. Formatter のプロファイル作成
Preferences で Java の Formatter を選択して、新しいプロファイルを作成しておきます。

indent1

今回は user というプロファイルを、Eclipse [built-in] をもとに作成しました。


## 2-2. インデントの設定
作成したプロファイルの Edit ボタンを押すと新しいウィンドウが開きます。そこで、以下の通り設定します。

- Tab policy: Spaces only
- Indentation size: 2
- Tab size: 2

indent2

これで設定は完了です。
