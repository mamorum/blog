---
Title: 単体テスト：JUnit 入門
Category:
- Java テスト
Date: 2016-04-22T17:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/test/junit/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179058059
---

Java の単体テストで、JUnit を使う方法を書いていきます。JUnit は、単体テストを実行するためのフレームワークです。


## 手順1. テストクラスの作成
単体テストは、Java のプログラムとして書いていきます。プログラムなので、繰り返し自動でテストすることが容易です。

`gsjt/src/test/java/gsjt/JunitTest.java`

```java
package gsjt;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class JunitTest {

	// @Test で JUnit のテストケースになる。
	@Test public void test() {
		
		// 準備（≒ given）
		int a = 1;
		
		// 実行（≒ when）
		int result = a + a;
		
		// 検証（≒ then）
		// 結果 result が、期待値 2 と等しいこと。
		assertThat(result, equalTo(2));
	}
}
```

検証の `equalTo(2)` で、Hamcrest というライブラリを使っています。JUnit も内部で Hamcrest を使用しています。


## 手順2. クラスパスの設定
Gradle のビルドファイルを使って、クラスパス（依存性）を設定しました。

`gsjt/build.gradle`

```gradle
apply plugin: 'java'
apply plugin: 'eclipse'

compileJava.options.encoding = 'UTF-8'
compileTestJava.options.encoding = 'UTF-8'
sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
}
dependencies {
	testCompile 'junit:junit:4.12'
}
```

dependencies で JUnit を設定しています。


## 手順3. テストの実行
テスト実行方法の例を２つ書きます。

### 手順3.1. Eclipse で実行
Eclipse（のエディタ）でテストクラスを開いて、「実行（JUnit テストとして実行）」します。実行すると、JUnit のビューに実行結果が表示されます。

![view-junit](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812231946.png)

緑だと成功で、赤だと失敗のケースがあります。ビューで失敗したメソッドを選択すると、実行結果や例外を確認できます。

### 手順3.2. コマンドラインで実行
ビルドファイルを作成した gsjt ディレクトリで、Gradle のコマンドを実行します。

```txt
gsjt > gradle test
```

デフォルトだと、シンプルなレポート（`build/reports/tests/index.html`）に、テスト結果が出力されるようです。


## 参考文献
[Getting started - JUnit](https://github.com/junit-team/junit4/wiki/Getting-started)

[The Hamcrest Tutorial - Java Hamcrest](https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki)
