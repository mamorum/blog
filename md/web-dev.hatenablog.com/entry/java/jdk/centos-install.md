---
Title: JDK：CentOSにインストール
Category:
- java
Date: 2016-03-28T14:13:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/centos-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178823348
---

Oracle JDK を CentOS にインストールする手順を書いていきます。

今回の手順は、JDK がインストールされていない CentOS を使って書きました。既に OpenJDK などがインストールされている場合、
事前にアンインストールしたほうが良いかもしれません。


## 手順1. rpm をダウンロード
wget コマンドで、JDK の rpm を取得します。

```bash
$ wget --no-check-certificate --no-cookies - --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u77-b03/jdk-8u77-linux-x64.rpm
```

JDK のバージョンは 8u77 でした。最新版をインストールする場合は、[Oracle のダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) で URL を確認できます。


## 手順2. インストール
rpm コマンドでインストールします。

```bash
$ sudo rpm -ivh jdk-8u77-linux-x64.rpm
```


## 手順3. 動作確認
java コマンドを実行して、バージョンが表示されれば大丈夫です。

```bash
$ java -version
java version "1.8.0_77"
・・・
```
