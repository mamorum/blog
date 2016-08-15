---
Title: 単体テスト：AssertJ 入門
Category:
- Java テスト
Date: 2016-04-22T17:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/test/assertj/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179058458
---

Java の単体テストで、AssertJ を使う方法を書いていきます。AssertJ は、テスト結果を評価するためのツールです。


## 手順1. テストクラスの作成
JUnit を使ってテストケースを作成します。検証の箇所で、AssertJ を使っています。

`gsjt/src/test/java/gsjt/AssertjTest.java`

```java
package gsjt;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class AssertjTest {

	@Test public void test() {
		
		// 準備（≒ given）
		int a = 1;
		
		// 実行（≒ when）
		int result = a + a;
		
		// 検証（≒ then）
		// 結果 result が、期待値 2 と等しいこと。
		assertThat(result).isEqualTo(2);
	}
}
```


## 手順2. クラスパスの設定
Gradle だと、ビルドファイルの dependencies に次の内容を追加します。

```gradle
testCompile 'org.assertj:assertj-core:3.4.1'
```

テストを実行する場合、[JUnit の記事](/entry/java/test/junit/quick-start) のビルドファイルを参考にして頂ければ幸いです。


## 補足. AssertJ の便利な使い方
AssertJ は、IDE（Eclipse など）のコード補完と相性が良いです。`assertThat(...)` の後にピリオドを打つと、メソッドの候補が現れます。

![code-complete](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814133959_original.png)

メソッド名から、処理（表明）の内容が推測できて便利です。

AssertJ が実装しているようなインターフェイスは、「流れるようなインターフェイス（Fluent Interface）」と呼ばれたりします。


## 参考文献
[Quick start - AssertJ](http://joel-costigliola.github.io/assertj/assertj-core-quick-start.html)
