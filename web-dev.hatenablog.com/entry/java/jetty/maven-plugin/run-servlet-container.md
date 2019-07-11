---
Title: Jetty Maven Plugin でコンテナ起動
Category:
- Java
Date: 2017-10-06T16:58:42+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/maven-plugin/run-servlet-container
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812305432121
---

Jetty Maven プラグインを使って、サーブレットコンテナを起動する方法を書いていきます。また、動作確認のために簡単なサーブレットと静的コンテンツを作成してみます。


## 手順1. サーブレットコンテナの起動
### 1.1. プロジェクトの作成
プロジェクトのディレクトリ階層を作成します。ルートディレクトリは `jmps`（Jetty Maven Plugin Sample）としています。

```
jmps/
  - pom.xml
  - src/
    - main/
      - java/
      - webapp/
        - WEB-INF/
        ...
```

ディレクトリの大まかな役割は以下の通りです。

- `src/main/java`: Javaコードなど（servlet, filter, etc）を配置
- `src/main/webapp`: 静的コンテンツなど（html, js, css, etc）を配置
- `src/main/webapp/WEB-INF`: web.xml などを配置


### 1.2. pom.xml の作成
`jetty-maven-plugin` を使う `pom.xml` を作成します。

`jmps/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>jmps</artifactId>
  <version>1.0.0</version>
  <packaging>war</packaging>

  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <build>
    <finalName>${project.artifactId}</finalName>
    <plugins>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.1.0</version>
      </plugin>
      <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.4.6.v20170531</version>
      </plugin>
    </plugins>
  </build>
</project>
```

`packaging` は `war` にしています。また、`web.xml` なしで動くように `maven-war-plugin` を `3.1.0` に指定しています。


### 1.3. 起動
これで、`mvn` コマンドを使って Jetty（サーブレットコンテナ）を起動することができます。

```
jmps>mvn jetty:run
```


## 手順2. 動作確認
### 2.1. サーブレットの作成
HTML を返すクラスを作成します。

`jmps/src/main/java/jmps/HelloServlet.java`

```java
package jmps;

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
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body><p>Hello!</p></body></html>"
    );
  }
}
```

`@WebServlet` を使って、`/hello` のリクエストを処理するようにしています。


### 2.2. 静的コンテンツの作成
簡単な HTMLファイルを作成します。

`jmps/src/main/webapp/index.html`

```
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"></head>
<body><p>Index Html</p></body>
</html>
```


### 2.3. 確認
コンテナを起動して、

```
jmps>mvn jetty:run
```

ブラウザ等で以下の URL を開きます。

- `http://localhost:8080/hello`（サーブレット）
- `http://localhost:8080/index.html`（静的コンテンツ）

問題なければ HTML が返ってきます。
