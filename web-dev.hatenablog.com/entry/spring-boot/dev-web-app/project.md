---
Title: SpringBoot アプリ開発：3.プロジェクト作成
Category:
- Java
Date: 2016-06-23T22:10:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179183467
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/overview) のアプリ）の ディレクトリ構成や、ビルドファイル・設定ファイルを作成していきます。


## ディレクトリ構成
事前に次のようなディレクトリ構成を作成しておきます。括弧内に書いているのは、ディレクトリ内に保存する資源です。

```txt
sbt
└─src
    ├─main
    │  ├─java
    │  │  └─sbt（プロダクトコード）
    │  └─resources
    │         ├─public（HTML, CSS, JS, IMG）
    │         └─db
    │               └─migration（SQLファイル）
    └─test
        └─java
            └─sbt（テストコード）
```


## ビルドファイルの作成
次の内容で、ビルドファイルを作成します。

`sbt/build.gradle`

```gradle
buildscript {
    repositories { mavenCentral() }
    dependencies { classpath('org.springframework.boot:spring-boot-gradle-plugin:1.3.5.RELEASE') }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'spring-boot'

compileJava.options.encoding = 'UTF-8'
sourceCompatibility = 1.8
targetCompatibility = 1.8

jar {
    baseName = 'sbt'
    version = '0.1.0'
}

repositories.mavenCentral()
dependencies {
    compile 'org.springframework.boot:spring-boot-starter-web'
    compile 'org.springframework.boot:spring-boot-starter-data-jpa'
    compile 'org.flywaydb:flyway-core'
    compile 'org.postgresql:postgresql'
    testCompile 'org.springframework.boot:spring-boot-starter-test'
    testCompile 'org.fluentlenium:fluentlenium-assertj:0.10.6'
    testCompile 'xml-apis:xml-apis:1.4.01'
}
```

先頭の `buildscript ...` は、SpringBoot を利用するために必要です。末尾の `dependencies ...` は、使用するプロダクトを書いています。


## 設定ファイルの作成
YAML 形式の設定ファイルを作成します。

`sbt/src/main/resources/application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/sbt
    driverClassName: org.postgresql.Driver
    username: spring
    password: spring
  mvc:
    favicon:
      enabled: false
```

ＤＢ関連の設定を `datasource:` 配下に書いています。前回記事のＤＢユーザ等を設定しています。

`mvc:` 配下は、`favicon.ico（ファビコン）` の設定です。SpringBoot のファビコンを無効にして、自前のファビコンを（利用者のブラウザに）表示するためです。
