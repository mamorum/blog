---
Title: VirtualBox：Ubuntu16のインストール
Category:
- etc
Date: 2017-12-25T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/virtualbox/ubuntu16-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812329263512
---

Virtual Box の仮想マシンに、Ubuntu16（サーバー）をインストールする方法を書いていきます。仮想マシンは Windows 上に作成している前提で、環境やプロダクトのバージョンは以下の通りです。

- Windows10 64bit
- Virtual Box 5.1.30
- Ubuntu Server 16.04.3 LTS 


## 1. Ubuntuのダウンロード
[Ubuntu Server のダウンロードページ](https://www.ubuntu.com/download/server) から、イメージファイル（isoファイル）をダウンロードします。800MB 以上あったので、少し時間が必要になります。


## 2. ストレージの設定
作成しておいた仮想マシンを選択して設定を開きます。それから「ストレージ」を選択して、IDEの光学ドライブに ISO を追加します（円盤に＋が付いたアイコンをクリックして追加）。

[f:id:mamorums:20171224121935p:plain]

追加したファイルはストレージツリーに表示されました。

[f:id:mamorums:20171224121947p:plain]


## 3. 仮想マシンの起動
仮想マシンを選択して「通常起動」します。

[f:id:mamorums:20171224121959p:plain]


## 4. Ubuntuのインストール
起動するとウィンドウが開いてインストールが始まります。はじめは言語から選択していきます。

[f:id:mamorums:20171224122010p:plain]

今回は、English で「Install Ubuntu Server」を選択しました。

[f:id:mamorums:20171224122026p:plain]

それから次のように進めました。

- Select a language: English - English
- Select your location: Japan
- Configure locales: United States - en_US.UTF-8
- Configure the keyboard: No, Japanese
- Hostname: vbox
- User: ubuntu
- Encrypt: No
- Configure the clock: Asia/Tokyo
- Partition disks: 
  - Guided - use entire disk and set up LVM
  - SCSI3 - 10.7GB
  - 10.2 GB
- HTTP proxy: 空
- Configureing tasksel: No automatic updates
- Software selection:
  - standard system utilities
- Install the GRUB: Yes
- Finish the installation: Continue

ほとんどデフォルトのままです。任意で設定して頂けると良いかと思います。

作業が完了すると再起動してログインのプロンプトが表示されます。あとは、必要に応じて sudo と apt の設定をしておきます。


## 5. sudo の設定（任意）
ubuntu ユーザーはパスワードなしで `sudo` を使えるようにしておきます。

```
$ sudo visudo
```

上のコマンドで設定ファイルが開くので、末尾に以下の文言を追加します。

```
ubuntu ALL=(ALL) NOPASSWD: ALL
```


## 6. パッケージの更新（任意）
パッケージ管理ツールの `apt` を使って更新します。

```
$ sudo su -
# apt update
# apt upgrade
# shutdown -r now
```

はじめに root になって、最後にリブートしています。

以前は `apt-get` を使ってましたが、最近は `apt` が推奨されてるようです。`apt` のほうが新しくて改善されてるみたいです。


## 補足. 仮想マシンの停止について
以下のシャットダウンのコマンドを実行すると、仮想マシンの電源がオフになります。

```
$ sudo shutdown -h now
```

VitrualBox マネージャー（GUI）から電源を落とすこともできます。

[f:id:mamorums:20171224122039p:plain]

対象の仮想マシン上で右クリックして「閉じる」の「ACPI シャットダウン」をクリックします。


## 参考文献
- [Ubuntu16.04 LTSのインストールと初期設定 - eco.senritu.net](http://eco.senritu.net/ubuntu16-04-lts-server_install_and_settings/)
- [Ubuntu：sudoコマンドのパスワード入力を回避する - usagi1975.com](http://www.usagi1975.com/31jan172009/)
- [aptコマンドチートシート - Qiita](https://qiita.com/SUZUKI_Masaya/items/1fd9489e631c78e5b007)
- [Debian の apt/apt-get/aptitude について - intheweb.io](https://intheweb.io/apt-aptget-aptitude/)
- [Ubuntu 16.04 / Debian 8: aptコマンドの使い方 - Narrow Escape](https://www.hiroom2.com/2016/05/12/ubuntu-16-04-debian-8%E3%81%AEapt%E3%82%B3%E3%83%9E%E3%83%B3%E3%83%89%E3%81%AE%E4%BD%BF%E3%81%84%E6%96%B9)
