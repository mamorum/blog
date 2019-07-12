---
Title: SpringBoot入門：mockitoで単体テスト
Category:
- Spring
Date: 2017-03-14T16:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/mockito
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179107954
---

Spring Boot の Webアプリで、[mockito](http://site.mockito.org/) を使って単体テストをする方法を書きます。今回は、リポジトリクラスのモックを用意して、DB にアクセスせずにテストしてみます。


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
記事「[FlywayでDBマイグレーション](/entry/spring-boot/intro/flyway)」の` pom.xml` に、依存性 `spring-boot-starter-test` を追加します。

```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
```

追加すると、`Spring Test`, `JUnit`, `AssertJ`, `Mockito` 等が使えるようになります。詳細は「[Test scope dependencies - Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-test-scope-dependencies)」に記載されています。


## 手順2. テストクラスの作成
コントローラをテストするクラスを作成します。

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

テストケース（メソッド `#testCreate()`）では、mockito を使ってリポジトリのモックを準備しています。


## 手順3. テスト実行
Eclipse の場合、テストクラスをエディタで開いて「実行（JUnit テストとして実行）」します。下のように、Maven コマンドでも実行できます。

```
gssb-rdb > mvn test
```


## 補足
### 1. コントローラ以外のテスト
他のクラス（サービスクラス等）で DBアクセスしている場合なども、この方法を応用してテストできると思います。

### 2. 単体テスト対象
コントローラを単体テスト対象にするかは、開発条件によって変わってくると思います。


## 関連記事
[Java テスト入門](/entry/java/test/table-of-contents)  
※ JUnit, AssertJ, mockito, FluentLenium（画面テスト）のことを書いています。


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
