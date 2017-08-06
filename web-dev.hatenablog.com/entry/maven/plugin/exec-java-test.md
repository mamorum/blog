---
Title: Maven：test配下のMainクラス実行
Category:
- Maven
Date: 2017-08-06T13:30:08+09:00
URL: http://web-dev.hatenablog.com/entry/maven/plugin/exec-java-test
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812286111549
---

Maven プロジェクトで、`src/test/java` 配下のプログラム（main メソッドを持つクラス）を実行する方法を書いていきます。プログラムの実行には、[Exec Maven Plugin](http://www.mojohaus.org/exec-maven-plugin/index.html) を使います。


## 1. 実行コマンド
コマンドの例は以下の通りです。

```
$ mvn exec:java -Dexec.mainClass=demo.jetty.Main -Dexec.classpathScope=test
```

`-Dexec.classpathScope=test` を付けると `src/test/java` のクラスも認識してくれます。


## 2. コンパイルについて
Exec プラグインはコンパイルをしないため、必要に応じて `test-compile` をすると良さそうです。

```
$ mvn test-compile
```


## 3. pom.xml について
特にプラグインなどを追加しなくても実行できます。


## 補足：関連記事
[Maven：Java プログラムの実行](/entry/maven/plugin/exec-java)
