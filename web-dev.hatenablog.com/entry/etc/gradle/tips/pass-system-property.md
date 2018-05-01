---
Title: Gradle：Java 実行時にシステムプロパティを渡す
Category:
- etc
Date: 2016-08-23T16:54:06+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gradle/tips/pass-system-property
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687180471314
---

Gradle の `run` タスクを使うと、Java の Main クラスを実行できます。以前、`run` タスクでシステムプロパティを渡す方法を調査することがありました。今回は、その方法をまとめていこうと思います。


## build.gradle を編集
次のサンプルのように、`tasks.with・・・` ブロックを追加します。

```txt
apply plugin: 'application'
 
mainClassName = 'sample.Main'

// ... 省略

// 追加
tasks.withType(JavaExec) {
  systemProperties System.properties
}
```

## アプリケーションを起動
次の例のように、gradle コマンドにプロパティ（`-Dkey=value`）を付けて起動します。

```txt
> gradle -Dport=8080 run
```

これで、Java アプリは渡されたプロパティを取得できます。


## 参考文献
[Gradle Goodness: Pass Java System Properties To Java Tasks](http://mrhaki.blogspot.jp/2015/09/gradle-goodness-pass-java-system.html)
