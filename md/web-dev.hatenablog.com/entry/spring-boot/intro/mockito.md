---
Title: SpringBoot入門：mockitoで単体テスト
Category:
- spring-boot
Date: 2016-06-10T16:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/mockito
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179107954
---

Spring Boot の Webアプリで、mockito を使って単体テストをする方法を書きます。今回は、リポジトリクラスのモックを用意して、DB にアクセスせずにテストしてみます。


## 前提（テスト対象）
記事「[JPAでデータアクセス](/entry/spring-boot/intro/jpa)」で作成したコントローラのメソッド `create` をテストしてみます。

以下は、テスト対象コントローラのコード（一部）です。

`gssb-rdb/src/main/java/gssb/rdb/controller/JpaMemoController.java`

```java
@RestController
@RequestMapping(path="/jpa/memos")
public class JpaMemoController {

    @Autowired MemoRepository repository;
    
    // リクエストの JSON を Memo にバインドして insert。
    @RequestMapping(method=RequestMethod.POST)
    public Map<String, Memo> create(@RequestBody Memo memo) {
        Memo result = repository.save(memo);
        return Collections.singletonMap("memo", result);
    }
```


## 手順1. ビルドファイルの編集
記事「[JPAでデータアクセス](/entry/spring-boot/intro/jpa)」のビルドファイルを編集して、`dependencies` に `spring-boot-starter-test` と `assertj-core（テスト結果検証用）` を追加します。

```gradle
dependencies {
    （省略）
    testCompile 'org.springframework.boot:spring-boot-starter-test'
    testCompile 'org.assertj:assertj-core:3.4.1'
}
```

`spring-boot-starter-test` を追加すると、以下のライブラリが使えるようになります。

- Spring Test
- JUnit
- Hamcrest
- mockito

詳細は「[Test scope dependencies - Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-test-scope-dependencies)」に記載されています。


## 手順2. テストクラスの作成
mockito でリポジトリのモックを作成して、コントローラをテストするコードを書いていきます。

`gssb-rdb/src/test/java/gssb/rdb/controller/JpaMemoControllerTest.java`

```java
package gssb.rdb.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Map;
import org.junit.Test;
import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

public class JpaMemoControllerTest {

    @Test public void testCreate() {
        
        // 準備：テストデータ
        Memo memo = new Memo();
        memo.text = "テスト";

        // 準備：リポジトリのモック（戻り値を設定）
        MemoRepository repo = mock(MemoRepository.class);
        when(repo.save(memo)).thenReturn(memo);

        // 準備：テスト対象（リポジトリのモックを設定）
        JpaMemoController controller = new JpaMemoController();
        controller.repository = repo;

        // 実行
        Map<String, Memo> result = controller.create(memo);

        // 検証
        assertThat(result.get("memo").text).isEqualTo("テスト");
    }
}
```

`@Test` をつけると JUnit のテストケースになります。


## 手順3. テスト実行
Eclipse の場合、テストクラスをエディタで開いて「実行（JUnit テストとして実行）」します。

また、コマンドラインからも実行できます。

```txt
gssb-rdb > gradle test
```

コマンドを実行すると、テスト結果がレポート（`build/reports/tests/index.html`）に出力されます。


## 補足1. コントローラ以外のテスト
複雑な処理をするクラス（サービスクラス等）も、この方法を応用してテストできると思います。


## 補足2. 単体テストの範囲
実際の開発では、コントローラを単体テストするかは微妙なところです。時間や工数がかかって大変になりそうです。


## 関連記事
[Java テスト入門](/entry/java/test/table-of-contents)  
※ JUnit, AssertJ, mockito, FluentLenium（画面テスト）のことを書いています。


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
