---
Title: ServletContextListener：起動時の処理追加
Category:
- Java
Date: 2017-08-18T09:24:28+09:00
URL: https://web-dev.hatenablog.com/entry/java/servlet/listener/servlet-context
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812289754032
---

`ServletContextListener` を使って、サーブレットアプリの起動時（初期化時）に処理を追加する方法をまとめてみました。


## 前提
記事内のコードを実行するには、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. リスナーの作成
`ServletContextListener` を実装するリスナーを作成します。

`ssjp/src/main/java/ssjp/listener/ContextListener.java`

```java
package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
  @Override public void contextInitialized(ServletContextEvent sce) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Context initialized [path=");
    System.out.print(path(sce.getServletContext()));
    System.out.println("]");
  }
  @Override public void contextDestroyed(ServletContextEvent sce) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Context destroyed [path=");
    System.out.print(path(sce.getServletContext()));
    System.out.println("]");
  }
  private String path(ServletContext sc) {
    String path = sc.getContextPath();
    if (path == null | "".equals(path)) return "/";
    else return path;
  }
}
```

`@WebListener` を付けて、サーバーに見つけてもらうようにしています。


## 手順2. 確認
Jetty Plugin を使って確認してみました。起動時と停止時にログ（System.out...）が出力されました。

### 2.1. 起動時
```
ssjp> mvn jetty:run
[INFO] Scanning for projects...
・・・省略・・・
2017-08-18T08:49:09.386 Context initialized [path=/]
```

### 2.2. 停止時（Ctrl + C）
```
[INFO] Stopped ServerConnector@20ab3e3a{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[INFO] Stopped scavenging
2017-08-18T09:10:19.673 Context destroyed [path=/]
・・・省略・・・
```


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
