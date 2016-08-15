---
Title: 画面テスト：FluentLenium 入門
Category:
- Java テスト
Date: 2016-04-22T17:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/test/fluentlenium/quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179059194
---

FluentLenium を使って、画面テスト（ブラウザテスト）を自動化する手順を書いていきます。FluentLenium は、Java で Selenium のテストを簡単に書くためのツールです。


## 手順1. テストクラスの作成
JUnit のテストケースとして、Bing（検索エンジン）で FluentLenium（キーワード）を検索するプログラムを書いてみました。

`gsjt/src/test/java/gsjt/FluentLeniumTest.java`

```java
package gsjt;

import static org.assertj.core.api.Assertions.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

public class FluentLeniumTest extends FluentTest {

	@Test public void BingでFluentLeniumを検索する() {

		// 準備：Bing を開いてキーワードを入力する。
		goTo("http://www.bing.com");
		fill("#sb_form_q").with("FluentLenium");

		// 実行：検索する。
		submit("#sb_form_go");

		// 検証：タイトルにキーワードが含まれること。
		assertThat(title()).contains("FluentLenium");
	}
}
```

FluentLenium のクラス `FluentTest` を継承しているので、`goTo`, `fill`, `submit` などの画面を操作するメソッドが使えます。

検証コード `assertThat(...)` は、[AssertJ の記事](/entry/java/test/assertj/quick-start) に詳しく書いています。


## 手順2. クラスパスの設定
Gradle だと、ビルドファイルの dependencies に次の内容を追加します。

```gradle
testCompile 'org.fluentlenium:fluentlenium-assertj:0.13.0'
```

テストを実行する場合、次の記事を参考にして頂ければ幸いです。

- [JUnit入門（のビルドファイル）](/entry/java/test/junit/quick-start)
- [AssertJ入門（のクラスパス設定）](/entry/java/test/assertj/quick-start)


## 補足. テストの実行
プログラムを JUnit として実行すると、自動で FireFox（要インストール）が起動して、テスト（画面操作や結果検証）をしてくれます。


## 参考文献
[README - FluentLenium](https://github.com/FluentLenium/FluentLenium)
