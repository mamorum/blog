---
Title: Java：どのテンプレートエンジンを使うか？
Category:
- Java
Date: 2016-08-05T08:24:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/select-template-engine
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179116435
---

Java の Web アプリ開発で、どのテンプレートエンジンを使うか考えてみました。あくまで私個人の考えなので、広い心で見て頂けると嬉しいです。


## 結論
最近だと「Java のテンプレートエンジンは、HTML のレンダリングで極力使わないようにしよう。」と考えるようになりました。

タイトルの回答になってなくてすみません。


## 理由
### 1. Webフロントエンドの進化
HTML5, CSS3, altJS, JavaScript/CSS フレームワーク, DOM操作, Ajax, 等々、昔とは状況が変わってきました。画面遷移の回数が少ない SPA（Single Page Application）なども登場してきましたた。

### 2. サーバサイドの役割変化
REST や RESTful API が広まり、画面（HTML）ではなくデータ（JSONなど）を返すことが求められている気がします。

### 3. クライアントの多様化
ブラウザ以外のアプリ（デスクトップアプリ、スマホアプリ、等）も、Web アプリ（Web サービス）に接続してきます。こういったアプリにも、データを返すことになると思います。

## Java フレームワークの傾向
Spring Boot, Play Framework, Dropwizard なども、JSON をサポートしています。いくつかのドキュメントを見ると、画面遷移よりも JSON を返すサンプルが先に書かれています。


## 代替案
画面（HTML）周りは、Java のテンプレートエンジンを使う代わりに、フロントエンドの技術を使うことが多くなると思います。

当ブログの [SpringBoot アプリ開発](/entry/spring-boot/dev-web-app/table-of-contents) でも、mustache.js（JavaScript のテンプレートエンジン）を使って、Web アプリを作ったりしています。


## 例外
サーバサイドのテキスト生成（メールの文面）などで、Java のテンプレートエンジンを使うと便利だったりします。FreeMarker や Velocity などは、テキストのレンダリングにも対応しています。


## Spring Boot を使う場合
### 1. JSP は避けたほうが無難
[SpringBoot のドキュメント](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-template-engines) に、できれば JSP は避けたほうが良いと書かれています。

### 2. CSRF トークンの取得
テンプレートエンジンを使って取ることになりそうです。自分も FreeMarker で書いたことがあります（次の２行）。

```txt
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
```
