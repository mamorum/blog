---
Title: Spark FW：テンプレートエンジンを使う
Category:
- SparkFW
Date: 2017-04-23T11:40:40+09:00
URL: http://web-dev.hatenablog.com/entry/spark-fw/intro/mustache-template
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687239057140
---

Java の [Spark Framework](http://sparkjava.com/) を使ったアプリで、[jmustache](https://github.com/samskivert/jmustache)（Mustache の Java実装）を使う方法を書いていきます。


## 前提1. spark-template-mustache について
[Spark Framework のドキュメント](http://sparkjava.com/documentation.html#views-templates) だと、Mustache を使うために `spark-template-mustache` を依存性に追加しています。`spark-template-mustache` は、[mustache.java](https://github.com/spullara/mustache.java)（jmustache とは違う実装）を使うみたいです。


## 前提2. アプリ資源について
この記事では、[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world) の資源（ビルドファイル、コード）を使っています。必要に応じて参照して頂けると嬉しいです。


## 手順1. ビルドファイルの編集
記事「[Spark FW：HelloWorldを返す](/entry/spark-fw/intro/hello-world)」のビルドファイルに、jmustache の依存性を追加します。

`sprkgs/pom.xml（追加部分）`

```
  <dependency>
    <groupId>com.samskivert</groupId>
    <artifactId>jmustache</artifactId>
    <version>1.13</version>
  </dependency>
```


## 手順2. メインクラスの編集
HelloWorld の記事で作成した  `Main.java` を編集します。

```java
package sprkgs;

import static spark.Spark.*;

public class Main {
  public static void main(String[] args) {
    MustacheRoute.register();
    get("/hello", (req, res) -> "Hello World");
  }
}
```

main メソッド内の `MustacheRoute.register();` を追加しています。


## 手順3. MustacheRoute クラスの作成
Main から呼び出されるクラスを作成します。

`sprkgs/src/main/java/sprkgs/MustacheRoute.java`

```java
package sprkgs;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;

import com.samskivert.mustache.Mustache;

public class MustacheRoute {
  static void register() {
    get("/mst", (req, res) -> {
      Map<String, String> data = Collections.singletonMap(
        "name", req.queryParams("name")
      ); // throws MustacheException, if map value is null.
      return render("/tmpl/hello.mst", data);
    });
  }
  static String render(String path, Object data)
    throws UnsupportedEncodingException
  {
    return Mustache.compiler().compile(
      new BufferedReader(new InputStreamReader(
          MustacheRoute.class.getResourceAsStream(path), "utf-8")
      )
    ).execute(data);
  }
}
```

メソッド `#register()` で、HTTP リクエスト `GET /mst` に対する処理を登録しています。リクエストパラメータ `name` の値を取得して、テンプレート `/tmpl/hello.mst` をレンダリングするようにしています。


## 手順4. テンプレートの作成
Mustache テンプレートを作成します。

`sprkgs/src/main/resources/tmpl/hello.mst`

```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Mustache Page</title>
</head>
<body>
  <p>こんにちは {{name}}</p>
</body>
</html>
```

レンダリングの際に、プレースホルダ `{{name}}` が置換されます。


## 手順5. アプリ起動
上の `Main.java` を Java アプリとして実行します。

コマンドラインからの実行方法は、HelloWorld の記事にも書いてあります。


## 手順6. 確認
ブラウザで `http://localhost:4567/mst?name=%E3%83%88%E3%83%A0` にアクセスすると、次の文字列が表示されます。

```
こんにちは トム
```

今回は日本語をためしてみました。



## 参考文献
[Views and Templates - Spark](http://sparkjava.com/documentation.html#views-templates)


## コード
[sprkgs - GitHub](https://github.com/mamorum/blog/tree/master/code/sprkgs)
