---
Title: Maven：エンコーディング設定
Category:
- Maven
Date: 2017-03-16T09:25:08+09:00
URL: http://web-dev.hatenablog.com/entry/maven/encoding-setting
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687185213865
---

Maven の pom.xml で、ソースやレポート出力のエンコーディングを設定したいときがあります。設定方法はいくつかありますが、良さそうな設定方法を調査してみました。


## 設定方法
次のように、pom.xml の プロパティで設定するのが良さそうでした。

```txt
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>
```

## 理由
プロパティで設定をしておけば、プラグインのエンコーディング設定（下のような設定）を省略できるからです。


```txt
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-resources-plugin</artifactId>
  <version>3.0.2</version>
  <configuration>
    <encoding>UTF-8</encoding>
  </configuration>
</plugin>
```

`maven-resources-plugin`, `maven-compiler-plugin` などのプラグインは、プロパティのエンコーディング設定を参照するみたいです。


## 補足
エンコーディング設定をしていないと、Maven 実行時に次のような警告が出てきたりします。

```txt
・・・
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ poml
---
[WARNING] Using platform encoding (MS932 actually) to copy filtered resources, i.e. build is platform dependent!
・・・
```


## 参考文献
- [Specifying a character encoding scheme - Maven Resources Plugin](https://maven.apache.org/plugins/maven-resources-plugin/examples/encoding.html)
- [Optional Parameters - Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/compile-mojo.html)
