---
Title: SpringBoot：Initializrでプロジェクト作成
Category:
- Java
Date: 2016-07-27T15:50:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/create-project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179112021
---

Java のアプリを開発するときは、アプリのプロジェクトを作成することが多いと思います。プロジェクトは複数のディレクトリで構成されていて、ソースコードやビルドファイル（pom.xml, build.gradle, etc）などの資源を置きます。

Spring Boot の場合、[Spring Initializr](https://start.spring.io/) を使ってプロジェクトを生成することができます。今回はその利用手順を書いていこうと思います。


## 画面イメージ
下の画像が、[Spring Initializr](https://start.spring.io/) の画面です。
![page-spring-initializr](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814222024.png)


## 手順1. ビルドシステムとバージョンの選択
画面上の `Generate a ...` の箇所で、ビルドシステム（Gradle or Maven）と Spring Boot のバージョンを選択します。


## 手順2. プロジェクト情報の入力
画面上の `Project Metadata` に、開発するアプリの情報を入力していきます。`Group` はパッケージ構成、`Artifact` は jarの名称などに使われます。


## 手順3. 依存性の入力
画面上の `Dependencies` のテキスト項目に、使いたい Spring Boot の依存性（Web, JPA, etc）を入力します。入力すると候補が表示されて、選択すると `Selected Dependencies` の箇所に反映されます。


## 手順4. プロジェクト生成
ボタン `Generate Project` を押すと、プロジェクトをダウンロードできます。ダウンロードしたファイルを解凍すると、ビルドファイルやディレクトリが確認できます。

