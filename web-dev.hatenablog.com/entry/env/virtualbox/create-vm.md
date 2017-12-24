---
Title: VirtualBox：仮想マシンの作成
Category:
- 環境
Date: 2017-12-24T12:10:44+09:00
URL: http://web-dev.hatenablog.com/entry/env/virtualbox/create-vm
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812329261847
---

Windows の Virtual Box に仮想マシンを作成する手順を書いていきます。仮想マシンを作成すると、Linux（Ubuntu）などをインストールして動かすことができます。

ブログ執筆時のプロダクトは以下の通りです。

- Windows10 64bit
- Virtual Box 5.1.30

Virtual Box はインストールされている前提で書いてます。


## 1. VirtualBox の起動
Windows のスタートメニューなどで、Oracle VM VirtualBox を起動します。

[f:id:mamorums:20171224120437p:plain]


## 2. 仮想マシンの作成
VirtualBox マネージャー（GUI）が起動したら「新規ボタン」を押します。

[f:id:mamorums:20171224120539p:plain]


## 3. 名前とOSの設定
新しいウィンドウが表示されるので名前を設定します。

[f:id:mamorums:20171224120550p:plain]

名前に Ubuntu を入力すると、OS も Ubuntu になりました。


## 4. メモリの設定
上の画面から次に進むと、メモリの設定画面になりました。画面に「1024MB 必要」と書かれていたので、その通りにしました。


## 5. ディスクの設定
メモリの次は仮想ハードディスクの設定画面になりました。こちらもデフォルトで、設定値は以下の通りです。

- 仮想ハードディスクを作成
- VDI
- 可変サイズ
- 場所はデフォルト
- 10GB


## 6. 確認
作業が完了すると、作成した仮想マシンが左側に表示されました。

[f:id:mamorums:20171224120604p:plain]

