---
Title: Java DBアクセス：目次
Category:
- Java
Date: 2017-11-03T11:31:47+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/table-of-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812314001883
---

Java を使って RDB（リレーショナルデータベース）にアクセスする記事を書いたので、そのリンクを一覧形式でまとめました。

JDBC を直接使う方法とライブラリを使う方法を書いていて、どちらから読んで頂いても大丈夫です。ただ、ライブラリの記事では、少しだけ JDBC を使ったりしています。


## 準備
事前に DB と Javaの共通資源を準備して頂けると、各記事のサンプルプログラムを実行することができます。

- [DB環境の準備](/entry/java/db-access/postgresql/db-env)
- [Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)


## 1. JDBC
JDBC で PostgreSQL に接続して、CRUDを実行する記事をまとめています。

- [INSERT文の実行（Create）](/entry/java/db-access/jdbc/crud/insert)
- [SELECT文の実行（Read）](/entry/java/db-access/jdbc/crud/select)
- [UPDATE文の実行（Update）](/entry/java/db-access/jdbc/crud/update)
- [DELETE文の実行（Delete）](/entry/java/db-access/jdbc/crud/delete)


## 2. ライブラリ
Java のライブラリを使って PostgreSQL に接続する記事をまとめています。ライブラリを使うと、JDBC よりも多くの機能が使えたり、簡単にSQLを実行できたりします。

- [sql2oでSQL実行](/entry/java/db-access/lib/sql2o-quick-start)
- 【記事作成中】FlywayでDBマイグレーション
- [HikariCPのコネクションプールを使う](/entry/java/db-access/lib/hikaricp-quick-start)
- 【記事作成中】HikariCP, Flyway, sql2oでDBアクセス
