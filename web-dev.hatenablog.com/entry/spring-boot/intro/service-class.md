---
Title: SpringBoot入門：サービスクラスを使う
Category:
- Spring
Date: 2017-02-18T17:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/service-class
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179105969
---

Spring Boot の Webアプリで、サービスクラスを使う方法を書きます。サービスクラスは「[ドメイン駆動設計 - Wikipedia](https://ja.wikipedia.org/wiki/%E3%83%89%E3%83%A1%E3%82%A4%E3%83%B3%E9%A7%86%E5%8B%95%E8%A8%AD%E8%A8%88)」に登場するオブジェクトで、なんらかの処理（機能）を実装するものです。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. サービスクラスの作成
例として、乱数を生成するサービスクラスを実装してみます。

`gssb/src/main/java/gssb/service/RandomNumberService.java`

```java
package gssb.service;

import org.springframework.stereotype.Service;

@Service  // サービスクラスに付与。
public class RandomNumberService {

  // 整数0-9の乱数を返却。
  public int zeroToNine() {
    return (int) (Math.random() * 10);
  }
}
```

`@Service` が付いていると、アプリ起動時に SpringBoot（のコンテナ）が管理してくれます。管理されたオブジェクトは、他のオブジェクトに設定（DI：Dependency Injection）できたりします。


## 手順2. コントローラの作成
乱数をレスポンスとして返却するクラスを作成します。

`gssb/src/main/java/gssb/service/RandomNumberService.java`

```java
package gssb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gssb.service.RandomNumberService;

@RestController
public class RandomNumberController {

  // サービスクラスがＤＩされる。
  @Autowired RandomNumberService random;
  
  // 乱数をレスポンスとして返却する。
  @RequestMapping("/random")
  public Map<String, Integer> random() {
    int value = random.zeroToNine();
    return Collections.singletonMap("value", value);
  }
}
```

`@Autowired` が付いた変数 `random` に、 先程のサービスクラスが設定（DI）されます。


## 手順3. 起動
次のコマンドでアプリを起動します。

```txt
gssb > mvn spring-boot:run
```


## 手順4. 確認
`http://localhost:8080/random` にアクセスして、次のような JSON が返ってくれば成功です。

```
{"value":0}
```


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
