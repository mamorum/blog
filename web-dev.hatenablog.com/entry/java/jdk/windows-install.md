---
Title: Oracle JDK8：Win7にインストール
Category:
- Java
Date: 2019-12-03T12:37:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/windows-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178825401
---

Oracle の JDK8（バージョン 8u71）を、Windows7 64bit にインストールする手順を書いています。


## 2019.12.03 追記
Oracle の JDK はライセンス体系が変わったので、使わないほうが良いかと思います。このブログでも、今後は Amazon Corretto などの JDK を使おうと思っています。

[https://aws.amazon.com/jp/corretto/:embed:cite]


## 手順1. インストーラのダウンロード

Oracle の [JDK ダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/index.html) を開きます。

![jdk-download-page](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223131.png)

ボタン `DOWNLOAD` をクリックして、次のページに遷移します。

![jdk-win64bit](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223132.png)

遷移したら、ラジオボタン `Accept License Agreement` にチェックを入れて、`jdk-8u71-windows-x64.exe` をクリックします。ダウンロードが始まったら、インストーラを適当な場所に保存します。


## 手順2. インストーラの実行

インストーラを実行すると、インストールが始まります。

このブログでは、インストール中に次の２点だけ設定を変更しています。設定を変更せず、インストーラの表示通り進めても大丈夫です。


### 1. インストール先

下の画面で「C:\jdk1.8.0_71\」に変更しています。

![install-folder](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223133.png)

※ 画像の「パブリックJRE」をインストールしないようにすると、JREのコピー（次の画面・手順）を回避できそうです。


### 2. JREのコピー

下の画面（コピー先フォルダ）が出てたら、×ボタンでコピーをキャンセルしてます。

![jre-copy-folder](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223134.png)

JDK に JRE が入っているので、これは不要だったりします。


## 関連文書
[JDK8：Win7の環境変数設定](/entry/java/jdk/windows-variables)（JDKを使うための設定）
