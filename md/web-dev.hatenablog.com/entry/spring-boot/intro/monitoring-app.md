---
Title: SpringBoot入門：アプリの管理やモニタリング
Category:
- spring-boot
Date: 2016-03-11T18:05:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/monitoring-app
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179108828
---

Spring Boot の Webアプリを、HTTP経由で管理したり、モニタリングする方法を書きます。今回は、Spring Boot の Actuator という機能を使います。


## 前提
この記事は、入門記事「[JSONの返却](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. ビルドファイルの編集
記事「[JSONの返却](/entry/spring-boot/intro/response-json)」で作成したビルドファイルを編集して、`dependencies` に `spring-boot-starter-actuator` を追加します。

```gradle
dependencies {
    （省略）
    compile 'org.springframework.boot:spring-boot-starter-actuator'
}
```


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
```


## 手順3. 確認
`http://localhost:8080/health` にアクセスすると、システムの状態を受け取ることができます。

```txt
> curl http://localhost:8080/health
{"status":"UP","diskSpace":{"status":"UP","total":517455474688,"free":4413117685
76,"threshold":10485760},"db":{"status":"UP","database":"H2","hello":1}}
```

この他にも色々な機能があります。

- `/dump`：スレッドダンプを返却
- `/mappings`：`@RequestMappings` の path を返却
- 等々

詳細は「[Spring Boot リファレンス](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)」の「Part V. Spring Boot Actuator」に書かれていました。また、機能ごとに ON/OFF を設定できるので、本番運用する場合は検討したほうが良さそうです。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
