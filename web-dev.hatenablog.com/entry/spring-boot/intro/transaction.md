---
Title: SpringBoot入門：トランザクションの管理
Category:
- Spring Boot 入門
Date: 2017-03-12T18:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/transaction
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179110066
---

Spring Boot の Webアプリで、RDB のトランザクションを管理する方法を書きます。Spring Framework の アノテーション `@Transactional` を使って管理します。


## 前提
この記事は、記事「[JPAでデータアクセス](/entry/spring-boot/intro/jpa)」の資源（ビルドファイル、クラス等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
リクエストを受け付けて、データを操作するクラスです。

`gssb-rdb/src/main/java/gssb/rdb/controller/TxMemoController.java`

```java
package gssb.rdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

@RestController
@RequestMapping(path="/tx")
public class TxMemoController {

  @Autowired MemoRepository repository;

  // メモを１つ作成して、その後でエラーを発生させるメソッド
  private void create(Memo memo) {
    repository.save(memo);
    repository.save(new Memo()); // text の NotEmpty でエラー。
  }

  // トランザクションを管理する。
  @Transactional
  @RequestMapping(path="/on/memos", method=RequestMethod.POST)
  public void txOn(@RequestBody Memo memo) {
    create(memo);
  }

  // トランザクションを管理しない。
  @RequestMapping(path="/off/memos", method=RequestMethod.POST)
  public void txOff(@RequestBody Memo memo) {
    create(memo);
  }
}
```

処理結果を比較するために、`@Transactional` を宣言するメソッドと、宣言しないメソッドを用意しました。

本格的なアプリだと、サービスクラスに処理とトランザクション宣言を実装することがあります。


## 手順2. 起動
事前に PostgreSQL を起動してから、次のコマンドでアプリを起動します。

```txt
gssb-rdb > mvn spring-boot:run
```


## 手順3. 確認
動作確認には curl と psql を使います。事前に psql で Memo テーブルを空にしておきます。

`実行コマンド`

```txt
spring=> delete from memo;
```

### 手順3.1. トランザクション管理の確認
curl を使って、トランザクションを管理するメソッドを呼び出します。メモを１つ登録して、エラーが発生します。

`実行コマンド（※ JSON 内のエスケープ文字「\」は Windows で必要）`

```txt
curl -H "Content-Type: application/json" -d "{\"text\":\"Data\"}" http://localhost:8080/tx/on/memos -X POST
```

`実行結果`

```txt
{"timestamp":1465023216817,"status":500,"error":"Internal Server Error","exception":"javax.validation....
```

トランザクションがロールバックされるので、メモは１つも登録されていないはずです。psql で確認します。

`実行コマンド`

```txt
spring=> select * from memo;
```

`実行結果`

```txt
 id | text | version | updated_time | created_time
----+------+---------+--------------+--------------
(0 行)
```

### 手順3.2. トランザクション非管理の確認
次に、トランザクションを管理しないメソッドを呼び出します。

`実行コマンド`

```txt
curl -H "Content-Type: application/json" -d "{\"text\":\"Data\"}" http://localhost:8080/tx/off/memos -X POST
```

`実行結果`

```txt
{"timestamp":1465023445275,"status":500,"error":"Internal Server Error","exception":"javax.validation....
```

ロールバックされない（BEGIN もない）ので、メモが１つ登録されているはずです。psql で確認してみます。

`実行コマンド`

```txt
spring=> select * from memo;
```

`実行結果`

```txt
 id | text | version |      updated_time       |      created_time
----+------+---------+-------------------------+-------------------------
  6 | Data |       0 | 2016-06-04 15:57:25.244 | 2016-06-04 15:57:25.244
(1 行)
```


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
