---
Title: JDBC：UPDATE文の実行
Category:
- Java
Date: 2017-11-06T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/jdbc/crud/update
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812314576010
---

JDBC を使って、Java からデータベースに対して UPDATE文を実行する方法を書いていきます。データベースは、RDBMS の PostgreSQL を使いました。


## 前提
この記事のサンプルプログラムを実行するには、以下記事のDB環境や資源（プロジェクト、Javaクラス、等）が必要になります。

- [DB環境の準備](/entry/java/db-access/postgresql/db-env)
- [Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)


## 手順1. UPDATE実行クラスの作成
Prepared文（PreparedStatement）で SQL を実行するクラスを作成します。

`db-access/src/main/java/jdbc/UpdateMain.java`

```java
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.base.Driver;

public class UpdateMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Driver.connect()) {
      //-> データを更新するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "update memo set txt = ? where txt = ?"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "update-test");
      ps.setString(2, "insert-test");
      //-> SQLを実行して更新件数を取得
      int count = ps.executeUpdate();
      //-> 更新件数を表示
      System.out.print("UPDATE ");
      System.out.println(count);
      //-> 後処理
      ps.close();
    }
  }
}
```

`java.sql.Connection` を取得するために、記事「[Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)」で作成したDB接続メソッド `Driver.connect()` を使っています。

txt の値が `insert-test` に一致する行を全て更新する感じです。更新後の txt の値は `update-test` になります。


## 手順2. 動作確認
事前に PostgreSQL を起動して、psql 等で `test` データベースにデータを投入しておきます。

```
test=> insert into memo (txt) values ('insert-test');
INSERT 0 1
```

クラス `UpdateMain` を実行すると、更新した行数が表示されます。

```
UPDATE 1
```

psql で更新されたことを確認します。

```
test=> select id, txt from memo where txt = 'update-test';
 id |     txt
----+-------------
 29 | update-test
(1 行)
```


## 補足. psql について
psql を使うと、PostgreSQL に接続して SQL を実行したりできます。使用法は以下のリンク先にも書いてあります。

[PostgreSQL：WindowsでSQL実行（psql）](/entry/postgresql/windows/exec-sql-using-psql)
