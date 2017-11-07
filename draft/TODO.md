## Servlet アプリ開発

[Servletアプリ開発：目次](/entry/java/servlet/dev-restful-app/table-of-contents)

[Servletアプリ開発：1.概要](/entry/java/servlet/dev-restful-app/overview)
[Servletアプリ開発：2.プロジェクト作成](/entry/java/servlet/dev-restful-app/create-project)
[Servletアプリ開発：3.Java開発１（モデル・リポジトリ）](/entry/java/servlet/dev-restful-app/java1)
[Servletアプリ開発：4.Java開発２（RESTful API）](/entry/java/servlet/dev-restful-app/java2)
[Servletアプリ開発：5.動作確認](/entry/java/servlet/dev-restful-app/check)


- アプリ
  - プロジェクト名：servlet-rest
- API
  - GET /memo -> JSON で memo を全件返す
  - POST /memo -> パラメータ txt を受け取って insert
  - PUT /memo/:id -> JSON を受け取って memo を update
  - DELETE /memo/:id -> id を受け取って削除
  ※ kaze-sample-rdb だと、PUT の id が json に入っている。
      -> いつか url に id を含めるように直したい。


## Ubuntu記事追加
- gitの最新バージョンインストール


## 改善
[PostgreSQL：WindowsでユーザとDBを作成](http://web-dev.hatenablog.com/entry/postgresql/windows/create-user-db)
-> DB名、ユーザ名、パスワード（spring）を変えたい

[JDBC：UPDATE文の実行]()
