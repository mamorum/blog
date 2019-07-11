---
Title: JDK：コンパイルと実行
Category:
- Java
Date: 2016-01-26T14:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/compile-exec
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178883877
---

JDK でプログラムをコンパイルして実行してみます。まずは、対象となるプログラムを準備します。


## 手順1. プログラムの作成
次のコードを、`HelloWorld.java` というファイル名で保存します。

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
```

## 手順2. コンパイル
コマンドプロンプトを開いて、プログラムを保存した場所に移動しておきます。それから、次のコマンドを実行します。

```txt
> javac HelloWorld.java
```

実行すると Java バイトコード `HelloWorld.class` が生成されます。


## 手順3. 実行
次のコマンドで実行します。拡張子 `.class` は入力しません。

```txt
> java HelloWorld
Hello World
```

上の文字列が出力されれば成功です。
