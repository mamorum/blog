---
Title: Maven：Win10にインストール
Category:
- Java
Date: 2019-12-04T23:50:00+09:00
URL: https://web-dev.hatenablog.com/entry/maven/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958053917957
---

Maven を Windows10 64bit にインストールする手順を書いていきます。


## 前提
JDK をインストールして、`JAVA_HOME` と `Path`（環境変数）を設定しておいたほうが良いと思います。準備方法は、以下の記事にも記載しています。

[https://web-dev.hatenablog.com/entry/java/jdk/corretto/8/windows10-install:embed:cite]


## 手順1. Maven ダウンロード
<a target="_blank" href="https://maven.apache.org/download.cgi">Maven のダウンロードページ</a> から、安定版の「Binary zip archive」をダウンロードします。自分がダウンロードしたバージョンは `3.6.3` で、ファイル名は `apache-maven-3.6.3-bin.zip` でした。




## 手順2. 解凍
ダウンロードしたら、Zip を好きな場所（例：`C:\opt\apache-maven-3.6.3`）に解凍します。

[f:id:mamorums:20191206001954p:plain]


## 手順3. 環境変数 Path の設定
Maven の binフォルダ（例：`C:\opt\apache-maven-3.6.3\bin`）を、既存の環境変数 `Path` に追加します。環境変数の設定方法は、下の記事にも書いてあります。

[https://web-dev.hatenablog.com/entry/windows/10/set-env-variable:embed:cite]


## 手順4. 動作確認（任意）
コマンドプロンプトで `mvn -v` を実行します。Maven のバージョン等が表示されれば成功です。

```txt
> mvn -v
Apache Maven 3.6.3 ...省略
```
