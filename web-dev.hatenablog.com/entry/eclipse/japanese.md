---
Title: Eclipse：日本語化について
Category:
- Java
Date: 2016-02-01T16:01:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/japanese
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179019141
---

Eclipse は、デフォルトだと画面の文言（メニューやメッセージなど）を英語で表示します。文言を日本語にしたい場合は、Eclipse を日本語化する必要があります。

今回は、日本語化すべきかどうか、日本語化する場合の方法、といった内容を書いていきます。


## 1. 理想は日本語化しない
あくまで個人的な見解ですが、次のような場合は日本語化しないほうが良いと思います（理由は後述）。

- 英語でも使える場合。
- 英語でも使ってみようと思える場合。

しかし、英語だと操作に支障が出たり、日本語の画面で開発したい場合は、日本語化したほうが良いです。

日本語化した Eclipse を使っているうちに、操作方法やよく使う機能の場所を覚えていきます。それから英語版を試したりするのも良いのかと思います。


## 2. 日本語化の方法
### 2.1. Eclipse Babel
[Eclipse Babel](http://www.eclipse.org/babel/) の日本語化パックをインストールする方法ですが、エラーが多いみたいであまりおすすめはできません。

Eclipse Mars にインストールしたら、次のようなエラーが発生していました。

![eclipse-babel-error](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814091103.png)


### 2.1. Pleiades プラグイン
[Pleiades](http://mergedoc.osdn.jp/) という日本語化プラグインをインストールする方法です。

Pleiades を使うと、Eclipse（JVM）の起動パラメータに `-Xverify:none` を設定することになります。このパラメータは、[Oracle の記事](https://blogs.oracle.com/buck/entry/never_disable_bytecode_verification_in) などでも指定しないように推奨されています。

開発環境だし大丈夫、気にならない、という場合はこのプラグインになるのかと思います。こちらはエラーもなく、Eclipse が遅くなる感じもしません。すごいプラグインです。


### 2.3. Pleiades All in One
[Pleiades](http://mergedoc.osdn.jp/) が提供している、既に日本語化された Eclipse パッケージ（Pleiades All in One）を使う方法です。

Windows 限定ですが、これを使うと Eclipse（本体）のインストールも不要になって便利です。次のような点が気にならなければお勧めです。

- プラグイン同様、パラメータ `-Xverify:none` が設定される点。
- 日本語化プラグイン以外にも、色々な資源が入っている点。

