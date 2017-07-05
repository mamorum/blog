---
Title: Ubuntu：gitのインストール
Category:
- OS
Date: 2017-07-01T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/linux/ubuntu/install-git
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812276929313
---

Ubuntu に git をインストールして、個人の識別情報（ユーザ名とメールアドレス）を設定する方法を書いていきます。動作確認は、Vagrant Box の `ubuntu/trusty64` で行っています。


## 手順1. apt-get の実行
[Git - Download for Linux and Unix](https://git-scm.com/download/linux) に書かれているとおり、`apt-get` でインストールします。

※ 事前に `sudo apt-get update` を実行しておいたほうが良いかもです。

```
$ sudo apt-get install git
```


## 手順2. 確認
git コマンドでバージョンを表示してみます。

```
$ git --version
git version 1.9.1
```


## 手順3. 識別情報の設定
[Git - 最初のGitの構成](https://git-scm.com/book/ja/v1/%E4%BD%BF%E3%81%84%E5%A7%8B%E3%82%81%E3%82%8B-%E6%9C%80%E5%88%9D%E3%81%AEGit%E3%81%AE%E6%A7%8B%E6%88%90#個人の識別情報) に書かれているとおり、以下のコマンドで識別情報（ユーザ名とメールアドレス）を設定します。


```
$ git config --global user.name "John Doe"
$ git config --global user.email johndoe@example.com
```

識別情報を設定しないでコミットすると、[ユーザ が invalid-email-address](/entry/etc/github/invalid-email-address-committed) になったりします。 
