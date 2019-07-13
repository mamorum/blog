---
Title: SpringBoot：MavenでJavaバージョンを指定
Category:
- Java
Date: 2017-03-16T13:48:34+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/maven-java-version
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687227488037
---

Spring Boot を使っている場合、Maven のプロパティ `java.version` で、Java バージョンを指定することができます。

```
<properties>
  <java.version>1.8</java.version>
</properties>
```

ただ、他のアプリでも `java.version` を使いそうな気がしてきます。

そこで、Spring Boot を使っていても、下のように他のプロジェクトと同じ設定方法でも良いのかなと思ったりもしています。

```
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```


## 補足. java.version の詳細
SpringBoot の pom.xml は、`java.version` の値を `maven.compiler.source`, `maven.compiler.target` に設定しているようです。以下は、その箇所（[spring-boot-starter-parent/pom.xml](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-starters/spring-boot-starter-parent/pom.xml)）の抜粋です。

```
  <properties>
    <java.version>1.8</java.version>
    <resource.delimiter>@</resource.delimiter> <!-- delimiter that doesn't clash with Spring ${} placeholders -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>
  </properties>
```


## 関連記事
- [Maven：Java のバージョン設定](/entry/maven/java-version-setting)
- [Maven：エンコーディング設定](/entry/maven/encoding-setting)

## 参考文献
[Changing the Java version - Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-maven-java-version)
