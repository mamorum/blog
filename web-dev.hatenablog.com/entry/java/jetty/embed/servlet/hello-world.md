---
Title: 組込Jetty：ServletでHelloWorld
Category:
- Java
Date: 2017-10-07T15:49:36+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/servlet/hello-world
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812305687245
---

組み込み Jetty（Embedded Jetty）にサーブレットを追加して、Hello World を表示させる方法を書いていきます。


## 手順1. プロジェクトの作成
ルートディレクトリ名を `ejs`（Embedded Jetty Servlet）とする、Maven プロジェクトを作成します。

```
ejs/
  - pom.xml
  - src/
    - main/
      - java/
        ...
```

サーブレットなどの Javaコードは、`src/main/java` ディレクトリに置きます。


## 手順2. pom.xml の作成
`jetty-servlet` に依存する `pom.xml` を作成します。

`ejs/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>ejs</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-servlet</artifactId>
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


## 手順3. サーブレットの作成
HTML で Hello World を返すサーブレットを作成します。

`ejs/src/main/java/ejs/HelloServlet.java`

```java
package ejs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body><p>Hello World.</p></body></html>"
    );
  }
}
```

## 手順4. サーバ起動クラスの作成
組込 Jetty にサーブレットを追加して、 コンテナを起動するクラスを作成します。

`ejs/src/main/java/ejs/AppServer.java`

```java
package ejs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class AppServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    ctx.addServlet(HelloServlet.class, "/hello");
    svr.start();
    svr.join();
  }
}
```

`HelloServlet` が `/hello` のリクエストを処理するようにしています。


## 手順5. 動作確認
AppServer クラスを実行してコンテナを起動します（Eclipse などの IDE で 実行すると楽だと思います）。

それから `http://localhost:8080/hello` を開くと、Hello World. が表示されます。
