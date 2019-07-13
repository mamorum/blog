---
Title: Maven Central（Nexus）で Close エラー
Category:
- Java
Date: 2017-05-16T11:21:20+09:00
URL: https://web-dev.hatenablog.com/entry/maven/central/nexus-close-error
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687246934140
---

Maven Central Repository に jar をデプロイしてから、[Nexus Repository Manager](https://oss.sonatype.org/#welcome) で Close 処理をしたらエラーになったことがありました。

エラーのタイプは２つ確認していて、その詳細や対応方法をまとめてみました。


## エラーのタイプ
### 1. POM Validation のエラー
Close 処理をした後に、Nexus の画面で次のように表示されます。

[f:id:mamorums:20170516112002p:plain]

### 2. POM 以外の Validation エラー
次のバリデーションで、エラーが発生したことがありました。

- Sources Validation
- Javadoc Validation
- Signature Validation

こちらのエラーも Nexus の画面で表示されます。

[f:id:mamorums:20170516112018p:plain]

## 原因
どちらも `pom.xml` の要素（タグ）が不足していることが原因でした。


## 対応方法
### 1. POM Validation のエラー
`pom.xml` に以下の要素を書くと、エラーが発生しなくなりました。

- name
- description
- url
- licenses
- scm
- developers

### 2. POM 以外の Validation エラー
`pom.xml` の build 要素に以下のプラグインを追加したら、エラーが発生しなくなりました。

- maven-source-plugin
- maven-javadoc-plugin
- maven-gpg-plugin

追加方法は、[こちら](http://central.sonatype.org/pages/apache-maven.html) のページに記載されていました。


## pom.xml のサンプル
Maven Central 用のシンプルな `pom.xml` が、GitHub で公開されていました。

[pom.xml - simpligility/ossrh-demo](https://github.com/simpligility/ossrh-demo/blob/master/pom.xml)

エラーになったらサンプルと比較してみるのもよさそうです。


## 参考資料
[Deploying to OSSRH with Apache Maven - The Central Repository](http://central.sonatype.org/pages/apache-maven.html)
