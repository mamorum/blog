---
Title: Java：Google Http Client で HTTP通信
Category:
- Java
Date: 2016-09-14T18:53:47+09:00
URL: http://web-dev.hatenablog.com/entry/java/google/http-client
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687184369326
---

[Google の Http Client](https://github.com/google/google-http-java-client) を使って、Java で HTTP通信をする方法を書いていこうと思います。


## HTTP接続ライブラリの選択
Google Http Client では、HTTP接続ライブラリを次の３種類から選択できるようです。

- NetHttpTransport（JDK の HttpURLConnection がベース）
- ApacheHttpTransport（Apache HttpClient がベース）
- UrlFetchTransport（Google App Engine SDK の API がベース）

ライブラリによって、Google Http Client が使う低レベルのＡＰＩが違ってきます。この記事では、１番上のライブラリを使うことにしています。


## インストール
Maven や Gradle を使っている場合、次の依存性を追加します。

```txt
<dependency>
  <groupId>com.google.http-client</groupId>
  <artifactId>google-http-client</artifactId>
  <version>1.20.0</version>
</dependency>
```

```groovy
compile 'com.google.http-client:google-http-client:1.20.0'
```

## サンプルコード１（GET）
次のコードは、GET のリクエストを送信するサンプルです。

```java
package ghc;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;

public class Main {

  // 1. ファクトリーを作成（スレッドセーフ）
  static HttpRequestFactory fac
    = (new NetHttpTransport()).createRequestFactory();
  
  public static void main(String[] args) {
    HttpResponse res = null;
    try {
      // 2. リクエストの送信
      res = fac.buildGetRequest(
        new GenericUrl("http://google.co.jp/")
      ).execute();
      
      // 3. レスポンスの操作
      System.out.println(
        "Get response. [status=" + res.getStatusCode() + "]"
      );
      System.out.println(res.parseAsString());
    }
    catch (HttpResponseException e) {
      System.err.println(  // エラー発生時
        "Error. [staus=" + e.getStatusCode() + "]"
      );
      throw new RuntimeException(e);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    finally {
      try { if (res != null) res.disconnect(); }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
```

ちょっと例外処理が多くなってますが、コメントの 1. ~ 3. の箇所がポイントになります。

リクエストパラメータを送りたい場合は、URL にクエリ（例：`?key1=val1&key2=val2`）を付けます。


## 動作確認
サンプルプログラムを実行すると、レスポンスが次のように表示されます。

```txt
Get response. [status=200]
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ja">・・・省略
```

## サンプルコード２（GET以外）
POST などでパラメータや JSON などを送りたい場合は、サンプルコードの 2. を次のように変更します。

### パラメータを送信

```java
res = fac.buildRequest(
  "POST", new GenericUrl("http://....."),
  ByteArrayContent.fromString(
    "application/x-www-form-urlencoded",
    "key1=val1&key2=key2"  // パラメータ
  )
).execute();  
```

### JSON を送信

```java
res = fac.buildRequest(
  "POST", new GenericUrl("http://....."),
  ByteArrayContent.fromString(
    "application/json",
    "{\"key\":\"val\"}"  // JSON文字列
  )
).execute();  
```

HTTP メソッドは、上の `"POST"` を `"PUT"` や `"DELETE"` 等にすれば変更できます。


## 参考文献
[HTTP Client のガイド](https://developers.google.com/api-client-library/java/google-http-java-client/transport) で、特に参照したページをまとめました。

- [HTTP接続ライブラリの解説](https://developers.google.com/api-client-library/java/google-http-java-client/transport)
- [Maven の依存性](https://developers.google.com/api-client-library/java/google-http-java-client/setup#google-http-client)

