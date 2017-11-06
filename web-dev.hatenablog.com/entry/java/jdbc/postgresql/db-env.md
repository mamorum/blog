---
Title: JDBC：DB環境の準備
Category:
- Java
Date: 2017-11-01T19:10:32+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdbc/postgresql/db-env
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812313767665
---

JDBC関連の記事で、Javaから接続するデータベース（PostgreSQL）の準備をしていきます。


## PostgreSQL のインストール
Windows にインストールする方法は、以下の記事に書いてあります。

[PostgreSQL：Windowsにインストール](/entry/postgresql/windows/install)


## PostgreSQL でユーザとDBを作成
Windows 向けの記事は以下の通りです。

[PostgreSQL：WindowsでユーザとDBを作成](/entry/postgresql/windows/create-user-db)

JDBC の記事では「ユーザ名/パスワード」を「neko/cat」 、データベース名を「test」として進めています。


## テーブルの作成
次の SQL を実行して、テーブル `memo` を作成しておきます。

```
create table memo (
  id serial primary key,
  txt varchar(200) not null,
  updated timestamp not null default current_timestamp,
  created timestamp not null default current_timestamp
);
```

Windows でSQLを実行する方法は、以下のリンク先にも書いています。

[PostgreSQL：WindowsでSQL実行（psql）](/entry/postgresql/windows/exec-sql-using-psql)

