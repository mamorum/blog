---
Title: Gradle：Javaアプリのビルド
Category:
- etc
Date: 2016-05-14T12:35:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gradle/build-java-app
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179307752
---

Gradle で Java アプリ（Java プロジェクト）をビルドする手順を書いていきます。今回は、コンパイル・テスト実行・Jar 作成などのタスクを実行してみます。


## 手順1. ビルドスクリプトの作成
ディレクトリ（例：`gsg`）を作って、その中に Java プロジェクトのビルドスクリプトを作成します。

`gsg/build.gradle`

```gradle
apply plugin: 'java'		// Java プロジェクトに付ける。
compileJava.options.encoding = 'UTF-8'

sourceCompatibility = 1.8
targetCompatibility = 1.8

jar {
    baseName = 'gsg'
    version = '0.0.1'
}

// provided スコープを作成。
// コンパイルの時だけ使う依存性は provided で定義する。
configurations {
    provided
}
sourceSets {
    main.compileClasspath += configurations.provided
    test.compileClasspath += configurations.provided
}

// Maven リポジトリを使って依存性を解決する。
repositories {
    mavenCentral()
}

// 依存性の定義。
dependencies {
    provided 'org.projectlombok:lombok:1.16.6'
    testCompile 'junit:junit:4.12'
    testCompile 'org.assertj:assertj-core:3.2.0'
}
```

Lombok, JUnit, AssertJ を使えるようにしています。


## 手順2. ディレクトリの作成
プロジェクトを構成するディレクトリを次のように作成します。括弧内の記述は、ディレクトリの用途を示しています。

```txt
gsg
└─src
    ├─main
    │  ├─java（プロダクトコード用）
    │  │   └─gsg（パッケージ）
    │  └─resources（リソースファイル用）
    └─test
        ├─java（テストコード用）
        │   └─gsg（パッケージ）
        └─resources（テストのリソースファイル用）
```


## 手順3. プロダクトコードの作成
Lombok を使う簡単なコードを作成します。

`gsg/src/main/java/gsg/Person.java`

```java
package gsg;

import lombok.Data;

@Data
public class Person {
	String name;
}
```


## 手順4. テストコードの作成
JUnit, AssertJ を使うテストコードを作成します。

`gsg/src/test/java/gsg/PersonTest.java`

```java
package gsg;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class PersonTest {

	@Test public void test() {
		Person p = new Person();
		p.setName("Jhon");
		assertThat(p.getName()).isEqualTo("Jhon");
	}
}
```


## 手順5. プロジェクトのビルド 
 次のコマンドで、プロジェクトをフルビルドします。

```txt
gsg> gradle build
:compileJava
:processResources UP-TO-DATE
:classes
:jar
:assemble
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test
:check
:build

BUILD SUCCESSFUL

Total time: 8.005 secs
```

ビルドスクリプトに `apply plugin: 'java'` を付けると、コンパイル、リソースのコピー、Jar 作成、テストなどのタスクが実行されます。成果物も次の場所に出力されています。

- テストレポート：`gsg/build/reports/tests/index.html`、等
- Jar：`gsg/build/libs/gsg-0.0.1.jar`

