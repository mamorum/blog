---
Title: JavaFX：SceneBuilderの入手方法
Category:
- Java
Date: 2017-03-18T17:19:07+09:00
URL: http://web-dev.hatenablog.com/entry/java/fx/get-scene-builder
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687228247621
---

Java SE 8u40 から、オラクルは JavaFX の SceneBuilder（バイナリ）の配布をやめてしまったようです。

>Starting with Oracle Java SE 8u40, Oracle does not provide a separate set of accompanying JavaFX Scene Builder binaries.

_from:_ [JavaFX Scene Builder 2.0 Download - Oracle](http://www.oracle.com/technetwork/java/javase/downloads/sb2download-2177776.html)

これから、Oracle 経由ではない入手方法についてまとめていこうと思います。


## 入手方法１（おすすめ）
GLUON という会社？が配布しているバイナリをダウンロードする方法です。

[Scene Builder - GLUON](http://gluonhq.com/products/scene-builder/) 


## 入手方法２（未検証）
２つ目は、SceneBuiler のソース（OpenJFX のソース）をビルドする方法です。

SceneBuiler の開発は、OpenJDK の OpenJFX で続けられているようです。そこからソースをダウンロードしてビルドできそうな感じでした。下のリンク先に手順が書かれてそうです。

[Building OpenJFX - OpenJDK Wiki](https://wiki.openjdk.java.net/display/OpenJFX/Building+OpenJFX#BuildingOpenJFX-GettingtheSources)

ただ、ちょっと自分では試していない状況です。


## 補足. 旧 Oracle 配布版
Oracle が配布していた古いバージョンは、次のページからダウンロードできるようです。

[JavaFX Scene Builder Archive - Oracle](http://www.oracle.com/technetwork/java/javafxscenebuilder-1x-archive-2199384.html)

警告が書かれていたり、製品版として使わないことが推奨されたりしてます。


## 参考文献
- [Bye Bye JavaFX Scene Builder, Welcome Gluon Scene Builder 8.0.0 - DZone Java](https://dzone.com/articles/bye-bye-javafx-scene-builder)
- [Scene Builder 8.3.0 Out Now - Gluon](http://gluonhq.com/scene-builder-8-3-0-now/)
- [[JavaFX][NetBeans]JavaFX Scene Builderのバイナリ入手先 - Hatena Diary](http://d.hatena.ne.jp/torutk/20150313/p1)
