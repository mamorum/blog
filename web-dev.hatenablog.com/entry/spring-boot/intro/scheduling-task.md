---
Title: SpringBoot入門：タスクのスケジューリング
Category:
- SpringBoot
Date: 2017-02-19T17:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/scheduling-task
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179109518
---

Spring Boot のスケジューリング機能を使って、一定間隔で処理を実行する方法を書きます。


## 前提
この記事は、入門記事「[JSONを返す](/entry/spring-boot/intro/response-json)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. タスクの作成・有効化
記事「[JSONを返す](/entry/spring-boot/intro/response-json)」で作成した、アプリ起動クラスにメソッド（タスク）を追加します。それから、`@EnableScheduling` と `@Scheduled` を使って有効化します。

`gssb/src/main/java/gssb/App.java`

```java
package gssb;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class App {

  private static final SimpleDateFormat
    fmt = new SimpleDateFormat("HH:mm:ss");
  
  // 5秒ごとに実行されるメソッド。
  @Scheduled(fixedRate = 5000)
  public void reportTime() {
    System.out.println(fmt.format(new Date()));
  }
  
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
```


## 手順2. 起動・確認
次のコマンドでアプリを起動します。

```txt
gssb > gradle bootRun
（省略）
・・・Started Application in 4.525 seconds (JVM running for 5.188)
17:22:41
17:22:46
17:22:51
（省略）
```

５秒ごとに時刻が表示されます。


## 補足
`@Scheduled(cron="・・・")` を使うと、cron のようなスケジューリングができるようです。


## ソースコード
[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
