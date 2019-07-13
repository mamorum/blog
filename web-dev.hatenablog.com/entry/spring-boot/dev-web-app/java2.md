---
Title: SpringBoot アプリ開発：5.Java（コントローラ）
Category:
- Java
Date: 2016-06-23T22:25:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/java2
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179183195
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/overview) のアプリ）の コントローラを、Java で作成していきます。コントローラは、リクエストに対応する処理を実行して、処理結果（≒レスポンス）を返却するクラスです。


## コントローラの作成
コントローラの「作成場所（配置場所）」と「コード（完全版のリンク）」は、以下の通りです。

- 作成場所：`sbt/src/main/java/sbt/controller/TsubuyakiController.java`
- コード：[TsubuyakiController.java - GitHub](https://github.com/mamorum/blog/tree/master/code/sbt/src/main/java/sbt/controller/TsubuyakiController.java) 


## コントローラの概要
今回は、REST（RESTful API）のような感じで実装してみました。下テーブルのように、リクエスト（HTTPメソッド + URI）に対して、Javaメソッドが実行されるようにします。

| HTTPメソッド | URI                    | Javaメソッド |
|----------------|---------------------|---------------|
| `POST`        | `/tsubuyaki`        | create          |
| `GET`          | `/tsubuyaki`        | read            |
| `PUT`          | `/tsubuyaki/{id}` | update         |
| `DELETE`     | `/tsubuyaki/{id}` | delete          |

※ URI の `{id}` は、可変の数値（つぶやきのID）です。

これから、分割したコードとメモを一緒に書いていきます。


## コード1. クラス宣言、プロパティ等
```java
package sbt.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbt.model.Tsubuyaki;
import sbt.repository.TsubuyakiRepository;

@RestController @RequestMapping("/tsubuyaki")
public class TsubuyakiController {

  @Autowired TsubuyakiRepository repo;

// ・・・続く・・・
}
```

- `@RestController`：メソッドの戻り値（≒レスポンス）が、JSON に変換されるようになります。
- `@RequestMapping("/tsubuyaki")`：URI `/tsubuyaki` のリクエストを、このクラスで処理するようにしています。
- プロパティ `repo`：`@Autowired` を付けると、Spring がリポジトリのインスタンスを設定してくれます。


## コード2. create メソッド（POST /tsubuyaki）

```java
  @RequestMapping(method=RequestMethod.POST)
  public Map<String, Tsubuyaki> create(
      @Valid @RequestBody Tsubuyaki tsubuyaki
  ) {
    return Collections.singletonMap(
      "tsubuyaki", repo.save(tsubuyaki)
    );
  }

//・・・続く・・・
```

- 引数 `tsubuyaki`：リクエストボディ（リクエストの JSON）が設定されます。
- 処理内容：引数のつぶやきをＤＢに保存。
- 戻り値（レスポンス）：ＤＢに保存したつぶやき。


## コード3. read メソッド（GET /tsubuyaki）
```java
  @RequestMapping(method=RequestMethod.GET)
  public Map<String, Iterable<Tsubuyaki>> read() {
    return Collections.singletonMap(
      "tsubuyaki", repo.findAllByOrderByUpdatedTimeDesc()
    );
  }

// ・・・続く・・・
```

- 処理内容：ＤＢからつぶやきを取得。
- 戻り値：取得したつぶやき。


## コード4. update メソッド（PUT /tsubuyaki/{id}）
```java
  @RequestMapping(path="/{id}", method=RequestMethod.PUT)
  public void update(
      @PathVariable Long id, @RequestParam String txt
  ) {
    Tsubuyaki tsubuyaki = repo.findOne(id);
    tsubuyaki.txt = txt;
    repo.save(tsubuyaki);
  }

// ・・・続く・・・
```

- 引数 `id`：リクエストURI `{id}` の値。
- 引数 `txt`：リクエストパラメータ `txt` の値。
- 処理内容：`id` でつぶやきを取得。その `txt` を更新。


## コード5. delete メソッド（DELETE /tsubuyaki/{id}）
```java
@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    repo.delete(id);
  }
}
```

- 引数 `id`：リクエストURI `{id}` の値。
- 処理内容：`id` に一致するつぶやきをＤＢから削除。
