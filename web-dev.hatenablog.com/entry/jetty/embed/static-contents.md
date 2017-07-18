---
Title: 組込Jetty：静的コンテンツを返す
Category:
- Java
Date: 2017-07-13T07:31:40+09:00
URL: http://web-dev.hatenablog.com/entry/jetty/embed/static-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812279164171
---

Embedded Jetty（組み込み Jetty）で、Http リクエストに対して静的コンテンツを返す例を書いていきます。


## 手順1. pom.xml の作成
`jetty-server` を使う Maven プロジェクトとして作成します。

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.domain</groupId>
  <artifactId>sandbox-jetty</artifactId>
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


## 手順2. Main クラスの作成
`main` メソッドを持つ Javaクラスを作成します。

```java
package file;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class Main {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ResourceHandler rhand = new ResourceHandler();
    rhand.setDirectoriesListed(false);
    rhand.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    HandlerList hands = new HandlerList();
    hands.setHandlers(new Handler[] {
      rhand  //, new DefaultHandler()
    });
    svr.setHandler(hands);
    svr.start();
    svr.join();
  }
}
```

クラスパス `public` 配下のファイルを返すように設定しています。コメントアウトしている `DefaultHandler` は、Jetty の `favicon.ico` を返したりするみたいです。


## 手順3. 実行
Eclipse などの IDE で Main クラスを実行します。


## 補足. 静的コンテンツの場所指定
今回はクラスパス（`/public`）で指定しましたが、ファイルパスで指定することもできます。


```
    rhand.setBaseResource(
      Resource.newClassPathResource("/public")
    );
```

のところを、

```
    rhand.setResourceBase(
      "C:\\..."
    );
```

のように指定します。


## 参考文献
[Embedding Jetty - Jetty](http://www.eclipse.org/jetty/documentation/9.4.6.v20170531/embedding-jetty.html)
