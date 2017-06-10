---
Title: Vagrant：Boxのバックアップ・リストア
Category:
- etc
Date: 2017-05-24T20:19:19+09:00
URL: http://web-dev.hatenablog.com/entry/etc/vagrant/box-backup-restore
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687251917027
---

Vagrant の box をバックアップしてリストアする手順を書いていきます。


## 前提
バックアップしたい box が停止されていることが前提です。


## 1. バックアップ手順
### 1.1. box のディレクトリに移動
コマンドラインで、box のディレクトリ（Vagrantfile がある場所）に移動します。

```
> cd trusty64
```

今回の例では、ディレクトリ名を `trusty64` にしています。


### 1.2. vagrant package の実行
次のコマンドで、box ファイルを作成します（オプション `--output` でファイル名指定）。

```
trusty64> vagrant package --output trusty64-20170524.box
（省略）
==> default: Compressing package to: C:/....
```

別端末でリストアする場合、box ファイルを移動しておきます。あと、Vagrantfile を変更していたらそれも保管しておいたほうが良いかと思います。


## 2. リストア手順
### 2.1. vagrant box add の実行
box ファイルを vagrant に追加します。

```
trusty64> vagrant box add trusty64-20170524 trusty64-20170524.box
（省略）
==> box: Successfully added box 'trusty64-20170524' (v0) for 'virtualbox'!
```

引数の `trusty64-20170524` という名前で追加されます。


### 2.2. vagrant init の実行
リストアしたいディレクトリでコマンドを実行します。

```
> vagrant init trusty64-20170524
```

Vagrantfile が作成されて、`vagrant up` を実行できるようになります。

Vagrantfile は、box 名が以下のように新しくなっていました。

```
config.vm.box = "trusty64-20170524"
```

それ以外は初期状態っぽいので、必要に応じて修正します。
