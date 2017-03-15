---
Title: SpringBoot入門：JPAでデータアクセス
Category:
- Spring Boot 入門
Date: 2017-03-11T17:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/jpa
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179107669
---

SpringBoot の Webアプリで、JPA を使う方法を書いていきます。JPA を使うと、SQL を書かずにデータを操作することができます。


## 前提
この記事は「[FlywayでDBマイグレーション](/entry/spring-boot/intro/flyway)」の環境（JDK, PostgreSQL等）や資源（ビルドファイル, クラス, テーブル等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. ドメイン（エンティティ）の作成
データを保持するクラスを作成します。Flyway の記事で作成したテーブルに対応しています。

`gssb-rdb/src/main/java/gssb/rdb/model/Memo.java`

```java
package gssb.rdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@Entity    // JPAエンティティに必要。
public class Memo extends TimestampEntity {

  // データ型 serial（PostgreSQL）。
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  public long id;

  @NotEmpty
  public String text;

  @Version
  public long version;    
}
```

タイムスタンプ（作成日時、更新日時）は、次の親クラスで保持します。Insert前 と Update前（`@PrePersist` と `@PreUpdate`）に、日時を設定する処理を実装しています。

`gssb-rdb/src/main/java/gssb/rdb/model/TimestampEntity.java`

```java
package gssb.rdb.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass    // JPAエンティティの親に必要。
public abstract class TimestampEntity {

  public Timestamp updatedTime;

  @Column(updatable=false)
  public Timestamp createdTime;

  @PrePersist
  public void prePersist() {
    Timestamp ts = new Timestamp((new Date()).getTime());
    this.createdTime = ts;
    this.updatedTime = ts;
    }

  @PreUpdate
  public void preUpdate() {
    this.updatedTime = new Timestamp((new Date()).getTime());
  }
}
```

MySQL のように、PostgreSQL の create 文で `... on update current_timestamp` が使えれば不要になる気がします。


## 手順2. リポジトリの作成
データを操作するインターフェイスを作成します。

`gssb-rdb/src/main/java/gssb/rdb/repository/MemoRepository.java`

```java
package gssb.rdb.repository;

import org.springframework.data.repository.CrudRepository;

import gssb.rdb.model.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
  // 引数の text に一致するエンティティを取得。
  Iterable<Memo> findByText(String text);
}
```

`CrudRepository` を継承すると、基本的なデータ操作（CRUD）用のメソッドが追加されます。また、上の `findByText(String)` のように、Spring の命名規約に従ってメソッドを実装すると、CRUD の where 句などを指定できます。

詳細は、[Spring Data JPA のドキュメント](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/) に書かれています。


## 手順3. コントローラの作成
リクエストを受け付けて、リポジトリに処理を移譲するクラスを作成します。

`gssb-rdb/src/main/java/gssb/rdb/controller/JpaMemoController.java`

```java
package gssb.rdb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

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

  // リクエストパラメータ text の内容と等しいデータを select。
  @RequestMapping(method=RequestMethod.GET)
  public Map<String, Iterable<Memo>> read(@RequestParam String text) {
    Iterable<Memo> result = repository.findByText(text);
    return Collections.singletonMap("memos", result);
  }
}
```


## 手順4. 起動
事前に PostgreSQL を起動してから、次のコマンドでアプリを起動します。

```txt
gssb-rdb > mvn spring-boot:run
```


## 手順5. 確認
### 手順5.1. メモの作成
curl を使って、メモを１つ作成してみます（コントローラの create メソッド実行）。

`実行コマンド（※ JSON 内のエスケープ文字「\」は Windows で必要）`

```txt
curl -H "Content-Type: application/json" -d "{\"text\":\"Data\"}" http://localhost:8080/jpa/memos -X POST
```

`実行結果`

```json
{"memo":{"updatedTime":1464938295852,"createdTime":1464938295852,"id":3,"text":"Data","version":0}}
```

### 手順5.2. メモの検索
作成したメモを検索してみます（コントローラの read メソッド）。

`実行コマンド`

```txt
curl http://localhost:8080/jpa/memos?text=Data
```

`実行結果`

```json
{"memos":[{"updatedTime":1464938295852,"createdTime":1464938295852,"id":3,"text":"Data","version":0}]}
```


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
