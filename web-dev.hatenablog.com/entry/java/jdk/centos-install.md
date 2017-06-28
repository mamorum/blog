---
Title: JDK8：CentOSにインストール
Category:
- Java
- OS
Date: 2017-06-09T14:13:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/centos-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178823348
---

JDK8（Oracle の 8u77） を、CentOS にインストールする手順を書いていきます。

## 前提
今回の手順は、JDK がインストールされていない CentOS を使って書きました。既に OpenJDK などがインストールされている場合、事前にアンインストールしたほうが良いかもしれません。


## 手順1. rpm をダウンロード
wget コマンドで、JDK の rpm を取得します。

```bash
$ wget --no-check-certificate --no-cookies - --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u77-b03/jdk-8u77-linux-x64.rpm
```

最新版の JDK をインストールする場合は、コマンドの URL を変更します。URL は [Oracle のダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) で確認できます。


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
