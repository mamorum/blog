---
Title: Ubuntu：zip・unzipのインストール
Category:
- Linux
Date: 2017-07-06T10:03:22+09:00
URL: https://web-dev.hatenablog.com/entry/linux/ubuntu/install-zip-unzip
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812277196436
---

Ubuntu に zip と unzip をインストールする方法を書いていきます。動作確認は、Vagrant Box の `ubuntu/trusty64` で行っています。


## 手順1. apt-get の実行
以下のコマンドでインストールします。

```
$ sudo apt-get install zip unzip
```


## 手順2. 確認
オプション `-h` でヘルプが表示されれば大丈夫です。

```
~$ zip -h
Copyright ...
Zip 3.0 ...
```

```
~$ unzip -h
UnZip 6.00 ...
```
