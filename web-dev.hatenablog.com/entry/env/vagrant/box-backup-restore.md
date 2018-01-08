---
Title: Vagrant：Boxのバックアップ・リストア
Category:
- 環境
Date: 2018-01-07T10:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/vagrant/box-backup-restore
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687251917027
---

Vagrant の Box をバックアップしてリストアする方法を書いていきます。


## 1. バックアップの実行
事前にバックアップ対象のディレクトリ（Vagrantfile がある場所）に移動して、Box を停止しておきます。

それから、次のコマンドを実行します。

```
> vagrant package --output trusty64-20170524.box
```

オプション `--output`で、バックアップファイル（Box ファイル）の名前を指定してます。

処理が完了したら、出力された Box ファイルと Vagrantfile（任意）を保管しておきます。


## 2. リストアの実行
以下のコマンドで、Box ファイルを Vagrant に追加します。

```
> vagrant box add trusty64-20170524 trusty64-20170524.box
（省略）
==> box: Successfully added box 'trusty64-20170524' (v0) for 'virtualbox'!
```

Box は引数の `trusty64-20170524` という名前で追加されます。

それから、リストアしたいディレクトリで以下のコマンドを実行します。

```
> vagrant init trusty64-20170524
```

ディレクトリ内に Vagrantfile が作成されて、`vagrant up` を実行できるようになります。


## 補足. リストア後の Vagrantfile
リストア後に作成される Vagrantfile は、box 名が以下のようになっていました。

```
config.vm.box = "trusty64-20170524"
```

それ以外は初期状態っぽいので、必要に応じて修正します。
