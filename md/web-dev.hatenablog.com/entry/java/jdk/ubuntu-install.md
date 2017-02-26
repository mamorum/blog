---
Title: JDK：Ubuntuにインストール
Category:
- JDK
- Linux
Date: 2016-11-04T22:25:18+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/ubuntu-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687192974484
---

Oracle JDK 8 を Ubuntu 14 にインストールする手順を書いていきます（Vagrant Box の `ubuntu/trusty64` で動作確認済み）。


## 手順1. インストール
apt-get コマンドでインストールします。

```bash
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```


## 手順2. 環境変数の設定
こちらも apt-get を使います。

```bash
$ sudo apt-get install oracle-java8-set-default
```

`JAVA_HOME` 等が設定されます。


## 手順3. 動作確認
java コマンドで確認します。

```bash
$ java -version
java version "1.8.0_101"
・・・
```

