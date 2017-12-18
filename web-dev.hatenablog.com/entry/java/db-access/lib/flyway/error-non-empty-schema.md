---
Title: Flyway：マイグレーションエラー（テーブルのあるスキーマ）
Category:
- Java
Date: 2017-12-15T00:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/lib/flyway/error-non-empty-schema
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812324474107
---

[Flyway](https://flywaydb.org/) で DBのマイグレーションをしていたら、テーブル（オブジェクト）が既に存在するスキーマでエラーになりました。

これから、エラーの詳細、原因、対応方法について書いていこうと思います。


## エラー内容
Flyway でマイグレーションを実行すると、次のエラーメッセージが表示されてアプリが終了しました。

```
Exception in thread "main" org.flywaydb.core.api.FlywayException: Found non-empty schema(s) "public" without metadata table! Use baseline() or set baselineOnMigrate to true to initialize the metadata table.
	at org.flywaydb.core.Flyway$1.execute(Flyway.java:995)
	at org.flywaydb.core.Flyway$1.execute(Flyway.java:971)
	at org.flywaydb.core.Flyway.execute(Flyway.java:1464)
	at org.flywaydb.core.Flyway.migrate(Flyway.java:971)
	at lib.FlywayMain.main(FlywayMain.java:20)
```


## 原因
Flyway のマイグレーションを実行してないのに（Flyway が作成する管理用のテーブル `schema_version` が存在しないのに）、他のテーブルなどが存在するのが原因みたいです。


## 対応方法
Flyway を実行する前に、スキーマのオブジェクトを削除しておきます。

例えば、次のような場合は、

```
test=> \d
              リレーションの一覧
 スキーマ |    名前     |     型     | 所有者
----------+-------------+------------+--------
 public   | memo        | テーブル   | neko
 public   | memo_id_seq | シーケンス | neko
(2 行)
```

事前にテーブルをドロップしておきます。

```
test=> drop table memo;
DROP TABLE
```

シーケンスも一緒に削除されるはずなので、テーブルが空になったことを確認して、Flyway のマイグレーションを実行すれば大丈夫そうです。


## 補足
既存のテーブルを削除できない場合は、Flyway の `baseline()` メソッドを実行したり、プロパティ `baselineOnMigrate` を設定する方法などがあるみたいです。
