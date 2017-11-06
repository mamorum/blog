---
Title: PostgreSQL：WindowsでSQL実行（psql）
Category:
- 環境
Date: 2017-11-04T10:06:03+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/windows/exec-sql-using-psql
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812314302619
---

[Windows にインストールした PostgreSQL](/entry/postgres/windows/install) に対して、ローカルから接続して SQLを実行する方法を書いていきます。今回は、PostgreSQL に付属している psql を使ってみます。


## 手順1. psql の確認
psql は、PostgreSQL をインストールした先の bin ディレクトリにあります。自分は `C\opt` 配下にインストールしてたので、

```
C:\opt\PostgreSQL\9.6\bin\psql.exe
```

にありました。


## 手順2. 環境変数 Path の設定
psql を何度も使う場合、bin ディレクトリを Path を通すと楽だったりします。

[f:id:mamorums:20171104100415p:plain]

Path を通すと、コマンドラインで psql と打つだけで実行できます。

```
> psql .....
```

数回しか使わない場合は、以下のようにフルパス実行でも良いのかもしれません。

```
> C:\opt\PostgreSQL\9.6\bin\psql.exe .....
```


## 手順3. DBに接続
コマンドプロンプトを開いて psql を実行します。

```
> psql test neko
```

上の場合だと、

- データベース名: test
- ユーザ名: neko

で接続することになります。

パスワード（非表示）の入力を求められて、問題ないと `test=>` と表示されます。

```
ユーザ neko のパスワード:
psql (9.6.3)
"help" でヘルプを表示します.
test=>
```

## 手順4. SQLの実行
`select now();` を実行して、現在日時を表示してみます。

```
test=> select now();
              now
-------------------------------
 2017-11-04 09:43:55.403584+09
(1 行)
```


## 手順5. psql の終了
`\q` を入力して Enter を押すと、psql が終了してコマンドプロンプトに戻ります。

```
test=> \q
```


## 補足
DBに接続できない場合、PostgreSQL が起動しているか確認したほうが良いかもしれません。あと、データベースやログインユーザの作成方法は、以下の記事に書いてあります。

[PostgreSQL：WindowsでユーザとDBを作成](/entry/postgresql/windows/create-user-db)

必要に応じて参照して頂けると嬉しいです。
