---
Title: SpringBoot アプリ開発：1.概要
Category:
- SpringBoot
Date: 2017-06-14T18:23:35+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812269933468
---

記事「SpringBoot アプリ開発」で開発するアプリの概要を書いていきます。


## 機能
短いテキスト「つぶやき」の、作成・表示・更新・削除（CRUD）ができるアプリです。


## 画面（HTML, JS, CSS）
つぶやきの CRUD ができるレスポンシブな画面を、Bootstrap, jQuery, mustache.js を使って実装していきます。

画面イメージは以下の通りです。

### ＰＣ向け（ウィンドウ大）
![pc-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122744.png)

### モバイル向け（ウィンドウ小）
![mobile-screen-shot](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122743.png)


## サーバサイド（Java, DB）
HTTPリクエストを受け付けて、JPA で RDBMS にアクセスします。RDBMS につぶやきを保存しておいて、レスポンスのデータは JSON で返します。

Spring Boot の Web, JPA を使って実装していきます。RDBMS は  PostgreSQL を使いました。


## 開発環境・プロダクト
- JDK 1.8
- Gradle (※1)
- PostgreSQL, Flyway
- SpringBoot Web + JPA
- Bootstrap, jQuery, mustache.js（※2）
- JUnit, AssertJ, Mockito, FluentLenium（※3）

※1. Maven 等のビルドツールでもＯＫ  
※2. Java のテンプレートエンジンは未使用  
※3. テストのみ使用
