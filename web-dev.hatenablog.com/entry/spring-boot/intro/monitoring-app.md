---
Title: SpringBoot入門：アプリの管理やモニタリング
Category:
- Java
Date: 2017-02-21T18:05:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/monitoring-app
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179108828
---

Spring Boot の Webアプリを、HTTP経由で管理したり、モニタリングする方法を書きます。今回は、Spring Boot の Actuator という機能を使います。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. ビルドファイルの編集
記事「[JSONを返す](/entry/spring-boot/intro/response-json)」で作成した `pom.xml` を編集して、`dependencies` に `spring-boot-starter-actuator` を追加します。

```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```


## 手順2. 起動
次のコマンドでアプリを起動します。

```
gssb > mvn spring-boot:run
```


## 手順3. 確認
`http://localhost:8080/health` にアクセスすると、システムの状態を受け取ることができます。

```
{"status":"UP"}
```

## 補足. 他の機能について
他にも色々な機能がありそうです。

- `/dump`：スレッドダンプを返却
- `/mappings`：`@RequestMappings` の path を返却
- 等々

ただ、デフォルトだと機能が無効になっていて、アクセスするとエラーが返されるものが多いです。機能の一覧や、有効化の方法は、下のリンク先に書かれていました。

[Spring Boot Actuator - Spring Boot リファレンス](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)

本番運用する場合は、セキュリティ的なことも含めて、色々と検討したほうが良さそうです。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
