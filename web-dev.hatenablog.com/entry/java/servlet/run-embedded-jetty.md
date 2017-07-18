---
Title: Servlet：組込Jettyの起動
Category:
- Java
Date: 2017-07-18T12:00:25+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/run-embedded-jetty
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812280664316
---

組み込み Jetty（9.4.6）を使って、Java のサーブレット（spec 3.1）を動作させる環境をつくってみました。


## 手順1. プロジェクトの作成
プロジェクトのルートディレクトリ `ssej` の下に、以下の `pom.xml` を作成します。

`ssej/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.domain</groupId>
  <artifactId>ssej</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-annotations</artifactId>
      <version>9.4.6.v20170531</version>
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

サーブレットでアノテーション（`@WebServlet` 等）を使うため、`jetty-annotations` に依存させています。


## 手順2. Main クラスの作成
組み込み Jetty を起動するクラスを作成します。

`ssej/src/main/java/sjs/Main.java`

```java
package ssej;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class Main {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    WebAppContext ctx = new WebAppContext();
    ctx.setConfigurations(new Configuration[] {
      new AnnotationConfiguration(),
      new WebXmlConfiguration(),
      new WebInfConfiguration(),
      new FragmentConfiguration(),
      new EnvConfiguration(),
      new PlusConfiguration()
    });
    ctx.setContextPath("/");
    // ↓ssej のコードをアプリのクラスパスに追加
    ctx.setExtraClasspath("./");
    // ↓静的コンテンツはクラスパスの public 配下に置く
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    svr.setHandler(ctx);
    svr.start();
    svr.join();
  }
}
```

## 手順3. 確認用資源の作成 
### 3.1. サーブレット
`/text` の要求を処理するサーブレットを作成します。

`ssej/src/main/java/ssej/servlet/TextServlet.java`

```java
package ssej.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/text")
@SuppressWarnings("serial")
public class TextServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/plain");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println("Hello World.");
  }
}
```

### 3.2. 静的コンテンツ
簡単な html を作成しておきます。

`ssej/src/main/resources/public/index.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Index</title>
</head>
<body>
<p>Welcome.</p>
</body>
</html>
```


## 手順4. 確認
### 4.1. アプリの起動
作成したプロジェクトを Eclipse などにインポートして、Main クラスを Java アプリとして実行します。実行すると、Jetty のログが出力されます。

```
2017-07-17 11:13:30.552:INFO::main: Logging initialized @153ms to org.eclipse.jetty.util.log.StdErrLog
2017-07-17 11:13:30.677:INFO:oejs.Server:main: jetty-9.4.6.v20170531
・・・省略・・・
2017-07-17 11:13:30.934:INFO:oejs.Server:main: Started @540ms
```

### 4.2. 確認
ブラウザで、サーブレットと静的コンテンツの確認をします。

- `http://localhost:8080/text` を開くと、文字列 `Hello World.` が表示されます。
- `http://localhost:8080/index.html` を開くと、文字列 `Welcome.` が表示されます。


## コード
今回のコードは GitHub にも置いています。

[ssej - Github](https://github.com/mamorum/blog/tree/master/code/servlet/ssej)
