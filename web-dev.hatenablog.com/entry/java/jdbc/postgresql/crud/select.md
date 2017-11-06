---
Title: JDBC：SELECT文の実行
Category:
- Java
Date: 2017-11-05T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdbc/postgresql/crud/select
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812314310017
---

JDBC を使って、Java からデータベースに対して SELECT文を実行する方法を書いていきます。データベースは、RDBMS の PostgreSQL を使いました。


## 前提
この記事のサンプルプログラムを実行するには、以下記事のDB環境や資源（プロジェクト、Javaクラス、等）が必要になります。

- [DB環境の準備](/entry/java/jdbc/postgresql/db-env)
- [Java共通資源の作成](/entry/java/jdbc/postgresql/java-project-common-class)


## 手順1. SELECT実行クラスの作成
Prepared文（PreparedStatement）で SQL を実行するクラスを作成します。

`jdbc-pg/src/main/java/basic/SelectMain.java`

```java
package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Pg.connect()) {
      //-> データを取得するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "select id, txt, updated from memo where txt = ?"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "insert-test");
      //-> SQLを実行してデータを取得
      ResultSet rs = ps.executeQuery();
      //-> データを表示
      while (rs.next()) {
        System.out.print(rs.getLong("id"));
        System.out.print(", ");
        System.out.print(rs.getString("txt"));
        System.out.print(", ");
        System.out.println(rs.getTimestamp("updated"));
      }
      //-> 後処理
      rs.close();
      ps.close();
    }
  }
}
```

`java.sql.Connection` を取得するために、記事「[JDBC：Java共通資源の作成](/entry/java/jdbc/postgresql/java-project-common-class)」で作成したDB接続メソッド `Pg.connect()` を使っています。

処理内容としては、txt の値が `insert-test` に一致する行を全て表示する感じです。select した行の値は、`rs.getLong("id")`, `rs.getString("txt")` 等で取得してます。


## 手順2. 動作確認
事前に PostgreSQL を起動して、psql 等で `test` データベースにデータを投入しておきます。

```
test=> insert into memo (txt) values ('insert-test');
INSERT 0 1
```

クラス `SelectMain` を実行すると、select した行が表示されます。

```
25, insert-test, 2017-11-02 12:22:22.021218
```

DBに複数行存在している場合は、複数表示されます。

```
25, insert-test, 2017-11-02 12:22:22.021218
26, insert-test, 2017-11-04 10:39:57.312654
.....
```


## 補足. psql について
psql を使うと、PostgreSQL に接続して SQL を実行したりできます。使用法は以下のリンク先にも書いてあります。

[PostgreSQL：WindowsでSQL実行（psql）](/entry/postgresql/windows/exec-sql-using-psql)
