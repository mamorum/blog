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
