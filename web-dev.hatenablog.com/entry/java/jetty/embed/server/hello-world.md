---
Title: 組込Jetty：HelloWorldを返す
Category:
- Java
Date: 2017-10-11T15:51:30+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/server/hello-world
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812278924031
---

組み込み Jetty（Embedded Jetty）で、Http リクエストに対して Hello World を返す例を書いていきます。今回は Servlet を使わずに、Jetty の Handler を使って書いてみました。


## 手順1. プロジェクトの作成
ルートディレクトリを `ejsvr`（Embedded Jetty Server）とする、Maven プロジェクトを作成します。

```
ejsvr/
  - pom.xml
  - src/
    - main/
      - java/
        ...
```

`pom.xml` は次のような感じになります。

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>ejsvr</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-server</artifactId>
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

`jetty-server` に依存します。


## 手順2. Javaクラスの作成
Jetty の `Server` クラスにハンドラを設定して、サーバーを起動するクラスを作成します。

`ejsvr/src/main/java/ejsvr/HelloWorldServer.java`

```java
package ejsvr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorldServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    server.setHandler(new HwHandler());
    server.start();
    server.join();
  }
  static class HwHandler extends AbstractHandler {
    @Override public void handle(
      String target, Request baseRequest,
      HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html; charset=utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<h1>Hello World</h1>");
      baseRequest.setHandled(true);
    }
  }
}
```


## 手順3. 動作確認
上のクラスを実行して Jetty を起動します（Eclipse などの IDE で 実行すると楽だと思います）。

起動したら `http://localhost:8080/` にアクセスして、Hello World と表示されれば成功です。全てのURLパスに対してハンドラが実行されるので、`http://localhost:8080/hello` などでも同じ結果になります。
