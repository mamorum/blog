---
Title: Java：HikariCP+Flyway+sql2oでDBアクセス
Category:
- Java
Date: 2017-12-14T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/lib/hikaricp-flyway-sql2o
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812324456055
---

[HikariCP](http://brettwooldridge.github.io/HikariCP/) のコネクションプールを使って、

- [Flyway](https://flywaydb.org/) でDBマイグレーション
- [sql2o](https://www.sql2o.org/) でDBアクセス（SQL実行）

をする方法を書いておきます。


## 手順1. DB設定ファイルの作成
コネクションプールの生成で必要なファイルを作成します。

`db-access/src/main/resources/db/hikari.properties`

```
dataSourceClassName=org.postgresql.ds.PGSimpleDataSource
dataSource.user=neko
dataSource.password=cat
dataSource.databaseName=test
dataSource.portNumber=5432
dataSource.serverName=localhost
```

内容は [HikariCP のドキュメント](https://github.com/brettwooldridge/HikariCP) に従っています。


## 手順2. メインクラスの作成
コネクションプールを作成して、DBを操作するクラスを作成します。

`db-access/src/main/java/lib/HikariFlySqlMain.java`

```java
package lib;

import org.flywaydb.core.Flyway;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.quirks.PostgresQuirks;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import model.Memo;

public class HikariFlySqlMain {
  public static void main(String[] args) {
    //-> コネクションプールを準備
    HikariConfig c = new HikariConfig("/db/hikari.properties");
    HikariDataSource ds = new HikariDataSource(c);
    //-> マイグレーションを実行
    Flyway fly = new Flyway();
    fly.setDataSource(ds);
    fly.migrate();
    //-> SQL実行
    Sql2o sql = new Sql2o(ds, new PostgresQuirks());
    try (Connection con = sql.open()) {
      String now = con.createQuery(
        "select now()"
      ).executeAndFetchFirst(String.class);
      System.out.print("NOW ");
      System.out.println(now);
      Memo memo = con.createQuery(
        "insert into memo (txt) values (:txt) returning id, txt, updated, created"
      ).addParameter("txt", "Hello!").executeAndFetchFirst(Memo.class);
      System.out.print("INSERT ");
      System.out.println(memo.toString());
    }
  }
}
```

HikariCP のデータソースを、flyway と sql2o に渡してあげてるところがポイントになります。sql2o のところは `PostgresQuirks` というオブジェクトも一緒に渡してます。


## 補足1. sql2o の PostgresQuirks
sql2o のオブジェクト生成で、`PostgresQuirks` を使わずに動作確認したときのことを書いていきます。

そのときは、sql2o のオブジェクトを次のように生成しました。

```
Sql2o sql = new Sql2o(ds);
```

これで実行すると INSERT文のとこでエラーが発生しました。

```
NOW 2017-12-07 11:04:24.838532
Exception in thread "main" org.sql2o.Sql2oException: Database error: いかなる結果も、クエリによって返されませんでした。
	at org.sql2o.Query$ResultSetIterableBase.<init>(Query.java:332)
	at org.sql2o.Query$10.<init>(Query.java:412)
	at org.sql2o.Query.executeAndFetchLazy(Query.java:412)
	at org.sql2o.Query.executeAndFetchFirst(Query.java:480)
	at org.sql2o.Query.executeAndFetchFirst(Query.java:469)
	at lib.HikariFlySqlMain.main(HikariFlySqlMain.java:32)
Caused by: org.postgresql.util.PSQLException: いかなる結果も、クエリによって返されませんでした。
	at org.postgresql.jdbc.PgPreparedStatement.executeQuery(PgPreparedStatement.java:118)
	at com.zaxxer.hikari.pool.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:52)
	at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeQuery(HikariProxyPreparedStatement.java)
	at org.sql2o.Query$ResultSetIterableBase.<init>(Query.java:328)
	... 5 more
```

`select now()` は成功しているので、もしかしたら INSERT文の returning句のせいかもしれません。今のところ、HikariCP を使うときは `PostgresQuirks` を渡したほうが無難かもしれません。


## 補足2. 動作確認について
事前にDBのスキーマ（のオブジェクト）を空っぽにしておくとプログラムを実行できます。

例えば、プログラム実行前にテーブルやシーケンスが存在する場合、

```
test=> \d
               リレーションの一覧
 スキーマ |      名前      |     型     | 所有者
----------+----------------+------------+--------
 public   | memo           | テーブル   | neko
 public   | memo_id_seq    | シーケンス | neko
 public   | schema_version | テーブル   | neko
```

`drop memo;`, `drop schema_version;` を実行して頂ければ大丈夫です。１度プログラムを実行すると、Flyway がDBの状態を管理してくれます。２回目以降は drop しなくて大丈夫です。

