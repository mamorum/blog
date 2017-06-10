---
Title: Java：ラムダは遅い？
Category:
- Java
Date: 2017-01-12T16:16:36+09:00
URL: http://web-dev.hatenablog.com/entry/java/lang/lambda-performance
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687206023700
---

Java 8 のラムダを使ってみたら、数十ミリ秒単位で処理が遅くなることがありました。そこで、ちょっとパフォーマンスを計測してみることにしました。


## 環境
- CPU: Intel Core i5-2430M 2.40GHz
- メモリ: 8GB
- OS: Win 7
- Java: SE 1.8.0_71


## 計測プログラム
ラムダを使うクラス（`LambdaMain.java`）と、使わないクラス（`Main.java`）を用意しました。

`LambdaMain.java`

```java
import java.util.ArrayList;

public class LambdaMain {
  public static void main(String[] args) {
    // 準備
    ArrayList<Integer> dst = new ArrayList<>();
    ArrayList<Integer> src = new ArrayList<>();
    for (int i=0; i<10; i++) src.add(i);

    // 計測
    StopWatch.start();
    src.forEach((e) -> {
      dst.add(e * e);
    });
    StopWatch.stop();
    StopWatch.show();
  }
}

```

`Main.java`

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // 準備
    ArrayList<Integer> dst = new ArrayList<>();
    ArrayList<Integer> src = new ArrayList<>();
    for (int i=0; i<10; i++) src.add(i);

    // 計測
    StopWatch.start();
    for (Integer e: src) {
      dst.add(e * e);
    };
    StopWatch.stop();
    StopWatch.show();
  }
}

```

### 処理内容
どちらも、リスト（変数：`src`）に１０個の数を用意して、その２乗を別のリスト（変数：`dst`）に詰め込んでいます。


### 共通クラス
計測と結果の表示は、以下の `StopWatch.java` に実装しています。

`StopWatch.java`

```java
import java.lang.management.ManagementFactory;

public class StopWatch {
  public static long start, end;

  public static void start() {
    start = System.currentTimeMillis();
  }
  public static void stop() {
    end = System.currentTimeMillis();
  }
  public static void show() {
    System.out.print("Adding time: ");
    System.out.print(end - start);
    System.out.println("ms.");
    
    System.out.print("JVM Uptime: ");
    System.out.print(
      ManagementFactory
        .getRuntimeMXBean().getUptime()
    );
    System.out.println("ms.");
  }
}
```

ループ（for each）処理時間（`Adding time`）と、JVM稼働時間（`JVM Uptime`）を表示できるように実装してます。


## 計測結果
- 計測結果の時間単位はミリ秒（ms）です。
- 各プログラムは、事前に１回実行したあとで３回計測しています。

### ラムダあり
`LambdaMain.java` の実行結果は次の通りでした。

|                        | 1回目 | 2回目 | 3回目 |
| ----------------- | ------ | ------ | ------ |
| ループ処理時間   | 67     | 60     | 59     | 
| JVM稼働時間      | 212   | 178   | 179    | 


```
>java LambdaMain
Adding time: 67ms.
JVM Uptime: 212ms.

>java LambdaMain
Adding time: 60ms.
JVM Uptime: 178ms.

>java LambdaMain
Adding time: 59ms.
JVM Uptime: 179ms.
```

### ラムダなし
`Main.java` の実行結果は次の通りでした。

|                        | 1回目 | 2回目 | 3回目 |
| ----------------- | ------ | ------ | ------ |
| ループ処理時間   | 0       | 0       | 1      |
| JVM稼働時間      | 123   | 109    | 113   |

```
>java Main
Adding time: 0ms.
JVM Uptime: 123ms.

>java Main
Adding time: 0ms.
JVM Uptime: 109ms.

>java Main
Adding time: 1ms.
JVM Uptime: 113ms.
```


## まとめ
ラムダを使用しないほうが速かったです。計測結果の平均値は以下の通りです。

- ラムダなし：処理62ms、稼働190ms
- ラムダあり：処理0.3ms、稼働115ms

現時点では、無理にラムダを使う必要はないかなと思いました。今回のように、可読性やステップ数が変わらない場合などは、ラムダのメリットはあまりない気がします。


## 補足
処理（ループ）を１万回にしても、そんなに処理時間や稼働時間は変わりませんでした。「forEach メソッド」と「for each 文」の差はそんなになくて、ラムダの有無で数十ミリ秒変わる感じなのかなと思います。

ラムダ使用時は、内部で `Function<T,R>` やら `Consumer<T>` のインスタンスを生成しているのでしょうか。そのあたりで時間くっているのかもしれません。オブジェクトが増えるのはちょっと嫌な感じがします。
