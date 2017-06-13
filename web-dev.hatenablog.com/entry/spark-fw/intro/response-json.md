---
Title: Spark FW：JSONを返す
Category:
- SparkFW
Date: 2017-04-19T11:10:24+09:00
URL: http://web-dev.hatenablog.com/entry/spark-fw/intro/response-json
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687238002871
---

Java の [Spark Framework](http://sparkjava.com/) を使って、JSON の HTTP レスポンスを返してみます。


## 前提. アプリ資源について
この記事では、[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world) の資源（ビルドファイル、コード）を使っています。必要に応じて参照して頂けると嬉しいです。


## 手順1. ビルドファイルの編集
記事「[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world)」のビルドファイルに、[GSON](https://github.com/google/gson) の依存性を追加します。

`sprkgs/pom.xml（追加部分）`

```
  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.0</version>
  </dependency>
```

## 手順2. メインクラスの編集
HelloWorld の記事で作成した `Main.java` を編集します。

```java
package sprkgs;

import static spark.Spark.*;

import java.util.Collections;
import java.util.Map;

import com.google.gson.Gson;

public class Main {
  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
    get("/json", (req, res) -> msg, gson::toJson);
  }
  static final Map<String, String> msg
    = Collections.singletonMap("msg", "Hello");

  static final Gson gson = new Gson();
}
```

２つめの get 呼び出し（`get("/json", ....`）から末尾までを追加しています。GSON の toJson をメソッド参照で渡すと JSON にしてくれるみたいです。


## 手順3. アプリ起動
上の `Main.java` を Java アプリとして実行します。

コマンドラインからの実行方法は、HelloWorld の記事にも書いてあります。


## 手順4. 確認
`http://localhost:4567/json` にアクセスすると、`{"msg":"Hello"}` が返ってきます。

ちょっと気になったのは、レスポンスのコンテントタイプが `text/html` だったことです。コンテントタイプも JSON にしたい場合は、次のように `application/json` を設定すると良いかもしれません。

```java
get("/json", (req, res) -> {
  res.type("application/json;charset=UTF-8");
  return msg;
}, gson::toJson);
```

うーん、もうちょっと良い方法があるのでしょうか。


## 参考文献
[ResponseTransformer - Spark](http://sparkjava.com/documentation.html#response-transformer)


## コード
[sprkgs - GitHub](https://github.com/mamorum/blog/tree/master/code/sprkgs)
