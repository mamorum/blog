---
Title: Guava：ファイルを再帰的に取得する
Category:
- Java
Date: 2016-08-20T17:55:33+09:00
URL: http://web-dev.hatenablog.com/entry/java/google/guava-file-tree
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179997344
---

Java を使ってディレクトリ内のファイルを再帰的に取得したいことがありました。そのとき [Google Guava](https://github.com/google/guava) を使ったら、簡単に取得することができました。

今回はそのときのメモを書いていこうと思います。


## 1. Guava のインストール
Maven や Gradle の依存性追加方法は、次のリンク先に書いてありました。

[Google Guava - GitHub](https://github.com/google/guava) 


## 2. サンプルコード
次のように書くと、ディレクトリ内の資源（ディレクトリ・ファイル）が再帰的に取得できます。

```java
import com.google.common.io.Files;

// 省略

FluentIterable<File> dirFiles = 
    Files.fileTreeTraverser().breadthFirstTraversal(
      new File("{ディレクトリのパス}")
    );
```

変数 `dirFiles` には、ディレクトリとファイルが混在しています。


## 3. 補足
ファイルだけ取得したかったので、変数 `dirFiles` の要素を次のように選別しました。

```java
ArrayList<File> files = new ArrayList<>();
for (File f : dirFiles) {
    if (f.isFile()) files.add(f);
}
```
