Maven を使って、Javaのプロジェクト（jar）をビルドする方法を書いていきます。途中で Poml（Maven の簡略記法）の利用方法も書きますが、読み飛ばして頂いても大丈夫です。


## 前提
Maven をインストールしていることが前提になります。Maven のインストール方法などは [はじめに]() に書いてあるので、必要に応じて参照して頂けると嬉しいです。（Poml は使う場合だけ必要になります。）


## 1. プロジェクトの作成
### 1.1. ディレクトリ階層の作成
任意の場所に、以下のディレクトリ階層を作成します。

```
hello/
  - src/
    - main/
      - java/
      - resources/
    - test/
      - java/
      - resources/
```

ディレクトリの用途は以下の通りです。

- `hello`：プロジェクトのルートディレクトリ
- `main`：アプリ資源を格納
- `test`：テスト資源を格納

`main` と `test` 配下のディレクトリは、それぞれ以下の用途になります。

- `java`：Javaコードを格納
- `resources`：設定ファイルなどを格納

※ ディレクトリの構成は、Maven の [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) に準拠しています。


### 1.2. pom.xml の作成
ルートディレクトリの下に Maven の定義ファイル `pom.xml` を作成します。

`hello/pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.domain</groupId>
  <artifactId>hello</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```

以下の値は必須となっています。

- グループID：`groupId`
- アーティファクトID：`artifactId`
- バージョン：`version`

それぞれ、プロジェクト（アプリ）の識別子を設定します。グループID はドメインを逆にした文字列を指定することが多く、今回はサンプルなので適当な値 `com.domain` にしています。アーティファクトID はアプリの名前になります。バージョンの番号は、アプリを更新するたびに上げていくことが多いです。

パッケージング（`packaging`）は、デフォルト値の `jar` にしています。普通の Javaアプリやライブラリの場合は `jar` で大丈夫です。

プロパティ（`properties`）では、以下の値を設定しています。

- エンコーディング：`UTF-8`
- Java のコンパイラバージョン：`1.8`

OS や Maven に依存する値なので、設定しておいたほうが無難かと思っています。


## 2. Poml でプロジェクト作成
Poml を使う場合、`poml init` コマンドで上と同じ資源が作成できます。

### 2.1. コマンド実行
ルートディレクトリ `hello` を任意の場所に作成して、コマンドプロンプトで移動しておきます。それから `poml init` を実行して、対話モードを全て `Enter` で進めます。

```
hello> poml init
This option creates pom.poml and maven project.
Please answer some questions. (Press ^C to quit.)

groupId: (com.domain)
artifactId: (hello)
version: (1.0.0)
packaging: (jar)
encoding: (UTF-8)
javac version: (1.8)

content of pom.poml:

pkg=com.domain:hello:1.0.0:jar
properties=&encoding>UTF-8, &compiler>1.8

ok?: (yes)

[INFO] Created pom.poml
[INFO] Converting pom.poml
[INFO] Created pom.xml @9ms
[INFO] Created dirs
 src/main/java
 src/main/resources
 src/test/java
 src/test/resources
```

何も入力せずに `Enter` を押すと、`groupId` などの設定値は括弧内の値（デフォルト）になります。

これで、

- ディレクトリ階層
- pom.xml
- pom.poml

が作成されます。


### 2.2. Pomlファイルについて
`pom.poml` は Pomlの定義ファイルで、`pom.xml` に変換されます。`pom.xml` を簡略化した内容で、中身は以下の通りです。

```
pkg=com.domain:hello:1.0.0:jar
properties=&encoding>UTF-8, &compiler>1.8
```

設定が `キー=値` で表現されてます。

`pkg` はアプリのパッケージ情報で、グループIDやアーティファクトIDなどをセミコロンで区切って「`groupId:artifactId:version:packaging`」といった感じで表現します。この値（表現）は、Maven のドキュメントや Gradle のライブラリ指定でも使われています。

`properties` はプロパティの設定で、複数ある場合はカンマで区切ります。`&encoding` と `&compiler` は Poml に組込まれた設定で、下ののように変換されます。

```
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>
```

`&encoding` と `&compiler` を使うと、エンコーディングとコンパイラのバージョンを簡単に設定することができます。


## 次回
次回は、プロジェクト内に Java のプログラムを作成して、ビルド（jarの作成）と実行をしてみようと思います。

[]()
