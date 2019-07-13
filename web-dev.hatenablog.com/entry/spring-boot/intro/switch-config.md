---
Title: SpringBoot：環境で設定を変える
Category:
- Java
Date: 2015-06-22T18:54:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/switch-config
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179614863
---

Spring Boot の設定ファイル `application.properties` を、環境に応じて切り替える方法を書いていきます。今回の例では、次のファイルを用意して切り替えてみます。

- `application.properties`
- `application-staging.properties` 

２番目のファイルはステージング環境用（テスト環境用）で、ステージングのときだけ有効にしたい設定値を書いていきます。


## 手順1. application.properties の作成
クラスパス直下に `application.properties` を作成して、全環境で使う設定値を保存します。

```
server.port=80

spring.messages.basename=messages
spring.messages.cache-seconds=-1
spring.messages.encoding=UTF-8
```

今回の例では、ポート番号やメッセージの設定だけ書いています。


## 手順2. application-staging.properties の作成
クラスパス直下に `application-staging.properties` を作成して、ステージング環境だけ変更したい設定を書きます。

```
server.port=8080
```

今回はポート番号だけ変えることにします。


## 手順3. アプリの起動（通常）
いつもどおり、環境を指定せずにアプリを起動します。

```
> java -jar {jar名称}

・・・省略・・・

2015-06-22 18:04:45.880  INFO 6640 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 80 (http)
2015-06-22 18:04:45.883  INFO 6640 --- [           main] sbb.Application             : Started Application in 14.704 seconds (JVM running for 18.228)
```

`application.properties` で指定したとおり、Tomcat がポート「80」で起動します。


## 手順4. アプリの起動（ステージング環境）
`-Dspring.profiles.active=staging` を引数に追加して、ステージング環境として起動します。

```
> java -jar -Dspring.profiles.active=staging {jar名称}

・・・省略・・・

2015-06-22 18:11:39.344  INFO 3508 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2015-06-22 18:11:39.347  INFO 3508 --- [           main] sbb.Application             : Started Application in 11.484 seconds (JVM running for 12.122)
```

`application-staging.properties` の設定値が優先されて、Tomcat がポート「8080」で起動します。ポート番号以外の設定は、`application.properties` の設定と同じです。差分の設定値だけ上書きされるイメージです。


## 補足. 他の環境で起動する
ステージング環境だけではなく、他の環境の設定ファイルを用意して切り替えることもできます。そのためには、設定ファイル「application-{環境名}.properties」を作成して、引数「-Dspring.profiles.active={環境名}」を指定して起動すれば大丈夫です。


### 例. プロダクション環境の場合
プロダクション環境（本番環境）を `production` という文字列で識別する場合、ファイル名とアプリ起動時の引数は次のようになります。

- 設定ファイル名：application-production.properties
- 起動時の引数：-Dspring.profiles.active=production

アプリ起動コマンドは、下のような感じになります。

```
> java -jar -Dspring.profiles.active=production {jar名称}
```
