---
Title: JDK8：Ubuntu14にインストール
Category:
- Java
Date: 2017-06-09T22:25:18+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/ubuntu-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687192974484
---

Oracle の JDK8 を、Ubuntu 14.04 LTS（Trusty Tahr）にインストールする手順を書いていきます。動作確認は、Vagrant Box の [ubuntu/trusty64](https://atlas.hashicorp.com/ubuntu/boxes/trusty64) で行っています。


## 手順1. インストール
apt-get コマンドでインストールします。

```bash
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```

確認を求める画面が表示されたら指示通り進めます。


## 手順2. 環境変数の設定
こちらも apt-get を使います。

```bash
$ sudo apt-get install oracle-java8-set-default
```

`JAVA_HOME` 等の環境変数が設定されます。


## 手順3. 動作確認
java コマンドでバージョンを表示します。

```bash
$ java -version
java version "1.8.0_101"
・・・
```
