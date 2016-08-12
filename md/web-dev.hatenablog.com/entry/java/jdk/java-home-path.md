---
Title: JDK：JAVA_HOME・Pathの設定理由
Category:
- java
Date: 2016-02-03T18:12:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/java-home-path
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178824290
---

JDK をインストールしたら、`JAVA_HOME` と `Path` といった環境変数を設定することが多いです。今回は、なぜ `JAVA_HOME` と `Path` を設定するか書いていこうと思います。


## 理由1. 他のプロダクトが参照するから
Java の開発では、Eclipse （統合開発環境）や、Gradle, Maven （ビルドシステム）といったプロダクトを使うことが多いです。

これらのプロダクトは、環境変数 `JAVA_HOME` や `Path` を参照して動きます。そのため、JDK をインストールしたついでに、環境変数を設定してしまいます。


## 理由2. JDKを簡単に実行するため
Path を設定すると、`javac`, `java` といった JDK のコマンドを簡単に実行できるようになります。

コマンドプロンプトで `javac` とだけ打って実行できるのは、コンピュータが Path に設定した場所から `javac`（`javac.exe`） を探してくれてるからです。Path は特殊な環境変数で、こういった効果があります。

```
> javac -version
javac 1.8.0_71
```

Path に設定（例：`%JAVA_HOME%\bin`）を追加しないと、毎回 `javac` の場所（例：`C:\jdk1.8.0_71\bin\javac`）を打つ必要があって面倒です。

```
> C:\jdk1.8.0_71\bin\javac -version
javac 1.8.0_71
```
