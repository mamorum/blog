---
Title: SpringBoot：pom.xml の version で警告
Category:
- Spring Boot
Date: 2016-07-12T12:40:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/pom-version-warn
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178793234
---

Spring Boot のアプリで Maven を使っていたところ、pom.xml の version（dependency の子要素）で警告が出ました。これから、事象・原因・対応方法を書いていきます。


## 事象
JDBC Driver の version を指定すると、Eclipse のエディタで警告（黄色い線とアイコン）が出ました。

```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>9.4.1207</version>
  <scope>runtime</scope>
</dependency>
```


## 原因
アプリで version を指定すると、定義が二重になってしまうためです。Spring Boot が、別の pom.xml で version を指定しているようです。 




## 対応方法
version を指定しないように修正します。

```xml
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```

特別な理由がなければ、Spring Boot の version に合わせたほうが無難そうな気がします。


## 解析メモ
Spring Boot は、spring-boot-dependencies の [pom.xml](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-dependencies/pom.xml) で、version を設定してそうでした。

`spring-boot-dependencies/pom.xml（一部抜粋）`

```xml
<postgresql.version>9.4.1208.jre7</postgresql.version>
```

