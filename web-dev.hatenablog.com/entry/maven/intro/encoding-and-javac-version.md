---
Title: Maven入門：2.エンコーディングとコンパイラの設定
Category:
- Java
Date: 2017-06-27T09:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/maven/intro/encoding-and-javac-version
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812274143648
---

前回の記事「[1.プロジェクトの作成と実行](/entry/maven/intro/create-prj-and-exec)」で作成した `pom.xml` を編集して、エンコーディングとコンパイラのバージョンを設定していきます。

## 補足
前回の `mvn package` コマンドを実行すると、以下のような警告が出ていました（Win環境）。

```
・・・
[WARNING] Using platform encoding (MS932 actually) to copy filtered resources, i.e. build is platform dependent!
・・・
[WARNING] File encoding has not been set, using platform encoding MS932, i.e. build is platform dependent!
・・・
```

今回の設定をすると、警告が消えるようになります。


## 1. 変更前の pom.xml
自分の環境だと、次の `pom.xml` が生成されていました。

`my-app/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.mycompany.app</groupId>
  <artifactId>my-app</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>my-app</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```


## 2. 変更後の pom.xml
`pom.xml` を編集して、次の内容で保存します。

`my-app/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycompany.app</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <dependencies>
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

### 主な変更内容
`properties` を追加して、エンコーディングを `UTF-8`、とコンパイラのバージョンを `1.8` に設定しています。詳細は以下の通りです。

- project.build.sourceEncoding: ソース・プロパティファイル等のエンコーディング設定
- project.reporting.outputEncoding: レポート等の出力資源のエンコーディング設定
- maven.compiler.source: `javac` コマンドの -source 設定
- maven.compiler.target: `javac` コマンドの -target 設定

### その他の変更内容
- 空白行追加
- 新しい junit バージョンに変更
- `name`, `url` タグの削除（今は不要）


## 3. package コマンドの実行
警告が出ないことを、以下のコマンドで確認してみます。

```
> mvn clean package
```

念のため、前回の資源を clean で削除しています。
