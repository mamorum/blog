---
Title: SpringBoot入門：Mustacheを使う
Category:
- Spring
Date: 2017-04-07T14:18:37+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/mustache-template
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687235335739
---

Spring Boot の Webアプリで、テンプレートエンジンの Mustache を使う方法を書いてみようと思います。Mustache で HTML をレンダリングして、レスポンスとして返してみます。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順2. ビルドファイルの編集
記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の `pom.xml` に、次の依存性を追加します。

```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-mustache</artifactId>
    </dependency>
```


## 手順1. コントローラの作成
Mustache（View）で使う値（Model）を設定するコントローラ（Controller）を作成します。戻り値はテンプレートのファイル名です。

```java
package gssb.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MstController {

  @RequestMapping("/hello-mst")
  public String hello(
    @RequestParam(defaultValue="World") String name,
    Map<String, Object> model
  ) {
    model.put("name", name);
    model.put("date", new Date());
    return "hello-mst";
  }
}

```

MVC なので、クラスアノテーションは `@Controller` にします。


## 手順2. 画面の作成
Mustache を使うテンプレートを作成します。`model` に設定された値をプレースホルダ `{{key}}` で取得しています。

`gssb/src/main/resources/templates/hello-mst.html`

```html
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hello Mustache</title>
</head>
<body>
<div>
  <p><b>Message:</b> Hello, {{name}}</p>
  <p><b>Date:</b> {{date}}</p>
</div>
</body>
</html>
```

テンプレートエンジンの置き場所は、デフォルトだと `templates` 配下になるみたいです。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
```


## 手順3. 確認
ブラウザで `http://localhost:8080/hello-mst` にアクセスすると、次のように表示されます。

```txt
Message: Hello, World

Date: Fri Apr 07 14:11:33 JST 2017
```

リクエストパラメータをつける `http://localhost:8080/hello-mst?name=Tom` と、次のように表示されます。

```txt
Message: Hello, Tom

Date: Fri Apr 07 14:12:12 JST 2017
```

## 参考文献
[spring-boot-samples/spring-boot-sample-web-mustache - GitHub](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-web-mustache)

## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog-code/tree/master/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
