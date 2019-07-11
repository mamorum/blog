---
Title: Java9, JDK9 の動作確認
Category:
- Java
Date: 2017-11-28T15:18:51+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/9/check-compile-build-exec
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812321843768
---

Java9（JDK9）を使って、自分の気になるところを動作確認してみました。Java8 でコンパイルしてたアプリを Java9 でコンパイルしたりしてます。


## 前提とか
- JDK 9.0.1+11 を使用
- ビルドは Maven 3.5.2 を使用（※1）
- Eclipse は Oxygen.1a を使用（※2）

※1 Maven 3.5.2 で JDK9 の [バグMNG-6148](https://maven.apache.org/docs/3.5.2/release-notes.html) が修正されてそう。  
※2 Oxygen.1a から Java9 をサポートしてそう


## 1. Java9でコンパイル、パッケージング
### 1.1. 詳細
- コンパイルの source と target で `9` を指定。
- `1.9` はやめておいたほうが良さそう（Eclipse でエラー発生）。

`pom.xml` の抜粋です。

```
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>9</maven.compiler.source>
    <maven.compiler.target>9</maven.compiler.target>
  </properties>
```

※ `maven.compiler.release`（javac の -release オプション）を使ったほうが良さそうだが、`maven-compiler-plugin` の `3.6` からサポートされるため未使用。


### 1.2. 結果
Java9 互換のAPIや予約語だけ使ってたのか、特に修正せずにコンパイルできました。jar も作成されて、`maven-assembly-plugin` による fatjar も生成されてました。


## 2. Java9でコンパイル、Java8で実行
### 2.1. 詳細
- コンパイルの source と target で 9 を指定（上と同じ）
- Java8 のランタイムで実行

### 2.2. 結果
エラーになりました。

```
Error: A JNI error has occurred, please check your installation and try again
Exception in thread "main" java.lang.UnsupportedClassVersionError: poml/Main has been compiled by a more recent version of the Java Runtime (class file version 53.0), this version of the Java Runtime only recognizes class file versions up to 52.0
        at java.lang.ClassLoader.defineClass1(Native Method)
        at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
        at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
        at java.net.URLClassLoader.defineClass(URLClassLoader.java:467)
        at java.net.URLClassLoader.access$100(URLClassLoader.java:73)
        at java.net.URLClassLoader$1.run(URLClassLoader.java:368)
        at java.net.URLClassLoader$1.run(URLClassLoader.java:362)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:361)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        at sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:495)
```


## 3. Java9でクロスコンパイル１
### 3.1. 詳細
- コンパイルの source は 9, target は 8

```
    <maven.compiler.source>9</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
```

### 3.2. 結果
Maven のビルドでエラーになりました。

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project poml: Fatal error compiling: ソース・リリース9にはターゲット・リリース1.9が必要です -> [Help 1]
```

## 4. Java9でクロスコンパイル２
### 4.1. 詳細
- コンパイルの source は 8, target は 9

```
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>9</maven.compiler.target>
```

### 4.2. 結果
- Maven のビルド成功。
- Java9 で実行可。
- Java8 で実行不可。
- Eclipse で警告あり（※1）

※1 プロジェクトのプロパティ で Java Compiler を選択すると、`Classfile compatibility must be equal or greater than source compatibility.` という警告？みたいなのが出てました。


## 5. Eclipse で Java9 と 8 を共存
### 5.1. 詳細
- Eclipse に JDK9 と 8 を追加（下の画像）
- 各プロジェクトの `pom.xml` でどちらを使うか選択

[f:id:mamorums:20171128151620p:plain]

### 5.2 結果
共存できそう。

[f:id:mamorums:20171128151636p:plain]


## 考察
早めに Java9 に移行してみようかと思いました。

- javac の -source と -target が 9 だと、Java8 で動かなさそう。
- javac の -target を 8 にできるが、Java8 はサポート切れが近づいている。
- Java8 の公式サポート予定は 2018年9月まで。（Oracle にお金払ってたり、他のベンダー JDK を使っている場合は除く。）

Java9 と 8 は共存できそうですし、ひとまずデフォルトで使う（Path に通したりする） JDK は 9 にしちゃおうかと思ってます。

※ あくまで自分個人の考えです。
