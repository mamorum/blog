---
Title: SpringBoot：外部のサービスに接続
Category:
- Java
Date: 2017-02-18T17:10:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/ex-service
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179106615
---

Spring Boot の Web アプリ（サーバサイドの Java）から、外部のサービスに接続する方法を書きます。

今回は、Spring Boot が提供するサービス `http://gturnquist-quoters.cfapps.io/api/random` に接続して、JSON を取得してみます。JSON の内容は、次のようなものです。

```
{
  "type": "success",
  "value": {
    "id": 10,
    "quote": "Really loving Spring Boot, makes stand alone Spring apps easy."
  }
}
```


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
Spring Framework の `RestTemplate` を使って外部サービスに接続します。

`gssb/src/main/java/gssb/controller/AccessingExternalServiceController.java`

```java
package gssb.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccessingExternalServiceController {

  // RestTemplate はスレッドセーフ
  // https://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate/
  private final RestTemplate rt = new RestTemplate();

  // 外部サービスの URL 
  // https://spring.io/guides/gs/consuming-rest/
  private final String url = "http://gturnquist-quoters.cfapps.io/api/random";

  // 外部サービスの JSON を、そのまま（JSON のまま）返却。
  @RequestMapping(value="/ex/exchange")
  public ResponseEntity<String> exchange() {
    return rt.exchange(url, HttpMethod.GET, null, String.class);
  }

  // 外部サービスの JSON を、一度オブジェクトにしてから返却。
  @RequestMapping(value="/ex/get-object")
  public RandomValue getObject() {
    return rt.getForObject(url, RandomValue.class);
  }
  public static class RandomValue {
    public String type;
    public Value value;   
  }
  public static class Value {
    public long id;
    public String quote;
  }
}
```

上のコントローラでは、外部サービスに接続するメソッドを２つ実装しています。

### 1.1. メソッド #exchange()
外部サービスの JSON を、そのまま（文字列のまま）レスポンスとして返しています。

### 1.2. メソッド #getObject()
外部サービスの JSON を 内部クラス `RandomValue` に変換して、レスポンスとして返しています。値を POJO として使いたいときに向いていると思います。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
```

## 手順3. 確認
１つ目のメソッドを確認するために、`http://localhost:8080/ex/exchange` にアクセスします。

```txt
{"type":"success","value":{"id":12,"quote":"@springboot with @springframework is
 pure productivity! Who said in #java one has to write double the code than in o
ther langs? #newFavLib"}}
```
上のような JSON が返ってくれば成功です。

２つ目のメソッドは、`http://localhost:8080/ex/get-object` にアクセスします。

```txt
{"type":"success","value":{"id":4,"quote":"Previous to Spring Boot, I remember X
ML hell, confusing set up, and many hours of frustration."}}
```

こちらも JSON が返ってくれば成功です。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
