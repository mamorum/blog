---
Title: Java SE9 と EE8 の資料まとめ
Category:
- Java
Date: 2017-09-30T20:42:29+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/9/references-links
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812303067560
---

Oracle が Java SE9 と EE8 を発表したようなので（[日本語版プレスリリース](https://www.oracle.com/jp/corporate/pressrelease/jp20170925-2.html)）、関連する参考文献とかリンクなどをまとめてみることにしました。


## Java SE9（JDK9）関連
- [Java SE9 Download Page - Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [JDK9 Documentation - Oracle](http://docs.oracle.com/javase/9/index.html)
- [JDK9 Installation Guide - Oracle](http://docs.oracle.com/javase/9/install/overview-jdk-9-and-jre-9-installation.htm)


## Maven
ダウンロードページを見ると、JDK 1.7（JDK7）以上が必要と書いてありました。ただ、JDK9 が出る前の記述かもしれないです。

[Download Page - Apache Maven](https://maven.apache.org/download.cgi)

JDK9 をインストールして、実行してみるのが良さそうな気がしました。


## Eclipse
Eclipse Oxygen 4.7.1a（2017.10.11 リリース予定）から、Java 9 がサポートされるみたいです。4.7.1a より前の Eclispe だと、下のリンク先の設定が必要そうです。

[Configure Eclipse for Java9](https://wiki.eclipse.org/Configure_Eclipse_for_Java_9)


## Java EE8（と Servlet 4.0）
Java EE8 だと、サーブレットのバージョンは 4.0 になるみたいです。

- [Java EE8 Technologies - Oracle](http://www.oracle.com/technetwork/java/javaee/tech/index.html)
- [Servlet Specification 4.0（PDF）](http://download.oracle.com/otn-pub/jcp/servlet-4-final-eval-spec/servlet-4_0_FINAL.pdf)


## Tomcat
Tomcat 9.0 が Servlet 4.0 をサポートするみたいで、アルファ版がダウンロード可能な感じでした。

[Which version? - Apache Tomcat](http://tomcat.apache.org/whichversion.html)


## Jetty
Servlet 4.0 をサポートする Jetty のバージョンは見つけられませんでした。Jetty 10 とかになるんですかね。

[Jetty Version Comparison Table - Eclipse Wiki](https://wiki.eclipse.org/Jetty/Starting/Jetty_Version_Comparison_Table)

