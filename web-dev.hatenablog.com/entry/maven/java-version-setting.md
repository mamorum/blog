---
Title: Maven：コンパイラのバージョン設定
Category:
- Maven
Date: 2017-03-16T13:20:31+09:00
URL: http://web-dev.hatenablog.com/entry/maven/java-version-setting
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687227480771
---

Maven の pom.xml で、コンパイラのバージョン（javac の -source と -target）を設定する方法を書いていきます。


## 設定方法
次のように、pom.xml の プロパティで設定するのが良さそうでした。

```txt
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

## 理由
プロパティで設定すると、プラグインのエンコーディング設定を省略できるからです。


```txt
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.5.1</version>
  <configuration>
    <source>1.8</source>
    <target>1.8</target>
  </configuration>
</plugin>
```

デフォルトだと、`maven-compiler-plugin` プラグインの設定値は次の値になるみたいです。

- 設定値 `source`： プロパティ `maven.compiler.source` の値
- 設定値 `target`： プロパティ `maven.compiler.target` の値


## 参考文献
- [Setting the -source and -target of the Java Compiler – Apache Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html)
- [Optional Parameters - Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/compile-mojo.html)
