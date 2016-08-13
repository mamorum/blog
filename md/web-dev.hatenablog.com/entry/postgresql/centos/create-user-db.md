---
Title: PostgreSQL：CentOSでユーザとDBを作成
Category:
- postgresql
Date: 2016-03-26T18:50:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/centos/create-user-db
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178926887
---

[CentOS にインストールした PostgreSQL](/entry/postgresql/centos/install) を使って、 ユーザとデータベースを作成してみます。

このブログでは、あくまでサンプルとして、ユーザのロール名・パスワード・データベース名を「spring」で統一しています。必要に応じて変更して頂ければ幸いです。

## 補足. PostgreSQL の認証について
事前に認証方式を md5 にしておくと、今回作成したユーザとパスワードでログインできます。md5 認証にする方法は、次の記事に書いてあります。

[PostgreSQL：CentOSでmd5認証に設定](/entry/postgresql/centos/md5-auth)


## 手順1. postgres ユーザで DB にログイン
次のコマンドで DB にログインします。

```
$ psql -U postgres
```


## 手順2. ユーザ（ログインロール）の作成
次の SQL で作成します。

```
postgres=# create user spring password 'spring';
```


## 手順3. DBの作成
次の SQL で作成します。所有者は spring になります。

```
postgres=# create database spring owner spring;
```


## 手順4. 動作確認
次のコマンドでログインできれば大丈夫です。

```
$ psql -U spring
```
