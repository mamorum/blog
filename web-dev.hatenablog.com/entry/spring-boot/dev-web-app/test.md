---
Title: SpringBoot アプリ開発：9.テスト
Category:
- Spring
Date: 2016-06-24T19:15:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/test
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179186802
---

最後に、つぶやきアプリのテスト（一部）を実装していこうと思います。ＵＴは JUnit、ＩＴ（画面テスト）は FluentLenium を使います。


## 補足
テストの方法や範囲、テストで使うプロダクトは、開発条件によって様々だと思います。今回の内容も、あくまで一例だと思って頂ければ幸いです。


## 1. 依存性の確認（ビルドファイル）
[2. プロジェクト作成](/entry/spring-boot/dev-web-app/project) で、テストに関連する依存性を設定していました。


```gradle
dependencies {
   ・・・省略・・・
    testCompile 'org.springframework.boot:spring-boot-starter-test'
    testCompile 'org.fluentlenium:fluentlenium-assertj:0.10.6'
    testCompile 'xml-apis:xml-apis:1.4.01'
}
```

上から順に、依存性のメモを書いていきます。

### 1.1. spring-boot-starter-test
Spring Boot の POM で、Spring Test, JUnit, Hamcrest, mockito 等が追加されます。詳細は、[こちらの記事](/entry/spring-boot/intro/mockito) を参照して頂ければと思います。

### 1.2. fluentlenium-assertj
FluentLenium と その AssertJ 拡張です。FluentLenium のことは、[こちらの記事](/entry/java/test/fluentlenium/quick-start) にも書いています。

### 1.3. xml-apis
最新の XML API です。Spring Boot JPA が 古い XML API に依存していて、それだと FluentLenium でエラーが発生しました。


## 3. UT（Java の単体テスト）
JUnit, AssertJ, mockito を使って、コントローラのテストケースを１つ実装しました。

`sbt/src/test/java/sbt/controller/TsubuyakiControllerTest.java`

```java
package sbt.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.Test;

import sbt.model.Tsubuyaki;
import sbt.repository.TsubuyakiRepository;

public class TsubuyakiControllerTest {

  @Test public void testCreate() {

    // 準備：テストデータ
    Tsubuyaki data = new Tsubuyaki();
    data.txt = "メッセージ";

    // 準備：モック（リポジトリ）
    TsubuyakiRepository mock = mock(TsubuyakiRepository.class);
    when(mock.save(data)).thenReturn(data);

    // 準備：テスト対象クラス
    TsubuyakiController target = new TsubuyakiController();
    target.repo = mock;

    // 実行：テスト対象メソッド
    Map<String, Tsubuyaki> result = target.create(data);

    // 検証：つぶやきが等しいこと
    Tsubuyaki tsubuyaki = result.get("tsubuyaki");
    assertThat(tsubuyaki.txt).isEqualTo("メッセージ");
  }
}
```

リポジトリクラスがモックなので、ＤＢアクセスは発生しません。


## 4. IT（ブラウザテストの自動化）
JUnit, AssertJ, FluentLenium を使って、つぶやきを投稿するケースを実装しました。テスト用のクラスは２つあります。

### 4.1. つぶやき画面のクラス
`sbt/src/test/java/it/page/TsubuyakiPage.java`

```java
package it.page;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

public class TsubuyakiPage extends FluentPage {

  FluentWebElement txt, create;

  @Override public String getUrl() {
    return "http://localhost:8080/";
  }
  @Override public void isAt() {
    assertThat(title()).isEqualTo("Spring Boot Tutorial.");
    assertThat(txt).isDisplayed();
    assertThat(create).isDisplayed();
  }

  public void つぶやきを投稿する(String つぶやき) {
    txt.text(つぶやき);
    create.click();
  }
  public void つぶやきが表示されている(String つぶやき) {
    await().atMost(5000).until(".tsubuyaki .txt p").isPresent();
    FluentWebElement p = findFirst(".tsubuyaki .txt p");
    assertThat(p.getText()).isEqualTo(つぶやき);
  }
}
```

クラスのプロパティは、HTML の DOM要素になります。 txt は「テキストエリア（id="txt"）」で、 create が「投稿ボタン（id="create"）」です。


### 4.2. テストクラス
`sbt/src/test/java/it/TsubuyakiTest.java`

```java
package it;

import it.page.TsubuyakiPage;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class TsubuyakiTest extends FluentTest {

  @Page TsubuyakiPage つぶやき画面;

  @Test public void つぶやきを投稿する() {

    // given
    goTo(つぶやき画面);
    String つぶやき = "こんにちは。";

    // when
    つぶやき画面.つぶやきを投稿する(つぶやき);

    // then
    goTo(つぶやき画面);
    つぶやき画面.つぶやきが表示されている(つぶやき);
  }
}
```

つぶやき画面を使って、テスト操作をするクラスです。"こんにちは。" という文字列を投稿して、それが画面に表示されることを確認しています。


### 4.3. テストブラウザ
FluentLenium は、デフォルトだと FireFox を使うようです。テスト前にインストールしておいたほうが良さそうです。


### 4.4. テスト実行方法
Webアプリを起動してから、テストクラスを JUnit ケースとして実行します。

