Java の Webアプリケーションフレームワーク「[Spark Framework](http://sparkjava.com/)」を使って、Hello World を返す方法を書いてみます。

Spark Framework は、軽量・ラムダでシンプルに書ける・[Express](http://expressjs.com/)（Node.js の Webアプリケーションフレームワーク）のように書ける・等々といった特徴があります。


## 手順1. ビルドファイルの作成
プロジェクトのディレクトリ（例. `sprkgs`）の下に `pom.xml` を作成します。

`sprkgs/pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>sprkgs</artifactId>
  <version>1.0.0</version>

  <dependencies>
    <dependency>
      <groupId>com.sparkjava</groupId>
      <artifactId>spark-core</artifactId>
      <version>2.5.5</version>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```

コンパイラは `1.8` を使うようにしてます。


## 手順2. メインクラスの作成
Webアプリケーションを起動するクラスを作成します。

`sprkgs/src/main/java/sprkgs/Main.java`

```java
package sprkgs;

import static spark.Spark.*;

public class Main {
  public static void main(String[] args) {
    get("/hello", (req, res) -> "Hello World");
  }
}
```

Httpリクエスト `GET /hello` に対して、テキストの `Hello World` を返す感じです。


## 手順3. アプリ起動
Eclipse などのIDEから、作成したメインクラスを Javaアプリケーションとして実行します。

Mavenコマンド（`mvn`）を使うと、コマンドラインから起動できたりします。

```
sprkgs > mvn exec:java -Dexec.mainClass=sprkgs.Main
```

## 手順4. 確認
ブラウザで `http://localhost:4567/hello` にアクセスすると `Hello World` が表示されます。

レスポンスヘッダのコンテントタイプは、`Content-Type:text/html;charset=utf-8` でした。


## 参考文献
[Getting started - Spark](http://sparkjava.com/documentation.html)


## コード
