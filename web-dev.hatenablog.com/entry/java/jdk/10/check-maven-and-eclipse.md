---
Title: Java10, JDK10 の動作確認
Category:
- Java
Date: 2018-03-27T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/10/check-maven-and-eclipse
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971628255753
---

Oracle の Java10（JDK10）をインストールしたので、簡単に動作確認してみました。これからその内容についてまとめていこうと思います。


## 環境
- Windows10 64bit
- Maven 3.5.2
- Eclipse Oxygen.2


## Maven
プロパティで Java10 を指定して、コンパイルとパッケージング（jar作成）を試したら問題なかったです。

```
<properties>
  <maven.compiler.source>10</maven.compiler.source>
  <maven.compiler.target>10</maven.compiler.target>
</properties>
```

ただ、fatjar の作成で `maven-assembly-plugin` を使ってたんですが、プラグインのバージョンが `2.6`だとエラーが発生しました。

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-assembly-plugin</artifactId>
  <version>2.6</version>
  .....
```

プラグインを最新の `3.1.0` にしたらエラーは発生しなくなりました。


## Eclipse
Java10 を環境変数の `Path` に通して実行したところ、問題なく起動できました。ただ、文法とかプロジェクトのコンパイルで Java10 はサポートしてないようです。

[f:id:mamorums:20180322155833p:plain]

上の画像のように 9 までしか選べませんでした。

Maven Project も Java10 にするとエラーが発生するので、Eclipse を使うプロジェクトはまだ 10 にしないほうが良さそうでした。Eclipse の次回リリースとかで対応してくれるのかもしれません。

