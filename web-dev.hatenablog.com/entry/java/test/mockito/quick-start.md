---
Title: Javaテスト：mockitoでモック作成
Category:
- Java
Date: 2016-04-22T17:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/test/mockito/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179058986
---

Java の単体テストで、mockito を使う方法を書いていきます。mockito は、Java の単体テスト用モックフレームワークです。

モックは「[モックオブジェクト（Wikipedia）](https://ja.wikipedia.org/wiki/%E3%83%A2%E3%83%83%E3%82%AF%E3%82%AA%E3%83%96%E3%82%B8%E3%82%A7%E3%82%AF%E3%83%88)」の略で、テストで用いられるスタブ（下位モジュールの代用品）の一種です。


## 手順1. モックの作成
JUnit のテストケースで、モックを作成するプログラムを書きました。また、モックのメソッドを実行してから、メソッドが実行されたことを検証しています。

`gsjt/src/test/java/gsjt/MockitoVerifyTest.java`

```java
package gsjt;

import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Test;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MockitoVerifyTest {

	@Test public void test() {

		// モックの作成。
		List mockedList = mock(List.class);

		// モックのメソッドを実行。
		mockedList.add("one");
		
		// メソッドが実行されたか検証。
		verify(mockedList).add("one");
		
		// 実行されてないメソッドは検証エラー。
		// verify(mockedList).add("two");
	}
}
```


## 手順2. モックメソッドの戻り値設定
mokito のモックは、`when(メソッド).thenReturn(戻り値)` で、メソッドの戻り値を設定できるようです。

`gsjt/src/test/java/gsjt/MockitoReturnTest.java`

```java
package gsjt;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Test;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MockitoReturnTest {

	@Test public void test() {

		// モックの作成。
		List mockedList = mock(List.class);

		// モックのメソッドを実行。
		mockedList.add("one");
				
		// モックに追加した "one" は取得できない。
		assertThat(mockedList.get(0)).isNull();
				
		// モックの戻り値を設定。
		when(mockedList.get(0)).thenReturn("two");

		// モックの戻り値を検証。
		assertThat(mockedList.get(0)).isEqualTo("two");
	}
}
```

検証コード `assertThat(...)` は、[AssertJ の記事](/entry/java/test/assertj/quick-start) に詳しく書いています。


## 手順3. クラスパスの設定
Gradle だと、ビルドファイルの dependencies に次の内容を追加します。

```gradle
testCompile 'org.mockito:mockito-core:1.10.19'
```

テストを実行する場合、次の記事を参考にして頂ければ幸いです。

- [JUnit入門（のビルドファイル）](/entry/java/test/junit/quick-start)
- [AssertJ入門（のクラスパス設定）](/entry/java/test/assertj/quick-start)

## 補足. 実クラスのモックについて
今回は List（インターフェイス）で試しましたが、ArrayList（実クラス）などのモックも作れました。`mock(ArrayList.class)` と書けば大丈夫そうです。


## 参考文献
[INTRO - mockito](http://mockito.org/)
