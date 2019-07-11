---
Title: Gradle：Herokuにデプロイ
Category:
- etc
Date: 2016-07-28T11:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gradle/deploy-to-heroku
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179310156
---

Gradle をう SpringBoot の Webアプリを、Heroku にデプロイする手順を書いていきます。


## 前提1. Heroku 関連
Heroku に関連する前提条件は次の通りです。

- Heroku のアカウントがあること。
- Heroku Toolbelt がインストールされていること。


## 前提2. デプロイするアプリ
`/hello` にアクセスすると、JSON を返すアプリをデプロイします。

`demo/src/main/java/demo/App.java`

``` java
package demo;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController 
@SpringBootApplication
public class App {

  @RequestMapping("/hello")
  public Map<String, String> hello() {
    return Collections.singletonMap("content", "Hello, World.");
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
```

デプロイ前のビルドファイルは次の通りです。

`demo/build.gradle`

```gradle
buildscript {
  ext {
    springBootVersion = '1.3.6.RELEASE'
  }
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
  }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'spring-boot'

jar {
  baseName = 'demo'
  version = '0.0.1'
}
sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
  mavenCentral()
}

dependencies {
  compile('org.springframework.boot:spring-boot-starter-web')
  testCompile('org.springframework.boot:spring-boot-starter-test')
}
```


## 手順1. ビルドファイルの編集
Spring Boot アプリの場合、次の stage タスクを追加します。

`demo/build.gradle`

```
・・・省略・・・

task stage {
  dependsOn build
}
```

## 手順2. Procfile の作成
Procfile には、アプリケーションを実行するコマンドを書きます。Spring Boot アプリの場合は、次のようになります（jar名称はビルドファイルの設定に従います）。

`demo/Procfile`

```
web: java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/demo-0.0.1.jar
```

## 手順3. アプリを Git に追加
※ 既に Git で管理しているアプリの場合、この作業は不要になります。git clone などでアプリを取得しておけば大丈夫です。

次のコマンドを実行して、アプリを Git で管理します。

```
$ cd demo

$ git init
$ git add .
$ git commit -m "Initial"
```


## 手順4. ローカルでの起動・確認
次のコマンドでアプリを起動します。

```
$ gradle stage
$ heroku local web
```

アプリ起動後、`http://localhost:5000/hello` にアクセスすると、JSON を受け取ることができます。

```
$ curl http://localhost:5000/hello
{"content":"Hello, World."}
```


## 手順5. Heroku へのデプロイ
次のコマンドを実行していきます。

```
$ heroku login
-> Heroku の認証情報を入力

$ heroku create
Creating・・・

$ git push heroku master
・・・
remote: -----> Launching...
remote:        Released v3
remote:        https://salty-brook-51682.herokuapp.com/ deployed to Heroku
・・・
```

## 手順6. 動作確認
デプロイ完了後、表示されたURLの末尾に「hello」を付けて、`https://salty-brook-51682.herokuapp.com/hello` にアクセスします。（※URLは可変でHerokuが設定します。）

![app-page](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160816/20160816104857.png)

ちゃんとJSONが返ってきています。

Heroku の管理画面でも、デプロイされたことが確認できます。

![heroku-page](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160816/20160816104858.png)


## 補足. Heroku の仕様（Gradle 関連）
アプリに `build.gradle`, `setting.gradle` もしくは `gradlew` が含まれていると、Heroku は Gradle でビルドしてくれるようです。

`gradlew（Gradle ラッパー）` を使う場合は、`gradle/wrapper/gradle-wrapper.jar` と `gradle/wrapper/gradle-wrapper.properties` を Git リポジトリにコミットしておけば大丈夫そうです。


## 参考文献
[Deploying Gradle Apps on Heroku - Heroku Dev Center](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku)
