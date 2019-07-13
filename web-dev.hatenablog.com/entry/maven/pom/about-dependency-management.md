---
Title: Maven：dependencyManagementについて
Category:
- Java
Date: 2016-11-14T18:41:15+09:00
URL: https://web-dev.hatenablog.com/entry/maven/pom/about-dependency-management
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687194352950
---

POM（XML）の 要素 `dependencyManagement` について、調べたことをまとめていこうと思います。


## 用途（利用ケース）
親POM の `dependencyManagement` に依存性を書くと、子POMに継承させることができるようです。


## 使用例
親POM で、次のように書いていきます。

`親POM`

```
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
```

ただ、親POM だけだとダメで、子POM にも同じ dependency を書くみたいです。

`子POM`

```
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>
```

`groupId` や `artifactId` は必要で、`version` は省略できるみたいです。実質的に継承できているのは、依存性のバージョンだけなのかもしれません。


## 参考文献
[POM Reference - Maven](https://maven.apache.org/pom.html)
