---
Title: SpringBoot：Velocity の文字化け対応
Category:
- Spring
Date: 2016-07-29T17:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/error/velocity-mojibake
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178787333
---

Spring Boot で Velocity を使ったら、日本語の文字化けが発生しました。今回は、文字化けが解消した方法を書いていこうと思います。


## 文字化けの発生条件
次の２点を満たしていると、文字化けが発生するようです。

- Velocity のテンプレートを UTF-8 などで書いている。
- Velocity のエンコーディング設定を変更していない。


## 対応方法
Spring Boot の設定ファイル（application.properties 等）で、Velocity のエンコーディングを UTF-8 などに変更します。

```txt
spring.velocity.properties.input.encoding=UTF-8
spring.velocity.properties.output.encoding=UTF-8
```


## 補足1. Velocity のデフォルトエンコーディング
Velocity の jar の中にある velocity.properties で定義されてるようです。

```txt
input.encoding=ISO-8859-1
output.encoding=ISO-8859-1
```


## 補足2. SpringBoot を使っていない場合
WEB-INF 配下に velocity.properties を用意して、設定を上書きすると良いみたいです。

```txt
input.encoding=UTF-8
output.encoding=UTF-8
```
