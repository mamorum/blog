---
Title: Oracle JDK8：Ubuntu16にインストール
Category:
- Java
Date: 2019-12-03T10:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/8/ubuntu16-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971655625444
---

Oracle の JDK8 を Ubuntu16 にインストールする方法を書いていきます。

## 2019.12.03 追記
Oracle の JDK はライセンス体系が変わったので、使わないほうが良いかと思います。このブログでも、今後は Amazon Corretto などの JDK を使おうと思っています。

[https://aws.amazon.com/jp/corretto/:embed:cite]


## 前提
動作確認は、Windows にインストールした Ubuntu16（WSL：Windows Subsystem for Linux）で行っています。


## 手順1. インストール
apt コマンドでインストールします。

```
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt update
$ sudo apt install oracle-java8-installer
```

最近は `apt-get` よりも `apt` が推奨されているようです。


## 手順2. 環境変数の設定
こちらも apt を使います。

```
$ sudo apt install oracle-java8-set-default
```

`JAVA_HOME` などの環境変数が自動で設定されます。WSL だと、再ログイン後に設定されてました。（`exit` してから、もう一度 Ubuntu のプロンプトを起動。）


## 手順3. 動作確認
java コマンドでバージョンを表示してみました。

```
$ java -version
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```

java は `/usr/bin/` にインストールされてました。

```
$ which java
/usr/bin/java
```
