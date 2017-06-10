---
Title: 仮想化環境：WindowsでLinuxを動かす
Category:
- etc
Date: 2016-03-25T16:41:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/vm/linux-on-winows
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179202208
---

Windows に仮想化環境を構築して、Linux（CentOS）を動かしてみます。VirtualBox と Vagrant で環境を構築して、PuTTY ごった煮版で SSH 接続しようと思います。


## 手順1. VirtualBox インストール
[VirtualBoxのダウンロードページ](https://www.virtualbox.org/wiki/Downloads) から、インストーラをダウンロードします。

![page-virtual-box](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815155850.png)

保存したファイルをダブルクリックして、指示通りインストールを進めていきます。（私は途中のオプション選択で、`Create a shortcut on …` と `Create a shortcut in …` のチェックを外しました。）

インストール中は、何度かダイアログが表示されます。指示通り「インストール」を選択すれば大丈夫です。


## 手順2. Vagrant インストール
[Vagrantのダウンロードページ](https://www.vagrantup.com/downloads.html) から、インストーラをダウンロードします。

![page-vagrant](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815155851.png)

保存したファイルをダブルクリックして、指示通りインストールを進めていきます。インストール後は、再起動するように言われます。


## 手順3. PuTTYごった煮版 インストール
[PuTTYごった煮版のダウンロードページ](http://yebisuya.dip.jp/Software/PuTTY/) から、インストーラをダウンロードします。

![page-putty](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815155852.png)

保存したファイルをダブルクリックして、指示通りインストールを進めていきます。


## 手順4. CentOS の起動準備
コマンドプロンプトを開いて、任意のディレクトリに移動して、次のコマンドを実行します。

```txt
> vagrant init puphpet/centos65-x64
```

実行すると、CentOS（BOX：[puphpet/centos65-x64](https://atlas.hashicorp.com/puphpet/boxes/centos65-x64/versions/20151130)）の Vagrantfile が作成されます。そのファイルを開いて、`config.vm.network …` のコメント `#` を削除します。

`削除前`

```txt
# config.vm.network "private_network", ip: "192.168.33.10"
```

`削除後`

```txt
config.vm.network "private_network", ip: "192.168.33.10"
```

CentOS が起動したら、上の IP を使って接続できるようになります。


## 手順5. CentOS の起動
次のコマンドで起動します。

```txt
> vagrant up --provider virtualbox
・・・
==> default: Machine booted and ready!
・・・
```


## 手順6. CentOS に接続
PuTTY ごった煮版を起動して、SSH で `192.168.33.10` に接続します。

![putty-ssh](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815155853.png)

画面左の「ウィンドウ - 変換」で文字コードを UTF-8 にできます。「ウィンドウ - 外観」では、フォントを変更できたりします。

CentOS のログインユーザとパスワードは `vagrant` になります。


## 補足1. CentOS の停止
次のコマンドで停止できます。Vagrantfile があるディレクトリで実行します。

```txt
> vagrant halt
```


## 補足2. 他の BOX について
[Vagrant（Hashicorp）の BOX ページ](https://atlas.hashicorp.com/boxes/search) で、他の BOX を検索することができます。Ubuntu や Debian などもあります。
