---
Title: Heroku の概要と用語
Category:
- Heroku
Date: 2015-05-27T08:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/heroku/overview-term
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179197753
---

## Heroku の概要
### 1. Herokuとは？
アメリカの企業であり、同社が開発・運営している PaaS の名称です。

[Heroku - Wikipedia](https://ja.wikipedia.org/wiki/Heroku)


### 2. PaaS とは？
- Platform as a Service の略。
- インターネットを通じて提供されるプラットフォームのこと。
- 具体的には、インフラ、Webサーバ、DBMS などが提供される。


### 3. PaaS を使うとどうなるか？
- ソースコードを PaaS に送るだけでサービスを構築できる。
- また、ミドルウェアをコンソールなどで管理することができる。


### 4. Heroku の場合
以下の資源を Heroku に送るだけでサービスを構築できます（git コマンドで Heroku に資源を送ります）。

- SourceCode（Ruby, PHP, Node.js, Python, Java など）
- Dependencies（gemfile, package.json, pom.xml など）
- Procfile（サービスを起動するコマンド）

また、DBMS などのミドルウェアを、Heroku のツールやコンソールなどで管理することができます。


## Heroku の用語
### 1. Slug（スラッグ）
- Heroku におけるアプリケーションのパッケージのこと。
- git コマンドで送ったファイルを元に Heroku が生成する。
- Slugを生成することで、Dyno上でアプリケーションを実行できるようになる。


### 2. Dyno（ダイノ）
- Herokuにおける仮想的なサーバのこと。
- Slug を読み込んで、サービスを提供する。
- 永続的なデータは、アドオンを使って保存する。


### 3. Addon（アドオン）
- アプリケーションに機能を追加できるサービスのこと。
- PostgreSQL, MySQL などのサービスや、モニタリングサービスなどがある。
- PostgreSQL などは、無料で使えたりする（データ容量の制限有り）。
