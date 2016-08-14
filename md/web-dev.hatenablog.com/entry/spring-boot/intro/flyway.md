---
Title: SpringBoot入門：FlywayでDBマイグレーション
Category:
- spring-boot
Date: 2016-06-05T17:17:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/flyway
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179106994
---

Flyway は、SQLベースのDBマイグレーションツールです。DBマイグレーションとは、DBのデータを残したまま、テーブル作成やカラム変更等をすることです。

SpringBoot のアプリで Flyway を使うと、起動時にマイグレーション用のSQLが実行されるようになります。

これから Flyway を使う手順を書いていきます。


## 環境・ツール
- JDK 1.8 以上
- Gradle 2.3 以上
- PostgreSQL（執筆時 9.4）


## 手順1. ビルドファイルの作成
Gradle のビルドファイルを作成します。アプリのルートディレクトリは `gssb-rdb` としています。

`gssb-rdb/build.gradle`

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath('org.springframework.boot:spring-boot-gradle-plugin:1.3.5.RELEASE')
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'spring-boot'
compileJava.options.encoding = 'UTF-8'

sourceCompatibility = 1.8
targetCompatibility = 1.8

jar {
    baseName = 'gssb-rdb'
    version = '0.0.1'
}

configurations {
    provided
}
sourceSets {
    main.compileClasspath += configurations.provided
    test.compileClasspath += configurations.provided
}
eclipse.classpath {
    plusConfigurations += [configurations.provided]
}

repositories {
    mavenCentral()
}
dependencies {
    provided 'org.projectlombok:lombok:1.16.6'
    compile 'org.springframework.boot:spring-boot-starter-web'
    compile 'org.springframework.boot:spring-boot-starter-data-jpa'
    compile 'org.flywaydb:flyway-core'
    compile 'org.postgresql:postgresql'
}
```

依存性に `postgresql（ドライバ）`, `flyway-core` を定義しています。`lombok`, `spring-boot-starter-web`, `spring-boot-starter-data-jpa` も、追加しています（関連記事で使用するため）。


## 手順2. SQLファイルの作成
マイグレーション（テーブル作成）用の SQLファイルを準備します。SQLファイルは、クラスパス直下の `db/migration` ディレクトリに置くことになっています。

`gssb-rdb/src/main/resources/db/migration/V1__Create.sql`

```sql
create table memo (
	id serial primary key,
	text varchar(255) not null,
	version integer not null default 0,
	updated_time timestamp not null default current_timestamp,
	created_time timestamp not null default current_timestamp
);
```

ファイルの命名規約は次の通りです。

```txt
V<Version>__<NAME>.sql
```

- V：アルファベット大文字の V です。
- <Version\>：数字の 1 や 2_1（アンダースコア区切り）です。SQL ファイルが増えたら、バージョンを上げていきます。
- __：アンダースコア２つです。<Version\> と <Name\> を区切ります。
- <Name\>：任意の文字列とされています。


## 手順3. 設定ファイルの作成
PostgreSQL に接続するためのファイルを準備します。

`gssb-rdb/src/main/resources/application.properties`

```txt
spring.datasource.url=jdbc:postgresql://localhost:5432/spring
spring.datasource.username=spring
spring.datasource.password=spring
spring.datasource.driver-class-name=org.postgresql.Driver
```

例として、接続先の DB名・ユーザ名・パスワードを `spring` としています。同じ接続先を作りたい場合は、[開発環境構築](/entry/etc/env/dev/table-of-contents) の PostgreSQL の箇所を参考にして頂けると嬉しいです。


## 手順4. 起動クラスの作成
SpringBoot アプリを起動するクラスを作成します。

`gssb-rdb/src/main/java/gssb/rdb/App.java`

```java
package gssb.rdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}
}
```


## 手順5. 起動
次のコマンドでアプリを起動します。（事前に PostgreSQL をローカルで起動している想定です。）

```txt
gssb-rdb > gradle bootRun

・・・Started Application in 4.525 seconds (JVM running for 5.188)
```

## 手順6. 確認
アプリ起動後に、PSQL でテーブルを確認しました。

```txt
spring=> select relname as table_name from pg_stat_user_tables;
   table_name
----------------
 memo
 schema_version
(2 行)
```

## 補足1. 次のマイグレーション
２回目以降は、命名規約に従って SQLファイルを用意します。例えば、`V2__Alter.sql`, `V3__Create.sql`, ... といったような感じです。


## 補足2. Flyway の仕様
SQLファイル は、同じスキーマで１回だけ実行されます。Flyway が、スキーマに管理テーブル「`schema_version`」を作成してコントロールしてくれます。

管理テーブルがなかったり（違う環境・違うスキーマ）、管理テーブルを削除したりすると、全ての SQLファイルが実行されます。


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
