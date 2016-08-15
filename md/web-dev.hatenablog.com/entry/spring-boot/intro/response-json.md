---
Title: SpringBoot入門：JSONの返却
Category:
- Spring Boot 入門
Date: 2016-06-10T16:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/response-json
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179105567
---

Spring Boot を使って、サーバから JSON を返却する方法を紹介します。

次の URL にリクエストすると、

```txt
http://localhost:8080/hello
```

次のレスポンスを返す例を書いていきます。

```json
{"message":"Hello, World!"}
```


## 環境・ツール
- JDK 1.8 以上
- Gradle 2.3 以上（or Maven 3.0 以上）


## 手順1. ビルドファイルの作成
Gradle のビルドファイルを作成します。アプリのルートディレクトリは `gssb` としています。


`gssb/build.gradle`

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
    baseName = 'gssb'
    version = '0.0.1'
}

repositories {
    mavenCentral()
}
dependencies {
    compile 'org.springframework.boot:spring-boot-starter-web'
}
```


## 手順2. コントローラの作成
リクエストを受け付けて、JSON を返却するクラスです。

`gssb/src/main/java/gssb/controller/HelloController.java`

```java
package gssb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // JSON を返すコントローラに付与。
public class HelloController {

    // リクエスト /hello に対して実行されるメソッド。
    @RequestMapping("/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }
}
```


## 手順3. 起動クラスの作成
SpringBoot のアプリを起動するクラスを作成します。

`gssb/src/main/java/gssb/App.java`

```java
package gssb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```


## 手順4. 起動
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
（省略）
・・・Started Application in 4.525 seconds (JVM running for 5.188)
```


## 手順5. 確認
`http://localhost:8080/hello` にアクセスして、冒頭の JSON が返ってくれば成功です。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
