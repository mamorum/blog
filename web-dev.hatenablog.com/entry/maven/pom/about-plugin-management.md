---
Title: Maven：pluginManagementについて
Category:
- Maven
Date: 2016-11-11T12:30:55+09:00
URL: http://web-dev.hatenablog.com/entry/maven/pom/about-plugin-management
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687193892110
---

POM（XML）の 要素 `pluginManagement` について、調べたことをまとめていこうと思います。


## 用途（利用ケース）
子POMに継承させたい plugin がある場合、親POM の `pluginManagement` に該当の plugin を書いていくみたいです。


## 使用例
親POM で、次のように書いていきます。

```
...
  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-antrun-plugin</artifactId>
          <version>1.1</version>
...
```


## 注意事項
親POMだと `pluginManagement` に書いた plugin を利用できないみたいです。親POMで使いたい場合は、いつも通り（`pluginManagement` なしで）書く必要があります。

```
...
 <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-antrun-plugin</artifactId>
        <version>1.1</version>
...
```

## 参考文献
- [POM Reference - Maven](https://maven.apache.org/pom.html)
- [Maven: what is pluginManagement? - stackoverflow](http://stackoverflow.com/questions/10483180/maven-what-is-pluginmanagement)


