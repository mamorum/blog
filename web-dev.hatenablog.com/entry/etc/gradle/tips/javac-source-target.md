---
Title: Gradle：Javaコンパイルのバージョン指定
Category:
- etc
Date: 2016-09-15T15:55:53+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gradle/tips/javac-source-target
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687184494347
---

Gradle で Java をコンパイルするときに、ソースコードのバージョンとターゲットクラスファイルのバージョンを指定する方法を書いていきます。この２つのバージョンは、javac コマンドのオプション `-source`, `-target` に対応するものです。


## 設定方法
Java プラグインを適用して、`sourceCompatibility`, `targetCompatibility` で指定します。

```txt
apply plugin: 'java'

sourceCompatibility = 1.8
targetCompatibility = 1.8
```


## 関連記事
[Gradle：Javaコンパイルのエンコーディング指定](http://web-dev.hatenablog.com/entry/gradle/tips/javac-encoding)
