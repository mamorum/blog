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
