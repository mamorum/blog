---
Title: Ubuntu16：zip・unzipのインストール
Category:
- Linux
Date: 2018-06-15T01:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/linux/ubuntu16/install-zip-unzip
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971655639371
---

Ubuntu16 に zip と unzip をインストールする方法を書いていきます。

※ 動作確認は、Windows にインストールした Ubuntu16（WSL：Windows Subsystem for Linux）で行っています。


## 前提
apt を使ったインストール方法になります。最近だと apt-get より apt が推奨されているようです。


## 1. インストール
以下のコマンドでインストールします。

```
$ sudo apt install zip unzip
```


## 2. 確認
オプション `-h` でヘルプが表示されることを確認しました。

```
~$ zip -h
Copyright ...
Zip 3.0 ...
```

```
~$ unzip -h
UnZip 6.00 ...
```
