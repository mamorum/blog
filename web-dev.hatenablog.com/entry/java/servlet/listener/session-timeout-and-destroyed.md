---
Title: HttpSessionListener：実行タイミング
Category:
- Java
Date: 2017-08-17T10:51:50+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/listener/session-timeout-and-destroyed
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812289491255
---

セッションタイムアウトの時間が経過したタイミングで、`HttpSessionListener` のメソッド `#sessionDestroyed(HttpSessionEvent)` が実行されるか確認してみました。


## 結果
- セッションタイムアウトの時間が経過したタイミングでは実行されない。
- タイムアウト後、セッションに紐づくリクエストが来たら実行される。


## 動作確認サーバ
- Jetty 9.4.6.v20170531（Embedded）
- Tomcat 8.5.16（war配備）


## 動作確認コード
以下のリスナークラスを使いました。

```java
package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
  @Override public void sessionCreated(HttpSessionEvent se) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Session created ");
    System.out.println(se.getSession().getId());
  }
  @Override public void sessionDestroyed(HttpSessionEvent se) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Session destroyed ");
    System.out.println(se.getSession().getId());
  }
}
```


## 動作確認結果
リスナーのログ（`System.out...`）は、リクエストが来たら出力されました。

```
// ↓セッション作成時のリクエスト -> 実行：sessionCreated(HttpSessionEvent)
2017-08-17T20:06:10.866 Session created node01emfybtf32ru5nrjkan7vw3s90

// セッションタイムアウト時間経過 -> 実行：なし（ログもなし）

// ↓タイムアウト後のリクエスト -> 実行：sessionDestroyed(HttpSessionEvent)
2017-08-17T20:07:54.821 Session destroyed node01emfybtf32ru5nrjkan7vw3s90
```


## まとめ
タイムアウト時間が経過したら、勝手にサーバが `#sessionDestroyed(HttpSessionEvent)` を実行してくれると思い込んでました。

設定方法次第ではそうできるのかもしれませんが、ひとまず今回の調査はここまでにしてみました。


## 補足：コード・環境
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）

コードを実行する場合、動作環境（サーブレットコンテナ）が必要になります。環境がない場合、以下の記事を参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)
