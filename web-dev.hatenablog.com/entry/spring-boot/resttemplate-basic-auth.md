---
Title: SpringBoot：Basic認証の外部サービスに接続
Category:
- Spring
Date: 2016-07-12T15:41:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/resttemplate-basic-auth
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178793756
---

SpringBoot の `RestTemplate` を使って、Basic認証の外部サービス（はてなブログの AtomPub）に接続することがありました。そのときの Javaコード（一部）を書いていこうと思います。


## コード
Basic認証の情報を用意してから、`RestTemplate` を new して接続しています。

```java
import java.util.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {

  public static void main(String[] args) {

    String auth = new String(
      Base64.getEncoder().encode(
        "ユーザ:パスワード".getBytes()
      )
    );
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization","Basic " +  auth);
    HttpEntity<String> req = new HttpEntity<>(headers);
    RestTemplate client = new RestTemplate();
    
    ResponseEntity<String> res = client.exchange(
      "リクエストＵＲＬ",
      HttpMethod.GET, req, String.class
    );
    System.out.println(res.getBody());
  }
}
```

二重引用符内の「ユーザ」「パスワード」「リクエストＵＲＬ」を置き換えればいけると思います。ユーザとパスワードの区切り文字 `:` は必要です。


## 補足：ファイルに保存
上の例は結果を標準出力に出していますが、ファイルに保存したい場合もあると思います。外部サービスに接続したときは、`java.nio.*` を使って保存してみました。


```java
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// 省略

Files.write(
  Paths.get("ファイルのパス"),
  res.getBody().getBytes(Charset.forName("UTF-8")),
  StandardOpenOption.CREATE
);
```
