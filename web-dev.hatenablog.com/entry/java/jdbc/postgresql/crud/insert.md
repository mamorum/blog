---
Title: JDBC：INSERT文の実行
Category:
- Java
Date: 2017-11-02T16:12:38+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdbc/postgresql/crud/insert
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812313768173
---

JDBC を使って、Java からデータベースに対して INSERT文を実行する方法を書いていきます。データベースは、RDBMS の PostgreSQL を使いました。


## 前提
この記事のサンプルプログラムを実行するには、以下記事のDB環境や資源（プロジェクト、Javaクラス、等）が必要になります。

- [DB環境の準備](/entry/java/jdbc/postgresql/db-env)
- [Java共通資源の作成](/entry/java/jdbc/postgresql/java-project-common-class)


## 手順1. INSERT実行クラスの作成
Prepared文（PreparedStatement）で SQL を実行するクラスを作成します。

`jdbc-pg/src/main/java/basic/InsertMain.java`

```java
package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Pg.connect()) {
      //-> データを1件登録するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "insert into memo (txt) values (?)"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "insert-test");
      //-> SQLを実行して更新件数を取得
      int count = ps.executeUpdate();
      //-> 更新件数を表示
      System.out.print("INSERT ");
      System.out.println(count);
      //-> 後処理
      ps.close();
    }
  }
}
```

`java.sql.Connection` を取得するために、記事「[JDBC：Java共通資源の作成](/entry/java/jdbc/postgresql/java-project-common-class)」で作成したDB接続メソッド `Pg.connect()` を使っています。


## 手順2. 動作確認
事前に PostgreSQL を起動しておいて、クラス `InsertMain` を実行します。正常終了すると標準出力に、

```
INSERT 1
```

と表示されます。

psql 等で `test` データベースに接続して確認することもできます。

```
test=> select id, txt from memo where txt = 'insert-test';
 id |     txt
----+-------------
 25 | insert-test
(1 行)
```
