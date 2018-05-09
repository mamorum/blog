Maven プロジェクトのビルド方法と実行方法を書いていきます。記事の内容は、

1. [前回]() のプロジェクトに Javaコードを追加
2. ビルド
3. 実行

といった感じになります。

※ タイトルに「Maven+Poml」と書いてありますが、今回は Maven だけ使います。


## 1. Javaコードの追加
実行可能な Mainクラスを作成します。

`hello/src/main/java/com/domain/Main.java`

```java
package com.domain;

public class Main {
  public static void main(String[] args) {
    String msg = hello("World");
    System.out.println(msg);
  }
  static String hello(String name) {
    return (new StringBuffer()
      ).append("Hello, "
      ).append(name
      ).append("."
    ).toString();
  }
}
```

パッケージは `com.domain` で、前回作成した `src/main/java` の下に `com/domain` ディレクトリを作成しています。

```
hello/
  - src/main/java/
    - com/
      - domain/
        - Main.java
```

ディレクトリ階層は上のような感じです。


## 2. ビルド
ルートディレクトリに移動して、コマンド `mvn package` を実行します。

```
hello> mvn package
[INFO] Scanning for projects...

・・・省略・・・

[INFO] BUILD SUCCESS

・・・省略・・・
```

成功すると `hello/target/` の下に `hello-1.0.0.jar` が作成されています。この中に Mainクラスが含まれていて、java コマンドで実行できる成果物になります。


## 3. 実行

