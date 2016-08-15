---
Title: JDK：Windowsにインストール
Category:
- JDK
Date: 2016-02-02T12:37:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/windows-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178825401
---

JDK の バージョン 8u71 を Windows 64bit にインストールする手順を書いています。バージョンが多少違っていても、同じ方法でインストールできると思います。


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


### 2. JREのコピー

下の画面（コピー先フォルダ）が出てたら、×ボタンでコピーをキャンセルしてます。

![jre-copy-folder](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223134.png)

JDK に JRE が入っているので、これは不要だったりします。
