---
Title: PostgreSQL：CentOSにインストール
Category:
- PostgreSQL
Date: 2016-03-23T12:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/centos/install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178926175
---

CentOS に、PostgreSQL 9.4.1 をインストールする手順を書いていきます。[PostgreSQL公式ページの手順](http://www.postgresql.org/download/linux/redhat/) に従って、root ユーザで作業します。


## 手順1. インストール
yum でインストールします。

```bash
# yum install http://yum.postgresql.org/9.4/redhat/rhel-6-x86_64/pgdg-redhat94-9.4-1.noarch.rpm
```

```bash
# yum install postgresql94-server postgresql94-contrib
```


## 手順2. DB初期化
DBを初期化します。

```bash
# service postgresql-9.4 initdb
```


## 手順3. サービスの起動設定
OS起動時に、PostgreSQL のサービスが起動するように設定します。

```bash
# chkconfig postgresql-9.4 on
```


## 手順4. サービスの起動
インストール直後は、手動でサービスを起動します。

```bash
# service postgresql-9.4 start
```


## 手順5. 確認
PostgreSQL のサービスが起動しているか確認します（一般ユーザでも可能）。

```bash
$ ps aux | grep postgres
postgres  2905  0.1  3.2 324996 15044 ?        S    01:42   0:00 /usr/pgsql-9.4/bin/postmaster -D /var/lib/pgsql/9.4/data
postgres  2907  0.0  0.3 180144  1464 ?        Ss   01:42   0:00 postgres: logger process
・・・省略。
```

データディレクトリ「/var/lib/pgsql/9.4/data」でサービスが起動されています（postmaster -D ディレクトリ）。
