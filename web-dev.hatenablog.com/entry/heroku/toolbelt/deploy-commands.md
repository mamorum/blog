---
Title: Heroku Toolbelt のデプロイ関連コマンド
Category:
- Heroku
Date: 2015-08-18T13:49:00+09:00
URL: http://web-dev.hatenablog.com/entry/heroku/toolbelt/deploy-commands
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179195263
---

Heroku Toolbelt の主要なコマンドを書いていこうと思います。


## 補足
Heroku Toolbelt の概要とインストール方法は、以下の記事に記載しています。

[HerokuToolbelt：CentOS にインストール](/entry/heroku/toolbelt/centos-install)


## Heroku にログイン

事前に Web 上で Heroku のアカウントを作成しておきます。それから、次のコマンドでログインします。

```txt
$ heroku login
```

## コードのデプロイ（初回）
Git で管理しているコードを、以下の手順でデプロイします。

### 1. コードを clone する
Git で管理しているコードを clone します。


### 2. Herokuアプリの作成
コードの一番上（リポジトリ）のディレクトリに移動して、以下のコマンドを実行します。

```txt
$ heroku create
```

これで、Herokuアプリが作成されて、コードをデプロイできるようになります。


### 3. Heroku にコードを push する
`git push` でコードを送ります。

```txt
$ git push heroku master
```

コードが届くと、Heroku がデプロイ（ビルド）を開始してくれます。デプロイ完了後、Heroku アプリが起動します。


### 4. アプリの確認
アプリ起動後に以下のコマンドを実行すると、ブラウザでアプリの動作を確認できます。

```txt
$ heroku open
```


## コードのデプロイ（２回目以降）
コードを更新したら、以下のコマンドを実行します。コードが Heroku に届くと、デプロイを開始してくれます。

```txt
$ git push heroku master
```


## コードを既存の Herokuアプリに送る
`heroku create` で作成した Herokuアプリに、今までとは違う Git リポジトリのコードを送りたい場合などは、次の手順が参考になります。

### 1. コードを clone する
Git で管理しているコードを clone します。


### 2. Heroku アプリと関連付ける
clone したコード（リポジトリ）の一番上のディレクトリで、以下のコマンドを実行します。

```txt
$ heroku git:remote -a Herokuアプリ名
```

Herokuアプリ名は、Heroku のコンソール（Web）で確認できます。


### 3. Heroku にコードを push する
`git push` でコードを送ります。

```
$ git push heroku master
```

新しいコードが届くと、Heroku がデプロイを開始してくれます。


## アプリのリスタート
Procfile を更新した場合は、`git push` でコードを送ってから、以下のコマンドでリスタートします。

```txt
$ heroku restart
```

これで、新しい Procfile でサービスが起動されます。
