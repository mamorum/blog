---
Title: Heroku Toolbelt の便利コマンド
Category:
- 環境
Date: 2015-08-19T01:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/heroku/toolbelt/useful-commands
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179197031
---

Heroku Toolbelt を使っていて、便利だと思ったコマンドをまとめていこうと思います。

## 補足
Heroku Toolbelt の概要や、Heroku にコードをデプロイする手順は、以下のリンクが参考になると思います。

- [HerokuToolbelt：CentOS にインストール](/entry/heroku/toolbelt/centos-install)
- [Heroku Toolbelt のデプロイ関連コマンド](/entry/heroku/toolbelt/deploy-commands)


## ログを確認する
次のコマンドで確認できます。

```txt
$ heroku logs --tail
 or
$ heroku logs
```

`--tail` を付けると、出力されたログがコンソールに表示されていきます。（Linuxコマンドの `tail -f` のような動きをします。）


## メンテナンスモードにする
次のコマンドを実行すると、メンテナンス画面が表示されるようになります。

```txt
$ heroku maintenace:on
```

メンテナンス画面は、ブラウザからアプリにアクセスすると確認できます。


## Heroku上でコマンドを実行する
次のコマンドを実行すると、bash のコマンドラインが立ち上がります。

```txt
$ heroku run bash
```

bash 以外のコマンドを投げることも可能です。例えば、`heroku run rails console` なども可能です。


## Heroku の PostgreSQL に接続する
次のコマンドで接続できます。

```txt
$ heroku pg:psql
```

psql コマンドを PATH に通している必要があります。


## リリースを確認する
次のコマンドで、Heroku が管理しているリリースの一覧を表示することができます。

```txt
$ heroku releases
```

また、以下のコマンドで、過去のリリースに戻すことができます（戻すバージョンも指定可能）。

```txt
$ heroku releases:rollback
```


## 環境変数を設定する
次のコマンドを実行すると、環境変数名 `mykey` で、値 `myvalue` を設定できます。

```txt
$ heroku config:set mykey=myvalue
```

環境変数を表示したり、設定を解除するコマンドもあるようです。


## foreman を使う
foreman を使うと、Heroku と同じ条件で、ローカルのコードを実行できます。（同じ Procfile のコマンドで起動されたりします。）

```txt
$ foreman start 
```

ローカルの環境変数を設定したい場合、.env ファイルに環境変数を設定します。

```txt
$ vi .env

mykey=myvalue
```
