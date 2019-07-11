---
Title: 組込Jetty：静的コンテンツを返す
Category:
- Java
Date: 2017-10-12T08:01:40+09:00
URL: https://web-dev.hatenablog.com/entry/java/jetty/embed/server/static-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812279164171
---

組み込み Jetty（Embedded Jetty）で、Http リクエストに対して静的コンテンツを返す例を書いていきます。今回は Servlet ではなく、Jetty の Handler を使ってみました。


## 前提
この記事のコードを動かすには、記事「[組込Jetty：HelloWorldを返す](/entry/jetty/embed/server/hello-world)」の資源（プロジェクトのディレクトリ構成、pom.xml）が必要になります。


## 手順1. サーバクラスの作成
Jetty の `Server` を起動するクラスを作成します。静的コンテンツは `ResourceHandler`を使って返します。

`ejsvr/src/main/java/ejsvr/FileServer.java`

```java
package ejsvr;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class FileServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ResourceHandler rhand = new ResourceHandler();
    rhand.setDirectoriesListed(false);
    rhand.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    svr.setHandler(rhand);
    svr.start();
    svr.join();
  }
}
```

静的コンテンツの配置場所は、クラスパスの `public` ディレクトリになります。


## 手順2. 静的コンテンツの作成
動作確認用の HTML を作成します。

`ejsvr/src/main/resources/public/index.html`

```
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"></head>
<body><p>Hello, from Jetty Server.</p></body>
</html>
```


## 手順3. 動作確認
手順1 で作成した `FileServer` クラスを実行して、Jetty を起動します（Eclipse などの IDE で 実行すると楽だと思います）。

起動後に `http://localhost:8080/index.html` を開くと、上の HTML の内容が表示されます。


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
