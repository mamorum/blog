---
Title: SpringBoot入門：アプリのjar作成
Category:
- Spring
Date: 2017-02-20T18:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/create-jar
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179108483
---

Spring Boot の Webアプリを、jar 形式でパッケージングして起動する方法を書きます。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. jar の作成
Maven の package タスクで作成します。

```txt
gssb > mvn package
```

jar は、`target` 配下に出力されます。


## 手順2. 起動
次のコマンドで起動します。

```txt
gssb > java -jar target\gssb-1.0.0.jar
```


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
