---
Title: DirectX 9.0c：Windows10にインストール
Category:
- ゲーム
Date: 2018-10-23T08:42:39+09:00
URL: https://web-dev.hatenablog.com/entry/game/directx/install-9c-to-win10
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132658256433
---

DirectX 9.0c (June 2010) のランタイムを、Windows10 にインストールする手順を書いていきます。 


## 注意事項
インストール後、OSや他のアプリにどのような影響が出るかは分かりません。インストールは自己責任でお願い致します。


## 手順1. ダウンロード
Microsoft の [DirectX End-User Runtimes (June 2010)](https://www.microsoft.com/en-us/download/details.aspx?id=8109) というページを開いたら、

[f:id:mamorums:20181023085008p:plain]

「Download」ボタンを押します。

次の画面が表示されたら、

[f:id:mamorums:20181023085020p:plain]

チェックボックスを外して、ボタン「No thanks and continue DirectX End-User Runtime Web Installer」を押します。これで、DirectX だけダウンロードされるずです。


## 手順2. 解凍
ダウンロードしたファイル「directx_Jun2010_redist.exe」を実行して、画面が表示されたら指示通り進めます。

途中で解凍先を指定する画面が出てくるので、適当なディレクトリのパスを指定します。

[f:id:mamorums:20181023084154p:plain]

自分はファイルをダウンロードしたところの、directx というディレクトリを指定してみました。


## 手順3. インストール
解凍されたら、解凍先のディレクトリをエクスプローラで開きます。

[f:id:mamorums:20181023084207p:plain]

その中の「DXSETUP.exe」というファイルを実行して、

[f:id:mamorums:20181023084225p:plain]

インストールが完了するまで画面の指示通り進めます。


## 手順4. ファイルの削除
インストールが完了したら、

- ダウンロードしたファイル
- 解凍したファイル

を削除します。

解凍したファイルは、ディレクトリごと削除して大丈夫です。


## 補足
[June 2010 ではない DirectX 9.0c](https://www.microsoft.com/ja-jp/download/details.aspx?id=34429) は、Windows10 にインストールできないみたいです。ダウンロードして実行するとエラーが表示されました。

