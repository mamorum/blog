---
Title: Java：ジェネリックなラムダでエラー
Category:
- Java
Date: 2017-12-22T06:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/lang/illegal-lambda-expression-and-generic-method
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812327582443
Draft: true
---

関数型インターフェイス（`@FunctionalInterface`）で総称型を使うメソッドを定義して、それをラムダで表現するとエラーが発生しました。

これからそのコード例とエラーについて書いていきます。


## コード例
エラーになるコード例は以下の通りです。

```java
package lambda;

public class Main {
  // メソッドで総称型を使う関数型インターフェイス
  @FunctionalInterface interface CreateObj {
    <T> T exec(Class<T> c) throws Exception;
  }
  // 上のメソッドの実装
  static <T> T createObj(Class<T> c) throws Exception {
    return c.getDeclaredConstructor().newInstance();
  }
  public static void main(String[] args) throws Exception {
    // ラムダはコンパイルエラー
    CreateObj c1 = (c) -> {
      return c.getDeclaredConstructor().newInstance();
    };
    // メソッド参照だとOK
    CreateObj c2 = Main::createObj;
  }
}
```

main メソッド内のラムダ利用箇所でコンパイルエラーが発生します。


## エラー内容
Eclipse でコンパイルすると、

```
Illegal lambda expression: Method exec of type Main.CreateObj is generic
```

といったエラーが表示されました。

ラムダの箇所をコメントアウトすると、

```
    // CreateObj c1 = (c) -> {
    //   return c.getDeclaredConstructor().newInstance();
    // };
```

エラーが消えます。


## 対応方法
ラムダではなく、メソッド参照を使うと良さそうです。

上のコード例だと、

```
    CreateObj c2 = Main::createObj;
```

がメソッド参照を使ってます。

メソッド参照だとコンパイルエラーを回避できます。


## 参考文献
[java - Lambda Expression and generic method - Stack Overflow](https://stackoverflow.com/questions/22588518/lambda-expression-and-generic-method)
