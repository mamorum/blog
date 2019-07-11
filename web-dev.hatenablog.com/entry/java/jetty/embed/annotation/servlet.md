---
Title: 組込Jetty：アノテーションServletを追加
Category:
- Java
Date: 2017-10-13T08:35:25+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/annotation/servlet
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812280664316
---

組み込み Jetty（Embedded Jetty）に、アノテーション `@WebServlet` の付くサーブレットを追加する方法を書いていきます。


## 手順1. プロジェクトの作成
ルートディレクトリが `ejas`（Embedded Jetty Annotation Servlet）の Maven プロジェクトを作成します。

```
ejas/
  - pom.xml
  - src/
    - main/
      - java/
        ...
```

`pom.xml` は次のような感じになります。

`ejas/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>ejas</artifactId>
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

サーブレット関連のアノテーションを使うため、`jetty-annotations` に依存させています。


## 手順2. サーバクラスの作成
組み込み Jetty を起動するクラスを作成します。

`ejas/src/main/java/ejas/AnnotationAppServer.java`

```java
package ejas;

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

public class AnnotationAppServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    WebAppContext ctx = new WebAppContext();
    //-> アノテーション設定を有効にする
    ctx.setConfigurations(new Configuration[] {
      new AnnotationConfiguration(),
      new WebXmlConfiguration(),
      new WebInfConfiguration(),
      new FragmentConfiguration(),
      new EnvConfiguration(),
      new PlusConfiguration()
    });
    ctx.setContextPath("/");
    //-> プロジェクトのコードをコンテナのクラスパスに追加
    ctx.setExtraClasspath("./");
    //-> 静的コンテンツはクラスパスの public 配下に置く
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    svr.setHandler(ctx);
    svr.start();
    svr.join();
  }
}
```

サーブレットなどをスキャンしてもらうために、`ctx.setExtraClasspath("./");` を実行しています。


## 手順3. サーブレットの作成
アノテーション `@WebServlet` が付いたサーブレットを作成します。

`ejas/src/main/java/ejas/AnnotationAppServer.java`

```java
package ejas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/plain");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println("Hello!");
  }
}
```

`/hello` のリクエストに対してテキストを返すようにしています。


## 手順4. 動作確認
`AnnotationAppServer` クラスを Java アプリとして実行します。作成したプロジェクトを Eclipse などにインポートして実行すると楽だと思います。

実行すると、Jetty のログが出力されます。

```
2017-10-13 08:36:07.043:INFO::main: Logging initialized @133ms to org.eclipse.jetty.util.log.StdErrLog
2017-10-13 08:36:07.163:INFO:oejs.Server:main: jetty-9.4.6.v20170531
・・・省略・・・
2017-10-13 08:36:07.438:INFO:oejs.Server:main: Started @529ms
```

それからブラウザで `http://localhost:8080/hello` を開くと、文字列 `Hello!` が表示されます。


## 補足. 静的コンテンツについて
今回の例では、`AnnotationAppServer` クラスで静的コンテンツの場所を設定しています。

```java
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
```

静的コンテンツの場所を設定しないと、サーバ起動時に次のような警告が出力されました。

```
2017-10-13 08:03:55.509:WARN:oejw.WebInfConfiguration:main: Can't generate resourceBase as part of webapp tmp dir name: java.lang.IllegalStateException: No resourceBase or war set for context
2017-10-13 08:03:55.584:WARN:oejw.WebAppContext:main: Failed startup of context o.e.j.w.WebAppContext@6a5fc7f7{/,null,UNAVAILABLE}
java.lang.IllegalStateException: No resourceBase or war set for context
  at org.eclipse.jetty.webapp.WebInfConfiguration.unpack(WebInfConfiguration.java:406)
  at org.eclipse.jetty.webapp.WebInfConfiguration.preConfigure(WebInfConfiguration.java:72)
・・・
```
