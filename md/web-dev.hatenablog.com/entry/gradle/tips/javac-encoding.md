---
Title: Gradle：Javaコンパイルのエンコーディング指定
Category:
- Gradle
Date: 2016-09-15T15:46:02+09:00
URL: http://web-dev.hatenablog.com/entry/gradle/tips/javac-encoding
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687184491017
---

Gradle で Java をコンパイルするときに、エンコーディングを指定する方法を書いていきます。


## 設定方法
Java プラグインを適用して、`compileJava.options.encoding` で設定します。次のように書くと、UTF-8 に設定できます。

```txt
apply plugin: 'java'

compileJava.options.encoding = 'UTF-8'
```


## 参考文献
[Gradle Goodness: Set Java Compiler Encoding](http://mrhaki.blogspot.jp/2012/06/gradle-goodness-set-java-compiler.html)


## 関連記事
[Gradle：Javaコンパイルのバージョン指定](http://web-dev.hatenablog.com/entry/gradle/tips/javac-source-target)
