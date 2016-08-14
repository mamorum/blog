---
Title: SpringBoot入門：外部のサービスに接続
Category:
- spring-boot
Date: 2016-03-11T17:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/ex-service
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179106615
---

Spring Boot の Web アプリ（サーバサイドの Java）から、外部のサービスに接続する方法を書きます。

今回は、Spring Boot が提供するサービス `http://gturnquist-quoters.cfapps.io/api/random` に接続して、JSON を取得してみます。JSON の内容は、次のようなものです。

```json
{
   "type": "success",
   "value": {
      "id": 10,
      "quote": "Really loving Spring Boot, makes stand alone Spring apps easy."
   }
}
```


## 前提
この記事は、入門記事「[JSONの返却](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
Spring Framework の `RestTemplate` を使って外部サービスに接続します。外部サービスの JSON を、レスポンスとして返却します。

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

外部サービスの JSON を POJO にしたい場合は、２つ目のメソッド `getObject` が参考になると思います。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
```

## 手順3. 確認
動作確認には curl を使います。１つ目のメソッドを、次のように確認してみます。

```txt
> curl http://localhost:8080/ex/exchange
{"type":"success","value":{"id":12,"quote":"@springboot with @springframework is
 pure productivity! Who said in #java one has to write double the code than in o
ther langs? #newFavLib"}}
```

２つ目のメソッドも確認してみます。

```txt
> curl http://localhost:8080/ex/get-object
{"type":"success","value":{"id":4,"quote":"Previous to Spring Boot, I remember X
ML hell, confusing set up, and many hours of frustration."}}
```

どちらも外部サービスの JSON を返してくれます。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。

