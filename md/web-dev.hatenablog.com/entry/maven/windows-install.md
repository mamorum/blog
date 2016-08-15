---
Title: Maven：Windowsにインストール
Category:
- Maven
Date: 2016-04-01T17:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/maven/windows-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178896795
---

Maven を Windows にインストールする手順を書いていきます。手順は、[JDK をインストール](/entry/java/jdk/windows-install) して、[環境変数を設定](/entry/java/jdk/windows-variables) していることが前提となります。


## 手順1. ダウンロード
[Maven のダウンロードページ](https://maven.apache.org/download.cgi) から、安定版（執筆時は 3.3.3）の「Binary Zip archive（apache-maven-3.3.3-bin.zip）」をダウンロードします。


## 手順2. 解凍
ダウンロードしたら、Zip を好きな場所（例：`C:\apache-maven-3.3.3`）に解凍します。

![unzip](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813110841.png)


## 手順3. 環境変数 Path の設定
Maven の binフォルダ（例：`C:\apache-maven-3.3.3\bin`）を、環境変数 `Path` に追加します。

![edit-path](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813110842.png)


## 手順4. 動作確認（任意）
コマンドプロンプトで `mvn --version` を実行します。Maven のバージョン等が表示されれば成功です。

```txt
> mvn --version
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T20:57:37+09:
00)
Maven home: C:\apache-maven-3.3.3\bin\..
（省略）
```
