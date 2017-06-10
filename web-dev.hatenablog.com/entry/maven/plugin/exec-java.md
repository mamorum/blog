---
Title: Maven：Java プログラムの実行
Category:
- Maven
Date: 2017-04-13T20:50:26+09:00
URL: http://web-dev.hatenablog.com/entry/maven/plugin/exec-java
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687236690515
---

Maven プロジェクトの Java プログラム（main メソッドを持つクラス）を、[Exec Maven Plugin](http://www.mojohaus.org/exec-maven-plugin/index.html) で実行する方法を書いていきます。

今回は `pom.xml` にプラグインを定義せず、コマンドラインからクラス名や引数などを渡して実行してみます。


## 手順1. pom.xml の作成
以下のビルドファイルを作成します（今回の例では、ルートディレクトリを `execplg` としています）。

`execplg/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.github.mamorum</groupId>
  <artifactId>execplg</artifactId>
  <version>1.0.0</version>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```


## 手順2. Main クラスの作成
Maven から実行されるクラスを作成します。

`execplg/src/main/java/execplg/Main.java`

```java
package execplg;

public class Main {
  public static void main(String[] args) {
    System.out.println("Arguments:");
    System.out.print("  arg0=");
    System.out.println(args[0]);
    System.out.print("  arg1=");
    System.out.println(args[1]);
  }
}
```

処理は、コマンドライン引数を出力するだけです。


## 手順3. 実行
プロジェクトのルートディレクトリで、次のコマンドを実行します。

```
execplg > mvn compile exec:java -Dexec.mainClass="execplg.Main" -Dexec.args="argument1 argument2"
```

Exec プラグイン（`exec:java`）はコンパイルをしないため、アプリ実行前に `compile` するようにしています。事前にコンパイルできている場合は不要です。


## 手順4. 確認
実行すると、次のように結果が出力されます。

```
[INFO] Scanning for projects...
・・・省略・・・
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ execplg ---
Arguments:
  arg0=argument1
  arg1=argument2
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
・・・省略・・・
```


## 補足
今回は `exec:java` を使いましたが、`exec:exec` というゴールもあるみたいです。大きな違いは次のとおりです。

__exec:exec__  
Maven とは違う VM で、引数の Main クラスを実行

__exec:java__  
Maven と同じ VM で、引数の Main クラスを実行
