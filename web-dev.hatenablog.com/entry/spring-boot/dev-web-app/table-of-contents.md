---
Title: SpringBoot アプリ開発：はじめに・目次
Category:
- Spring Boot アプリ開発
Date: 2016-06-23T22:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/table-of-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179181282
---

記事「SpringBoot アプリ開発」では、短いテキスト（つぶやき）の 作成・表示・更新・削除（CRUD）ができる Webアプリを開発していきます。

画面イメージ、開発環境、目次（個別記事へのリンク）を、下に書いていきます。


## 画面イメージ
### ＰＣ
![pc-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122744.png)

### モバイル（レスポンシブ）
![mobile-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122743.png)


## 開発環境（使用プロダクト）
- JDK 1.8, Gradle 2.10, PostgreSQL（執筆時 9.4）
- SpringBoot（Web, JPA）, Flyway
- jQuery, Bootstrap, mustache.js（Java のテンプレートは未使用）

あとは、テストで JUnit, AssertJ, Mockito, FluentLenium を使います。


## 開発手順（目次）
開発手順は、複数の記事に分けて書いています。次の目次順に進めて頂けると、分かりやすいと思います。

1. [環境準備](/entry/spring-boot/dev-web-app/env)
2. [プロジェクト作成](/entry/spring-boot/dev-web-app/project)
3. [Java（モデル・リポジトリ）](/entry/spring-boot/dev-web-app/java1)
4. [Java（コントローラ）](/entry/spring-boot/dev-web-app/java2)
5. [ＵＩ（HTML, mustache）](/entry/spring-boot/dev-web-app/ui1)
6. [ＵＩ（CSS, JavaScript）](/entry/spring-boot/dev-web-app/ui2)
7. [動作確認](/entry/spring-boot/dev-web-app/check)
8. [テスト](/entry/spring-boot/dev-web-app/test)


## 関連記事
[SpringBoot入門：目次](/entry/spring-boot/intro/table-of-contents)  
※ タスクベース（あれをしたい、これを使いたい）の記事をまとめています。


## ソースコード
[sbt - GitHub](https://github.com/mamorum/blog/tree/master/code/sbt)  
※ プロジェクト名の sbt は、Spring Boot Tutorial（Tsubuyaki）の略です。
