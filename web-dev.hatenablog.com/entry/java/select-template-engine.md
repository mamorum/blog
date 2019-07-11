---
Title: Java：おすすめのテンプレートエンジン
Category:
- Java
Date: 2017-03-30T08:24:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/select-template-engine
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179116435
---

Web アプリ開発（サーバサイド Java）で、おすすめしたいテンプレートエンジンを書いてみました。あくまで私個人の考えなので、広い心で見て頂けると嬉しいです。


## 現時点（2017.03.30）
今は、[jmustache](https://github.com/samskivert/jmustache) （[Mustache](http://mustache.github.io/) の Java実装）がおすすめです。


## 理由
### 1. シンプル
Mustache はシンプルで、すぐ使うことができます。テンプレートエンジン特有のカスタムタグとかはなく、HTML 以外の学習コストはかからないと思います。

### 2. JavaScript実装もある
JavaScript だと [mustache.js](https://github.com/janl/mustache.js/) が使えます。サーバサイドとクライアントサイドを Mustache に統一できるのは嬉しいです。

最近の傾向からすると、クライアント側でもテンプレートを使うことがあると思います。サーバサイドの役割も変わってきて、HTML を返すだけではなくなってきました。


## 最近の傾向
### 1. Webフロントエンドの進化
HTML5, CSS3, altJS, JavaScript/CSS フレームワーク, DOM操作, Ajax, 等々、昔とは状況が変わってきました。画面遷移の回数が少ない SPA（Single Page Application）なども登場してきました。

### 2. サーバサイドの役割変化
REST（RESTful API）が広まり、画面（HTML）ではなくデータ（JSONなど）を返すことが求められている気がします。

### 3. クライアントの多様化
ブラウザ以外のアプリ（デスクトップアプリ、スマホアプリ、等）も、Web アプリ（Web サービス）に接続してきます。こういったアプリにも、データを返すことになると思います。


## 補足1. Mustache 関連記事
以下の記事では、mustache.js を使っています。

- [JS：mustache.js 入門](/entry/js/mustache/quick-start)
- [SpringBoot アプリ開発](/entry/spring-boot/dev-web-app/table-of-contents)


## 補足2. Spring Boot について
Spring Boot は、現時点だと以下のテンプレートエンジンをサポートしているようでした。

- FreeMarker
- Groovy
- Thymeleaf
- Mustache

詳細は、[Template engines - Spring Boot Reference](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-template-engines) に書かれています。

JSP は避けたほうが良いと書かれていました。
組み込みのサーブレットコンテナ等で制限があるみたいです。
