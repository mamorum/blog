---
Title: SpringBoot：H2DBに接続
Category:
- spring-boot
Date: 2016-03-11T18:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/connect-h2db
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179110941
---

Spring Boot は、アプリが H2DB に依存していると、自動的に「組み込みの H2DB（インメモリの DB）」を起動します。今回は、Spring Boot が起動した H2DB に接続する方法を紹介します。


## 手順1. ビルドファイルの作成
プロジェクト名 `sbh2` のディレクトリ配下に、Gradle のビルドファイルを作成します。

`sbh2/build.gradle`

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath('org.springframework.boot:spring-boot-gradle-plugin:1.3.3.RELEASE')
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'spring-boot'
compileJava.options.encoding = 'UTF-8'

sourceCompatibility = 1.8
targetCompatibility = 1.8

jar {
    baseName = 'sbh2'
    version = '0.0.1'
}

repositories {
    mavenCentral()
}
dependencies {
    compile 'org.springframework.boot:spring-boot-starter-web'
    compile 'org.springframework:spring-jdbc'
    compile 'com.h2database:h2'
}
```

依存性に H2DB を追加しています。


## 手順2. 設定ファイルの作成
SpringBoot の設定ファイルを追加（or 編集）して、H2DB のコンソールを表示可能にします。

`sbh2/src/main/resources/application.properties`

```txt
spring.h2.console.enabled=true
```


## 手順3. アプリ起動クラスの作成
アプリを起動するクラスを作成します。動作確認のため、起動時に `TASK` テーブルを作成して、データを投入するようにしています。


`sbh2/src/main/java/sbh2/App.java`

```java
package sbh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}
	
	@Autowired JdbcTemplate jdbc;

	// アプリ起動時に実行される。
	@Override public void run(String... args) throws Exception {
		jdbc.execute("create table task (id serial, name varchar(255))");
		jdbc.update("insert into task (name) values (?)", "First Task.");
	}
}
```


## 手順4. アプリを起動
次のコマンドで起動します。

```txt
sbh2 > gradle bootRun
```


## 手順5. 接続
アプリが起動したら、ブラウザで `http://localhost:8080/h2-console` を開きます。

![h2-console-login](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814221435.png)

ログイン画面で下の値を設定して、接続（Connectボタンを押下）します。

```txt
Driver Class : org.h2.Driver
JDBC URL : jdbc:h2:mem:testdb
User Name : sa
Password :
```

## 手順6. 確認
接続すると、次の画面で SQL を実行できたりします。

![h2-console-sql](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814221436.png)

`TASK` テーブルが作成されて、データが投入されていることを確認できました。
