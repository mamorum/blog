---
Title: Java：sql2oでSQL実行
Category:
- Java
Date: 2017-11-23T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/lib/sql2o-quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812318574041
Draft: true
---

[sql2o](https://www.sql2o.org/) を使って、PostgreSQL に対して簡単な SQL を実行する方法を書いていきます。sql2o を使うと、

- JDBC の直接利用よりコードが少なくなる
- SQL実行結果を簡単に Javaオブジェクトに変換できる

などのメリットがあります。


## 手順1. 依存性の追加
記事「[Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)」で作成した `pom.xml` に、sql2o の依存性を追加します。

`db-access/pom.xml（追加部分）`

```
    <dependency>
      <groupId>org.sql2o</groupId>
      <artifactId>sql2o</artifactId>
      <version>1.5.4</version>
    </dependency>
```

`dependencies` タグの下に追加すれば大丈夫です。


## 手順2. モデルの作成
SQL の結果を格納するオブジェクトを作成します。

`db-access/src/main/java/model/Memo.java`

```java
package model;

import java.sql.Timestamp;

public class Memo {
  public long id;
  public String txt;
  public Timestamp updated, created;
  public String toString() {
    return new StringBuilder(
      ).append(id).append(", "
      ).append(txt).append(", "
      ).append(updated).append(", "
      ).append(created
    ).toString();
  }
}
```

`toString()` はデータ確認用です。


## 手順3. Mainクラスの作成
sql2o で SQL を実行する Mainクラスを作成します。

`db-access/src/main/java/lib/Sql2oMain.java`

```java
package lib;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import model.Memo;

public class Sql2oMain {
  public static void main(String[] args) {
    Sql2o sql2o = new Sql2o(
      "jdbc:postgresql://localhost/test",  // url
      "neko", "cat" // user, password
    );
    try (Connection con = sql2o.open()) {
      //-> insert 実行
      Long id = con.createQuery(
        "insert into memo (txt) values (:txt) returning id"
      ).addParameter("txt", "sql2o").executeAndFetchFirst(Long.class);
      System.out.println("ID: " + id);
      //-> select 実行
      Memo memo = con.createQuery(
        "select id, txt, updated, created from memo where id = :id"
      ).addParameter("id", id).executeAndFetchFirst(Memo.class);
      System.out.println("Memo: " + memo.toString());
      //-> delete 実行
      con.createQuery(
        "delete from memo where id = :id"
      ).addParameter("id", id).executeUpdate();
    }
  }
}
```

コネクション取得や SQL実行は、sql2o の API を使っています。内容としては、テーブル `memo` に対して insert, select, delete をしています。


## 手順4. 動作確認
事前に PostgreSQL を起動して、データベース・ユーザ・テーブルを作成しておきます。作成方法は「[DB環境の準備](/entry/java/db-access/postgresql/db-env)」に書いてます。

上の `Sql2oMain` を実行すると、


```
ID: 36
Memo: 36, sql2o, 2017-11-17 12:03:55.225018, 2017-11-17 12:03:55.225018
```

といった文字列が出力されて、SQLが実行されたことを確認できます。最後に psql で ID36 を確認すると、きちんと削除されてそうです。


```
test=> select * from memo where id = 36;
 id | txt | updated | created
----+-----+---------+---------
(0 行)
```
