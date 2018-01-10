---
Title: PostgreSQL 9.6：Win10 でユーザとDBを作成
Category:
- DB
Date: 2018-01-11T07:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/9.6/windows10-create-user-and-db
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812335852433
Draft: true
---

Windows の PostgreSQL 9.6 で、ユーザ（ログインロール）とデータベースを作成する方法を書いていきます。


## 補足
この記事では、以下の値を使って作成していきます。

- ユーザ名：neko
- パスワード：cat
- データベース名：test

あくまでサンプルなので、値は変更して頂ければと思います。


## 手順1. pgAdmin の起動
Windows のスタートメニューから pgAdmin を起動します。

[f:id:mamorums:20180110154129p:plain]

pgAdmin は、PostgreSQL の管理ツールです。


## 手順2. PostgreSQL に接続
左側の（Browser）で「PostgreSQL 9.6」をダブルクリックして接続します。

[f:id:mamorums:20180110154205p:plain]

必要に応じて postgres ユーザのパスワードを入力します（インストールのときに設定した値です）。


## 手順3. ユーザの作成
左側の「Login/Group Roles」で右クリックして、Create -> Login/Group Role... を選択します。

[f:id:mamorums:20180110154224p:plain]

新しいウィンドウの General でユーザ名を入力します。

[f:id:mamorums:20180110154235p:plain]

Definition でパスワードを入力します。「Account expires（失効日）」は、サンプルなので値なしで良いかと思います。

[f:id:mamorums:20180110154250p:plain]

Privileges の「Can login?」を Yes にしておきます。

[f:id:mamorums:20180110154309p:plain]

最後に「Save」ボタンを押すと、PostgreSQL にログインできるユーザが作成されます。


## 手順4. データベースの作成
pgAdmin の「Database」で右クリックして、Create -> Dtabase... を選択します。

[f:id:mamorums:20180110154407p:plain]

新しいウィンドウで Databese（DB名）を入力して、Owner で neko さんを選択します。

[f:id:mamorums:20180110154415p:plain]

ボタン「Save」を押すとデータベースが作成されます。


## 補足. データベースへの接続
`psql` が Path に通っていれば、以下のコマンドで作成したデータベースに接続できます。

```
> psql test neko
```

Path の通し方や psql の使い方は、以下のリンク先にも書いてあります。

[PostgreSQL：WindowsでSQL実行（psql）](/entry/postgresql/windows/exec-sql-using-psql)

