---
Title: PostgreSQL：CentOSでmd5認証に設定
Category:
- PostgreSQL
Date: 2016-03-26T18:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/centos/md5-auth
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178926554
---

[CentOS にインストールした PostgreSQL](/entry/postgresql/centos/install) の認証方式を md5 に変更してみます。md5 にすると、PostgreSQL に作成されたユーザとパスワードで認証できるようになります。


## 補足. デフォルトの認証方式
CentOS の PostgreSQL だと、デフォルトの認証方式が peer, ident になっています。この認証方式だと、DBのユーザ情報が OS に依存します。


## 手順1. postgres のパスワード変更
md5 認証で postgres（DBユーザ）を使えるように、パスワードを設定しておきます。デフォルトのままだとパスワードがなくて、postgres は md5 認証に失敗します。

まずは、postgres ユーザで psql を起動して、

```
$ sudo -u postgres psql
```

次の SQL で変更します。'パスワード' は、好きな値にします。

```
postgres=# alter user postgres password 'パスワード';
```

変更できたら `\q` で終了します。


## 手順2. root にスイッチ
事前に root になってから、認証方式を md5 に変更していきます。

```
$ sudo su -
```


## 手順3. 設定ファイルの編集
vi などで `/var/lib/pgsql/9.4/data/pg_hba.conf` を開いて、下の peer と ident（３つ）を md5 に変更します。

`変更前`

```
# "local" is for Unix domain socket connections only
local   all             all                           peer
# IPv4 local connections:
host    all             all        127.0.0.1/32       ident
# IPv6 local connections:
host    all             all        ::1/128            ident
```

`変更後`

```
# "local" is for Unix domain socket connections only
local   all             all                           md5
# IPv4 local connections:
host    all             all        127.0.0.1/32       md5
# IPv6 local connections:
host    all             all        ::1/128            md5
```


## 手順4. サービス再起動
PostgreSQL のサービスを再起動して、設定ファイルの変更を反映させます。

```
# service postgresql-9.4 restart
```

これで作業完了です。


## 参考文献
[19.1. pg_hba.confファイル - PostgreSQL ドキュメント](https://www.postgresql.jp/document/9.4/html/auth-pg-hba-conf.html)
