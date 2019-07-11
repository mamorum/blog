---
Title: Poml：Maven pom.xml の簡略記法
Category:
- 製品開発
Date: 2018-01-09T12:07:00+09:00
URL: https://web-dev.hatenablog.com/entry/product/poml/readme
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812335360855
---

[Poml](https://github.com/mamorum/poml) を使うと、[Maven](https://maven.apache.org/index.html) の定義ファイル `pom.xml` をテキスト形式でシンプルに書くことができます。

Poml は、以下の２つから構成されています。

1. Pomlファイル `pom.poml` を書くための構文
2. `pom.poml` を `pom.xml` に変換するツール


## リンク集
- [ダウンロード（リリースページ）](https://github.com/mamorum/poml/releases)
- [インストール方法](/entry/poml/doc/installation-guide)
- [Poml Blog](http://java-poml.blogspot.com/)


## サンプル
### 1. Poml ファイルの作成
`pom.poml` を作成して、下のテキストを保存します。

```
pkg=com.example:demo:0.0.1:jar
depend=
  org.slf4j:slf4j-api:1.7.25,
  junit:junit:4.12:test
properties=&encoding>UTF-8, &compiler>1.8
```

### 2. Poml コマンドの実行
ファイルを作成したディレクトリで、`poml` コマンドを実行します。

```
> poml
[INFO] Converting pom.poml
[INFO] Created pom.xml @30ms
```

### 3. XML の確認
以下の内容で `pom.xml` が生成されます。

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>
  <artifactId>demo</artifactId>
  <version>0.0.1</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.25</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```


## 補足
POML は、POM's Minimal Language の略称です。
