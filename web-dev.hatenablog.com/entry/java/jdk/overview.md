---
Title: JDK：概要
Category:
- Java
Date: 2019-12-03T14:20:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178884011
---

JDK の概要や、JDK を使う前に知っておきたいことを書いています。

## 1. JDK は 開発ツール
JDK は Java Development Kit の略で、直訳すると「Java の開発道具（ツール）」です。JDK には、以下のツールが含まれています。

- コンパイラ：Java のプログラムをコンパイルする
- JRE：コンパイルしたプログラムを実行する
- デバッガ：デバッグを支援する
- 等々


## 2. Amazon の JDK は無料
Amazon が提供している JDK（Amazon Corretto）は、無料で使うことができます。このブログは、以前 Oracle の JDK を使ってたんですが、現在 Amazon Corretto に切り替え中です。

[https://aws.amazon.com/jp/corretto/:embed:cite]


## 3. Oracle の JDK は非推奨
無償で利用したい場合、Oracle の JDK は使わないほうが良いかと思います。無料の JDK も提供しているようですが、ライセンス体系が不明瞭だったり、サポート期間が短かったり、あまりメリットを感じられませんでした。

Amazon の JDK を避けたい場合でも、AdoptOpenJDK などの選択肢がありそうです。

[https://adoptopenjdk.net/index.html:embed:cite]


## 補足：JRE について
JRE は Java Runtime Environment の略で、直訳すると「Java の実行環境」です。Java のプログラムを実行するには、コンパイルしたプログラム（バイトコード）と JRE（実行環境）が必要になります。

JRE には、Java の実行に必要なライブラリや、Java 仮想マシン（JVM：Java Virtual Machine）などが含まれています。
