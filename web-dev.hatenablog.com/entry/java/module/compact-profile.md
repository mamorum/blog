---
Title: Java：コンパクト・プロファイル
Category:
- Java
Date: 2017-03-27T09:08:24+09:00
URL: http://web-dev.hatenablog.com/entry/java/module/compact-profile
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687231199989
---

Java8 で導入されたコンパクト・プロファイルについて、調べたことを書いていこうと思います。


## コンパクト・プロファイルとは？
Java SE の API のサブセット（グループみたいなもの）で、compact1, compact2, compact3 の３つがあります。compact1 が一番小さくて、java.lang, java.io などのコアな API で構成されています。compact2 は 1 を含んでいて、compact3 は 2 を含んでいます。（詳細は [こちら](https://docs.oracle.com/javase/jp/8/docs/technotes/guides/compactprofiles/)。）


## メリット（Java9 に向けて）
Java9 のモジュール・システムで、JRE の rt.jar（60MB程度）は分割される可能性が高そうです。そうなると、compact1 のように少ないモジュール（API）だけを使うプログラムは、小さいランタイムで動かすことができるようになります（rt.jar の一部だけに依存するため）。

メリットとしては、起動が早くなったり、メモリ消費を抑えられたり、といったことが考えられます。


## 使用方法
プログラムをコンパイルするときに、`-profile` オプションでプロファイルを指定するみたいです。compact1 を指定する場合は、以下のようになります。

```
> javac -profile compact1 C1.java
```

__C1.java__

```java
public class C1 {
  public static void main(String[] args) {
    System.out.println("Hello, World.");
  }
}
```


## 補足：コンパイルエラー
compact3 に含まれる  java.lang.management を使いつつ、compact1 でコンパイルすると、次のようなエラーが発生しました。

```
> javac -profile compact1 C3.java
C3.java:7: エラー: ManagementFactoryはプロファイル'compact1'で使用できません
      ManagementFactory.getRuntimeMXBean().getUptime() +
      ^
エラー1個
```

__C3.java__

```java
import java.lang.management.*;

public class C3 {
  public static void main(String[] args) {
    System.out.println(
      "JVM Uptime: " +
      ManagementFactory.getRuntimeMXBean().getUptime() +
      "ms");
  }
}
```

次のコマンドだと、正常にコンパイルできました。

```
> javac -profile compact3 C3.java
```


## 参考文献
- [コンパクト・プロファイル - Oracle](https://docs.oracle.com/javase/jp/8/docs/technotes/guides/compactprofiles/)
- [プレリリース版で学ぶJava 9モジュール](http://www.oracle.com/webfolder/technetwork/jp/javamagazine/Java-JF16-Java9Modules.pdf)
