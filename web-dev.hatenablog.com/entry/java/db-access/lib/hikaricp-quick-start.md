---
Title: Java：HikariCPのコネクションプールを使う
Category:
- Java
Date: 2017-11-21T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/db-access/lib/hikaricp-quick-start
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812318013162
---

[HikariCP](http://brettwooldridge.github.io/HikariCP/) でコネクションプールを生成して、PostgreSQL に対して簡単な SQL を実行する方法を書いていきます。

コネクションプールを使うと、コネクション（DBへの接続）を原則切断せずに保持することになります。DBを操作する前と後の処理（接続と切断）がなくなるので、パフォーマンスが向上すると言われてます。


## 手順1. 依存性の追加
記事「[Java共通資源の作成](/entry/java/db-access/postgresql/java-project-common-class)」で作成した `pom.xml` に、HikariCP の依存性を追加します。

`db-access/pom.xml（追加部分）`

```
    <dependency>
      <groupId>com.zaxxer</groupId>
      <artifactId>HikariCP</artifactId>
      <version>2.7.3</version>
    </dependency>
```

`dependencies` タグの下に追加すれば大丈夫です。


## 手順2. プログラムの作成
HikariCP でコネクションプールを生成して、SQL を実行する Mainクラスを作成します。

`db-access/src/main/java/lib/HikariCpMain.java`

```java
package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpMain {
  public static void main(String[] args) throws SQLException {
    //-> コネクションプールの設定
    HikariConfig conf = new HikariConfig();
    conf.setJdbcUrl("jdbc:postgresql://localhost/test");
    conf.setUsername("neko");
    conf.setPassword("cat");
    //-> データソースを生成、コネクションを取得
    try (HikariDataSource ds = new HikariDataSource(conf)) {
      try (Connection con = ds.getConnection()) {
        //-> 現在日時を取得するSQLを準備
        PreparedStatement ps = con.prepareStatement(
          "select current_timestamp"
        );
        //-> SQLを実行してデータを取得
        ResultSet rs = ps.executeQuery();
        //-> データのカーソルを１つ進める
        rs.next();
        //-> データを表示
        System.out.print("NOW ");
        System.out.println(rs.getTimestamp("now"));
        //-> 後処理
        rs.close();
        ps.close();
      }
    }
  }
}
```

多くの場合、コネクションプールは `javax.sql.DataSource`（データソース）を実装するクラスになります。SQL を実行する前には、データソースから `java.sql.Connection`（コネクション）を取得します。

あと、コネクションプールを使ってても、プログラム上は `Connection#close()` を呼ぶことになっていています。その際、内部ではDBへの接続を切らずにコネクションをプールさせます。その後、また別の処理（スレッドなど）にコネクションが貸し出されます。

今回は `Connection#close()` を直接呼び出してませんが、`try (Connection con = ds.getConnection()) { ... }` から抜けたタイミングでクローズされます。try-with-resources 文といって、詳細は以下のリンク先に記載されています。

[Oracle - try-with-resources 文](https://docs.oracle.com/javase/jp/7/technotes/guides/language/try-with-resources.html)


## 手順3. 動作確認
事前に PostgreSQL を起動して、データベースとユーザを作成しておきます。作成方法は「[DB環境の準備](/entry/java/db-access/postgresql/db-env)」に書いてますので、必要に応じて参照して頂けると嬉しいです。

それから上の `HikariCpMain` を実行すると、


```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
NOW 2017-11-14 11:00:13.956448
```

といった文字列が出力されます。

上から３行のメッセージ（SLF4J...）は、HikariCP が SLF4J を使っている関係で出力されています。


## 補足
この記事のプログラムは、DBに一度だけしかアクセスしないので、あまりコネクションプールを使う理由はないです（あくまでサンプル）。

多くのユーザー（やスレッド）が何度も繰り返しDBにアクセスする場合は、コネクションプールを使うことが多いと思います。例えばサーブレット環境などはそんな感じで、Tomcat のドキュメントにもコネクションプールのことが書いてあったりします。

[JNDI Datasource HOW-TO - Tomcat](https://tomcat.apache.org/tomcat-8.5-doc/jndi-datasource-examples-howto.html)
