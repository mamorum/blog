---
Title: Java：ラムダの中の例外
Category:
- Java
Date: 2017-04-04T15:23:26+09:00
URL: http://web-dev.hatenablog.com/entry/java/lang/lambda-exception
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687234500143
---

Java のラムダの中で、Exception をスローするとコンパイルエラーになることがありました。そこで、うまくラムダ内でも検査例外をスローできないか調べてみました。


## エラーになるコード例
次のようなコードだと、main メソッドで throws 宣言していますが、コンパイルエラーになります。

```java
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) throws Exception {
    Consumer<String> c = (msg) -> {
      throw new Exception(msg);  // > NG
      // throw new RuntimeException(msg); // > OK
    };
  }
}
```

```
> javac Main.java
Main.java:6: エラー: 例外Exceptionは報告されません。スローするには、捕捉または宣言する必要があります
      throw new Exception(msg);  // > NG
      ^
エラー1個
```

※ RuntimeException（非検査）だとエラーになりません。


## エラーにならないコード例
自前の関数型インターフェイス `@FunctionalInterface` を用意して、その accept メソッドで throws 宣言します。

```java
public class Main {  
  @FunctionalInterface static interface Func {
    void accept(String msg) throws Exception;
  }
  public static void main(String[] args) throws Exception {
    Func f = (msg) -> {
      throw new Exception(msg);  // > OK
    };
    f.accept("throw Exception");
  }
}
```

そうするとコンパイルエラーになりませんでした。

```
> javac Main.java
> java Main
Exception in thread "main" java.lang.Exception: throw Exception
        at Main.lambda$main$0(Main.java:7)
        at Main.main(Main.java:9)
```


## 参考文献
[Why can't I throw an exception in a Java 8 lambda expression - stack overflow](http://stackoverflow.com/questions/37726874/why-cant-i-throw-an-exception-in-a-java-8-lambda-expression)
