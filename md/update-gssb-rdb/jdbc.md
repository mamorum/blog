---
Title: SpringBoot入門：JDBCでデータアクセス
Date: 2017-03-10
---

SpringBoot の Webアプリで、JDBC 機能を使う方法を書いていきます。プログラム内に SQL（insert, select など）を書いてデータを操作します。


## 前提
この記事は「[FlywayでDBマイグレーション](/entry/spring-boot/intro/flyway)」の環境（JDK, PostgreSQL等）や資源（ビルドファイル, クラス, テーブル等）を利用しています。必要に応じて参照して頂けると嬉しいです。


## 手順1. コントローラの作成
リクエストを受け付けて、データを操作するクラスを作成します。

`gssb-rdb/src/main/java/gssb/rdb/controller/JdbcMemoController.java`

```java
package gssb.rdb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/jdbc/memos")
public class JdbcMemoController {

  @Autowired JdbcTemplate jdbc;

  // リクエストパラメータ text を insert。
  @RequestMapping(method=RequestMethod.POST)
  public Map<String, Long> create(@RequestParam String text) {
    Long id = jdbc.queryForObject(
      "insert into memo (text) values (?) returning id",
      new Object[] {text},
      (rs, num) -> rs.getLong("id")
    );
    return Collections.singletonMap("id", id);
  }

  // リクエストＵＲＬ末尾のＩＤと等しいデータを select。
  @RequestMapping(path="/{id}", method=RequestMethod.GET)
  public Map<String, Memo> read(@PathVariable Long id) {
    Memo memo = jdbc.queryForObject(
      "select id, text from memo where id = ?",
      new Object[] {id},
      (rs, num) -> new Memo(rs.getLong("id"), rs.getString("text"))
    );
    return Collections.singletonMap("memo", memo);
  }

  // JDBC で操作するエンティティ。
  public static class Memo {
    public Long id;
    public String name;
    public Memo(Long id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
```

今回はコントローラに SQL を書きましたが、データアクセス用のクラス（リポジトリ等）を用意しても良いと思います。


## 手順2. 起動
事前に PostgreSQL を起動してから、次のコマンドでアプリを起動します。

```txt
gssb-rdb > mvn spring-boot:run
```


## 手順3. 確認
### 手順3.1. メモの作成（insert）
次のコマンドで、メモを１つ作成してみます。

`実行コマンド`

```
curl http://localhost:8080/jdbc/memos -X POST -d "text=Test"
```

`実行結果`

```
{"id":1}
```

ID=1 のメモが作成されました。


### 手順3.2. メモの検索（select）
作成したメモを検索してみます。

`実行コマンド`

```
curl http://localhost:8080/jdbc/memos/1
```

`実行結果`

```
{"memo":{"id":1,"name":"Test"}}
```


## ソースコード
[gssb-rdb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb-rdb)  
※ プロジェクト名の gssb は、Getting Started Spring Boot の略です。
