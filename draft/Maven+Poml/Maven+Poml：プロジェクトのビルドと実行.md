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
Main クラスを実行する方法を２つ書いていきます。

### 3.1. java コマンドで実行
ビルドした jar をクラスパスに指定して実行します。

```
hello> java -cp target\hello-1.0.0.jar com.domain.Main
Hello, World.
```

### 3.2. mvn コマンドで実行
コマンド `mvn exec:java ...` で実行します。

```
hello> mvn exec:java -Dexec.mainClass="com.domain.Main"

・・・省略・・・

Hello, World.

・・・省略・・・
```

使用方法などの詳細は、記事「[Maven：Java プログラムの実行](/entry/maven/plugin/exec-java)」にも記載しています。


## 次回
Maven プロジェクトに依存性（ライブラリ）を追加する方法を書いていこうと思います。依存性を追加すると、自分の資源からライブラリのクラスなどが使えるようになります。

[]()
