---
Title: Maven：Java プログラムの実行
Category:
- Maven
Date: 2017-08-05T09:50:26+09:00
URL: http://web-dev.hatenablog.com/entry/maven/plugin/exec-java
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687236690515
---

Maven プロジェクトの Java プログラム（main メソッドを持つクラス）を、[Exec Maven Plugin](http://www.mojohaus.org/exec-maven-plugin/index.html) で実行する方法を書いていきます。

今回は `pom.xml` にプラグインを定義せず、コマンドラインからクラス名や引数などを渡して実行してみます。


## 1. 実行コマンド
プロジェクトのルートディレクトリで、次のコマンドを実行します。

```
> mvn exec:java -Dexec.mainClass="execplg.Main" -Dexec.args="argument1 argument2"
```

この場合、`execplg.Main` クラスが実行されます。引数は `argument1` と `argument2` になります。


## 2. コンパイルについて
Exec プラグイン（`exec:java`）はコンパイルをしないため、必要に応じてアプリ実行前に `compile` すると良さそうです。

```
> mvn compile
```

## 3. ゴールについて
今回は `exec:java` を使いましたが、`exec:exec` というゴールもあるみたいです。大きな違いは次のとおりです。

__exec:java__  
Maven と同じ VM で、引数の Main クラスを実行

__exec:exec__  
Maven とは違う VM で、引数の Main クラスを実行


## 補足：サンプル資源について
今回のコマンドで実行した（プロジェクトの）資源を以下に書いていきます。ルートディレクトリは `execplg` としています。

### 1. pom.xml
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


### 2. Main クラス
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

実行すると、コマンドライン引数を出力します。
