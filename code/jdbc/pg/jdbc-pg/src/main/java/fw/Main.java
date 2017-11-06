package fw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import basic.Pg;

public class Main {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection c = Pg.connect()) {
      Sql.query(
        c, "select * from memo where id = ?",
        (ps) -> {
          ps.setLong(1, 1);
        },
        (i, rs) -> {
          System.out.print(rs.getLong("id"));
          System.out.print(", ");
          System.out.print(rs.getString("txt"));
          System.out.print(", ");
          System.out.println(rs.getTimestamp("updated"));
        }
      );
    }
  }
}
