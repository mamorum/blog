---
Title: Eclipse：概要
Category:
- Java
Date: 2019-12-07T00:25:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179018365
---

Eclipse の概要や、Eclipse の使用前に知っておきたいことを書いていきます。


## 1. Eclipse は IDE
Eclipse は、IDE（統合開発環境）と呼ばれるプロダクトです。IDE を使うと、エディタ・コンパイラ・デバッガなどをまとめて使えるので便利です。

下は Eclipse の画面で、中央にエディタがあります。エディタでプログラムを書くと、すぐにコンパイルされます。

![eclipse-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085925.png)

Eclipse の画面から、プログラムを実行したり、デバッグすることもできます。画像内のコンソールには、プログラムの実行結果が表示されています。


## 2. JDK が必要
Eclipse を利用するには、コンピュータに JDK がインストールされている必要があります。JDK の記事は、以下のリンク先にまとめているので、必要に応じて参照して頂けると嬉しいです。

[https://web-dev.hatenablog.com/entry/java/jdk/table-of-contents:embed:cite]


## 3. パッケージが多い
Eclipse には、開発目的に応じたパッケージがたくさんあります。<a target="_blank" href="https://www.eclipse.org/downloads/packages/">Eclipse のダウンロードページ</a> を開くと、どれをダウンロードするか迷ったりもします。

[f:id:mamorums:20191207002628p:plain]


## 4. Java開発パッケージ
Java 開発の場合は、次のパッケージを選択することが多いです。

- Eclipse IDE for Enterprise Java Developers
- Eclipse IDE for Java Developers

`for Enterprise Java Developers` は機能が多く、ファイルサイズも大きいです。このブログでは `for Java Developers` 
を使いますが、大抵の開発はどちらでも大丈夫だと思います。
