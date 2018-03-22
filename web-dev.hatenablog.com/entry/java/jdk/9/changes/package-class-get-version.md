---
Title: Java9：Packageクラスの変更点
Category:
- Java
- Poml
Date: 2017-12-02T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/9/changes/package-class-get-version
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812321649086
---

JDK8 でコンパイルしたアプリ（[Poml](https://github.com/mamorum/poml)）を、JDK9 で動作確認してたら `Package#getImplementationVersion​()` メソッドの戻り値が異なってました。これからそのときのことを書いていきます。


## アプリの実装
アプリの内部はこんな感じでした。

- マニフェストファイルにバージョン番号を書いている。
- そのバージョン番号を `Package#getImplementationVersion​()` で取得している。

マニフェストの内容は以下の通りで、

```
Manifest-Version: 1.0
Implementation-Version: 1.1.0
Archiver-Version: Plexus Archiver
Built-By: Poml Authors
Created-By: Apache Maven 3.5.2
Build-Jdk: 1.8.0_131
Main-Class: poml.Main
```

`Implementation-Version` の値を Java コードで出力する感じです。

```
System.out.println(
  Opt.class.getPackage().getImplementationVersion()
);
```

## Java8 での実行結果
Java8 のランタイムで実行すると、マニフェストのバージョンが返ってきてました。

```
>poml -v
1.1.0
```


## Java9 での実行結果
Java9 だと `null` が返ってくるようになってました。

```
>poml -v
null
```


## 原因
Java9 の javadoc を読んでると `Package#getImplementationVersion​()` は、`package-info.class` の情報を取ってきそうでした。もうマニフェストからは取ってくれないのかもしれません。


## 参考文献
- [クラスPackage - Java SE8](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Package.html)
- [クラスPackage - Java SE9](https://docs.oracle.com/javase/jp/9/docs/api/java/lang/Package.html)
