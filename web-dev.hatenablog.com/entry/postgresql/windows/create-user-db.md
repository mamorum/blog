---
Title: PostgreSQL：WindowsでユーザとDBを作成
Category:
- PostgreSQL
Date: 2016-03-23T13:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/windows/create-user-db
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178954315
---

[Windows にインストールした PostgreSQL](/entry/postgres/windows/install) を使って、
ユーザとデータベースを作成してみます。

このブログでは、あくまでサンプルとして、ユーザのロール名・パスワード・データベース名を「spring」で統一しています。必要に応じて変更して頂ければ幸いです。


## 手順1. pgAdmin の起動
Windows スタートメニュー → すべてのプログラム → PostgreSQL → pgAdmin の順に辿って起動します。

![menu-pgadmin3](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195232.png)


## 手順2. サーバ PostgreSQL 9.4 に接続
pgAdmin の左側に表示されている「PostgreSQL 9.4（localhost:5432）」をダブルクリックして接続します。

postgres ユーザのパスワードを求められたら、インストール時に設定した値を入力します。


## 手順3. ユーザ（ログインロール）の作成
pgAdmin のログインロールで右クリックして、新しいログインロールを選択します。

![new-login-role](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195233.png)

新しいウインドウが表示されたら、ロール名「spring」・パスワード「spring」を入力して、ＯＫを選択します。

![input-role-name](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195234.png)

![input-password](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195235.png)


## 手順4. DBの作成
pgAdmin のデータベースで右クリックして、新しいデータベースを選択します。

![new-database](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195236.png)

新しいウインドウが表示されたら、名前「spring」・オーナー「spring」を入力して、ＯＫを選択します。

![database-owner](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813195237.png)

これで作業は完了です。
