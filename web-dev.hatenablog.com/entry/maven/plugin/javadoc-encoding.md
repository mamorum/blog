---
Title: Maven：javadocプラグインのエンコーディング
Category:
- Java
Date: 2016-10-22T20:06:46+09:00
URL: https://web-dev.hatenablog.com/entry/maven/plugin/javadoc-encoding
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687190722948
---

[Maven Javadoc Plugin](http://maven.apache.org/plugins/maven-javadoc-plugin/) の `javadoc:jar`（ゴール）を使うことがあったので、エンコーディング設定を調べてみました。


## デフォルトは UTF-8
次のように `pom.xml` で何も設定しないと、javadoc の生成に `UTF-8` が使われるようです。

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-javadoc-plugin</artifactId>
  <version>2.10.4</version>
  <executions>
    <execution>
      <id>attach-javadocs</id>
      <goals><goal>jar</goal></goals>
    </execution>
  </executions>
</plugin>
```


## charset, docencoding で設定可能
変更したい場合は、`charset` か `docencoding` タグで設定できるようです。

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-javadoc-plugin</artifactId>
  <version>2.10.4</version>
  <configuration>
    <charset>{{エンコーディング名}}</charset>
  ...
```


## 設定の詳細
タグの優先順位と、`UTF-8` になる流れは以下の通りです。

- `charset` がない場合：`doencoding` が有効になる。
- `doencoding` がない場合：デフォルトの `UTF-8` になる。


## 参考文献
[Apache Maven Javadoc Plugin - javadoc:jar](http://maven.apache.org/plugins/maven-javadoc-plugin/jar-mojo.html)

