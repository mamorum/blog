---
Title: Maven：warの作成
Category:
- Maven
Date: 2017-08-04T08:22:23+09:00
URL: http://web-dev.hatenablog.com/entry/maven/plugin/war
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812285519348
---

Maven の [War Plugin](http://maven.apache.org/plugins/maven-war-plugin/) を使って、war を作成する方法を書いていきます。


## 1. pom.xml の作成
`pom.xml` を作成して、`packaging` タグの値を `war` にします。

```
  <groupId>com.github.mamorum</groupId>
  <artifactId>kaze-sample-war</artifactId>
  <version>0.2.3</version>
  <packaging>war</packaging>
```

`war` にすると War Plugin でパッケージングしてくれます。


## 2. ディレクトリ構成について
Java コードとリソースファイルはいつものディレクトリに置きます。War 資源（HTML, CSS, JS, テンプレート, etc）は `src/main/webapp` 配下に置きます。

```
kaze-sample-war/
  - pom.xml
  - src/
    - main/
      - java/.../MainServlet.java
      - webapp/
        - WEB-INF/...
        - index.html
      ...
```

## 3. パッケージング
次のコマンドで war が作成されます。

```
mvn package
```

war の中身はこんな感じです。

```
war/
  - WEB-INF/
    - classes/.../MainServlet.java
    - lib/...
    ...
  - index.html
  ...
```

`src/main/java` と `src/main/resources` の資源は `WEB-INF/classes` 配下に配置されます。`src/main/webapp` の資源は war 直下に配置されます。


## 補足1. War Plugin と web.xml
`web.xml` を使わない場合、War Plugin は 3.1.0 以降を使うと良さそうです。

```
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.1.0</version>
      </plugin>
      ...
```

それ以前のバージョン（デフォルト設定）は、`web.xml` がないとビルドでエラーが発生します。


## 補足2. War の名前について
名前を変えたい場合、`build/finalName` タグを使います。

```
  <build>
    <finalName>kaze-sample</finalName>
    ...
```

上の場合だと、`kaze-sample.war` という名前で作成されます。


## 補足3. 依存性について
pom.xml の `dependencies` に追加した依存性は、パッケージングで war の `WEB-INF/lib` に配置されます。

war に含めたくないもの（例：Servlet API）は、`provided` スコープを利用すると便利そうでした。

```
  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    ...
```
