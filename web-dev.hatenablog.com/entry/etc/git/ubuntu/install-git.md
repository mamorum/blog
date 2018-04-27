---
Title: Git：Ubuntu14にインストール（apt-get）
Category:
- etc
Date: 2017-11-10T15:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/git/ubuntu/install-git
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812276929313
---

Ubuntu 14 の apt-get を使って、Git をインストールする方法を書いていきます。動作確認は、Vagrant Box の `ubuntu/trusty64` で行っています。

※ インストール方法は、公式マニュアルの「[Git - Download for Linux and Unix](https://git-scm.com/download/linux)」を参考にしています。


## 手順1. 事前準備
root になって、apt-get のインデックスを更新しておきます。

```
$ sudo su -
# apt-get update
```

## 手順2. インストール
以下のコマンドでインストールします。

```
$ sudo apt-get install git
```


## 手順3. 確認
git コマンドでバージョンを表示してみます。

```
$ git --version
git version 1.9.1
```

## 補足. アカウント設定について
Git を利用する前には、アカウント情報を設定しておいたほうが良さそうです。設定方法は以下のリンク先にも書いています。

[Git：アカウント設定（初回利用時）](/entry/etc/git/set-account)
