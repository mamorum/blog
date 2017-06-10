---
Title: Eclipse：概要
Category:
- Eclipse
Date: 2016-02-01T10:34:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179018365
---

Eclipse の概要や、Eclipse の使用前に知っておきたいことを書いています。


## 1. Eclipse は IDE
Eclipse は、IDE（統合開発環境）と呼ばれるプロダクトです。IDE を使うと、エディタ・コンパイラ・デバッガなどをまとめて使えるので便利です。

下は Eclipse の画面で、中央にエディタがあります。エディタでプログラムを書くと、すぐにコンパイルされます。

![eclipse-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085925.png)

Eclipse の画面から、プログラムを実行したり、デバッグすることもできます。画像内のコンソールには、プログラムの実行結果が表示されています。



## 2. Eclipse には JDK が必要
Eclipse を利用するには、コンピュータに JDK がインストールされている必要があります。JDK をインストールする場合は、次の記事を参照して頂けると嬉しいです。

- [JDK：Windowsにインストール](/entry/java/jdk/windows-install)
- [JDK：Windowsの環境変数設定](/entry/java/jdk/windows-variables)


## 3. Eclipse のパッケージは多い
Eclipse には、開発目的に応じたパッケージ（種類）がたくさんあります。[Eclipse のページ](https://eclipse.org/downloads/) を開くと、どれをダウンロードするか迷ったりもします。

![page-eclipse-downlad](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085926.png)


## 4. Eclipse の Java開発パッケージ
Java 開発の場合は、次のパッケージを選択することが多いです。

- Eclipse IDE for Java EE Developers
- Eclipse IDE for Java Developers

前者は後者より機能が多く、ファイルサイズも大きいです。このブログでは後者（for Java Developers）を使いますが、大抵の開発はどちらでも大丈夫だと思います。
