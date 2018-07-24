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
