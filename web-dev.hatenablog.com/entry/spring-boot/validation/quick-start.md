---
Title: SpringBoot入門：バリデーションをする
Category:
- SpringBoot
Date: 2016-07-25T16:40:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/validation/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179545113
---

Spring Boot の Webアプリで、バリデーション（入力値検証）をする方法を書いていきます。バリデーションには、javax.validation や Hibernate Validator のアノテーションを使います。


## 前提
この記事は、入門記事「[JSONの返却](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
リクエストの JSON をメソッド引数のオブジェクトにバインドして、その値をバリデートするコントローラを作成します。

`gssb/src/main/java/gssb/controller/ValidationController.java`

```java
package gssb.controller;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

  @RequestMapping(value="/address", method=RequestMethod.POST)
  public Address create(@Valid @RequestBody Address address) {
    return address;
  }
  
  public static class Address {
    
    @NotEmpty
    @Size(min=7, max=7)
    public String zip;
    
    @NotEmpty
    public String address;
  }
}
```

メソッド引数のオブジェクトに `@Valid` を付けるとバリデーションが実行されるようです。どのバリデーションをするかは、オブジェクトのコードに定義します。上の例だと、Address クラスの `@NotEmpty` や `@Size` がバリデーションの定義になります。


## 手順2. 起動
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
```


## 手順4. 確認
### 手順 4.1. 正常系
入力値（リクエストの JSON）に問題がない場合、コントローラは入力値をそのまま返します。

`確認コマンド（※ JSON 内のエスケープ文字「\」は Windows で必要）`

```txt
curl http://localhost:8080/address -H "Content-Type: application/json" -d "{\"zip\":\"1234567\", \"address\":\"Japan\"}" -X POST
```

`結果`

```txt
{"zip":"1234567","address":"Japan"}
```

### 手順 4.2. バリデーションエラー
「zip を 6桁」「address を空文字」にして、リクエストを送ってみます。

`確認コマンド（※ JSON 内のエスケープ文字「\」は Windows で必要）`

```txt
curl http://localhost:8080/address -H "Content-Type: application/json" -d "{\"zip\":\"123456\", \"address\":\"\"}" -X POST
```

`結果`

```txt
{"timestamp":1469434038414,"status":400,"error":"Bad Request","exception":"org.springframework.web.bind.MethodArgumentNotValidException","errors":[{"codes":["NotEmpty.address.address","NotEmpty.address","NotEmpty"],"arguments":[{"codes":["address.address","address"],"arguments":null,"defaultMessage":"address","code":"address"}],"defaultMessage":"may not be empty","objectName":"address","field":"address","rejectedValue":"","bindingFailure":false,"code":"NotEmpty"},{"codes":["Size.address.zip","Size.zip","Size"],"arguments":[{"codes":["address.zip","zip"],"arguments":null,"defaultMessage":"zip","code":"zip"},7,7],"defaultMessage":"size must be between 7 and 7","objectName":"address","field":"zip","rejectedValue":"123456","bindingFailure":false,"code":"Size"}],"message":"Validation failed for object='address'. Errorcount: 2","path":"/address"}
```

正常系とは違う JSON が返ってきました。よく見ると、エラーは２つ（`Errorcount: 2`）で、zip（`size must be between 7 and 7`）と address（`may not be empty`）のエラー情報が確認できます。


今回は、バリデーションをしてエラーが発生するところまで書きました。エラーハンドリングの方法などは、別の記事で書いていこうと思います。
