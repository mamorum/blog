---
Title: Java DBアクセス：目次
Category:
- Java
Date: 2017-11-03T11:31:47+09:00
URL: http://web-dev.hatenablog.com/entry/java/db/table-of-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812314001883
---

Java を使って RDB（リレーショナルデータベース）にアクセスする記事をまとめました。JDBC を直接使う方法と、ライブラリを使ってアクセスする方法について書いています。

記事は JDBC から読んで頂いても、ライブラリから読んで頂いても大丈夫です。ただ、ライブラリの記事では、少しだけ JDBC を使ったりしています。


## 準備
事前に環境を準備して頂けると、各記事のサンプルプログラムを実行することができます。

- [DB環境の準備](/entry/java/jdbc/postgresql/db-env)


## 1. JDBC
JDBC で PostgreSQL に接続する記事をまとめています。共通資源を準備して頂くと、CRUD記事のサンプルプログラムを実行することができます。

### 1.1. 準備
- [Java共通資源の作成](/entry/java/jdbc/postgresql/java-project-common-class)

### 1.2. CRUD
- [INSERT文の実行（Create）](/entry/java/jdbc/postgresql/crud/insert)
- [SELECT文の実行（Read）](/entry/java/jdbc/postgresql/crud/select)
- [UPDATE文の実行（Update）](/entry/java/jdbc/postgresql/crud/update)
- [DELETE文の実行（Delete）](/entry/java/jdbc/postgresql/crud/delete)


## 2. ライブラリ
Java のライブラリを使って PostgreSQL に接続する記事をまとめています。ライブラリを使うと、JDBC よりも多くの機能が使えたり、簡単にSQLを実行できたりします。

- 【記事作成中】HikariCPのコネクションプールを使う
- 【記事作成中】FlywayでDBマイグレーション
- 【記事作成中】sql2oでSQL実行
- 【記事作成中】HikariCP, Flyway, sql2oでDBアクセス
