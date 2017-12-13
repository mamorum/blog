---
Title: Java：FlywayでDBマイグレーション
Category:
- Java
Date: 2017-12-12T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/lib/flyway-quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812323860510
---

[Flyway](https://flywaydb.org/) を使って、PostgreSQL のデータベースをマイグレーションする方法を書いていきます。DBマイグレーションとは、DBのデータを残したまま、テーブル作成やカラム変更などをすることです。


## 手順1. 依存性の追加
記事「[Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)」で作成した `pom.xml` に、flyway の依存性を追加します。

`db-access/pom.xml（追加部分）`

```
    <dependency>
      <groupId>org.flywaydb</groupId>
      <artifactId>flyway-core</artifactId>
      <version>4.2.0</version>
    </dependency>
```

`dependencies` タグの下に追加すれば大丈夫です。


## 手順2. SQLファイルの作成
マイグレーションに使うファイルを作成します。内容はSQLでテーブルを２つ作成する感じです。

`db-access/src/main/resources/db/migration/V1__create_tables.sql`

```sql
create table memo (
  id serial primary key,
  txt varchar(200) not null,
  updated timestamp not null default current_timestamp,
  created timestamp not null default current_timestamp
);

create table person (
  id serial primary key,
  name varchar(100) not null,
  updated timestamp not null default current_timestamp,
  created timestamp not null default current_timestamp
);
```

ファイルの配置場所と名前は、[Flyway の規約](https://flywaydb.org/documentation/migration/sql) に従っています。


## 手順3. Mainクラスの作成
Flyway でマイグレーションをして、memo テーブルにデータを追加するクラスを作成します。

`db-access/src/main/java/lib/FlywayMain.java`

```java
package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.flywaydb.core.Flyway;

import jdbc.base.Driver;

public class FlywayMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    //-> マイグレーション
    Flyway flyway = new Flyway();
    flyway.setDataSource(
      "jdbc:postgresql://localhost/test", "neko", "cat"
    );
    flyway.migrate();
    //-> INSERT
    try (Connection con = Driver.connect()) {
      PreparedStatement ps = con.prepareStatement(
        "insert into person (name) values (?)"
      );
      ps.setString(1, "Suzuki Taro");
      int count = ps.executeUpdate();
      System.out.print("INSERT ");
      System.out.println(count);
      ps.close();
    }
  }
}
```

`flyway.migrate();` で、先ほどのSQLを実行してくれます。一度実行されたSQLは、次回のアプリ起動時には実行されないようになります。Flyway が DB にテーブル `schema_version` を作成して、実行したSQLの情報などを管理してくれます。


## 手順4. 動作確認
事前に PostgreSQL を起動して、データベース・ユーザを作成しておきます。作成方法は「[DB環境の準備](/entry/java/db-access/postgresql/db-env)」に書いてます。

リンク先のテーブル `memo` を既に作成している場合は、psql などで `drop table memo;` を実行して消しておきます。

```
test=> \d
              リレーションの一覧
 スキーマ |    名前     |     型     | 所有者
----------+-------------+------------+--------
 public   | memo        | テーブル   | neko
 public   | memo_id_seq | シーケンス | neko
(2 行)


test=> drop table memo;
DROP TABLE
```


それから、上の `FlywayMain` を実行すると、


```

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
INSERT 1
```

といった文字列が出力されて、INSERTが１件成功してます。上から３行のメッセージ（SLF4J...）は、Flyway が SLF4J を使っている関係で出力されています。

psql でデータを確認してみます。

```
test=> select id, name from person;
  id |    name
----+-------------
  1 | Suzuki Taro
(1 行)
```

もう一度 `FlywayMain` を実行するとデータが２件になります。マイグレーションの SQL（`V1__create_tables.sql`）が実行されるのは一度だけです。
