---
Title: Vagrant：WindowsでCentOSを動かす
Category:
- 環境
Date: 2018-01-05T09:50:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/vagrant/run-centos
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179202208
---

Vagrant を使って、Windows で CentOS（Linux）を動かす方法を書いていきます。CentOS には、SSHでアクセスできるようにします。


## 前提
事前に以下のプロダクトをインストールしておきます。

- [Virtual Box](https://www.virtualbox.org/)
- [Vagrant](https://www.vagrantup.com/)


## 手順1. vagrant init の実行
今回は、CentOS の Box「[puphpet/centos65-x64](https://app.vagrantup.com/puphpet/boxes/centos65-x64)」を使ってみます。 

コマンドプロンプトで任意のディレクトリに移動してから、次のコマンドを実行します。

```
> vagrant init puphpet/centos65-x64
```


## 手順2. ネットワークの設定
先ほどのコマンドで `Vagrantfile` が作成されます。そのファイルを開いて、`config.vm.network …` のコメント（`#`）を削除して保存します。

`削除前`

```
# config.vm.network "private_network", ip: "192.168.33.10"
```

`削除後`

```
config.vm.network "private_network", ip: "192.168.33.10"
```

CentOS が起動したら、上の IP を使って接続できるようになります。


## 手順3. CentOS の起動
設定が終わったら、次のコマンドで起動します。

```
> vagrant up
```

起動したら、SSH で `192.168.33.10` に接続できます。Windows の場合、[PuTTY](http://www.putty.org/) などの SSH クライアントを使うと良いのかと思います。

CentOS のログインユーザとパスワードは `vagrant` になります。


## 補足1. CentOS の停止
次のコマンドで停止できます。

```txt
> vagrant halt
```

Vagrantfile があるディレクトリで実行します。


## 補足2. 他の BOX について
CentOS 以外の OS を使いたい場合、[Vagrant の BOX ページ](https://atlas.hashicorp.com/boxes/search) で他の Box を検索することができます。Ubuntu や Debian などもあります。
