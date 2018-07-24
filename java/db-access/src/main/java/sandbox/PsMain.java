package sandbox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.base.Driver;

public class PsMain {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    try (Connection con = Driver.connect()) {
      long id = insert(con, "insert");
      select(con, id);
      update(con, id, "update");
      select(con, id);
      delete(con, id);
      selectAll(con);
    }
  }
  private static void delete(Connection con, long id) throws SQLException {
    PreparedStatement ps = con.prepareStatement(
      "delete from memo where id = ?"
    );
    ps.setLong(1, id);
    int row = ps.executeUpdate();
    System.out.print(row);
    System.out.print(" row deleted [id=");
    System.out.print(id);
    System.out.println("]");
    System.out.println();
  }
  private static void select(Connection con, long id) throws SQLException {
    PreparedStatement ps = con.prepareStatement(
      "select id, txt, updated, created from memo where id = ?"
    );
    ps.setLong(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
    System.out.print(rs.getLong("id"));
    System.out.print(", ");
    System.out.print(rs.getString("txt"));
    System.out.print(", ");
    System.out.print(rs.getTimestamp("updated"));
    System.out.print(", ");
    System.out.println(rs.getTimestamp("created"));
    System.out.println();
  }
  private static void update(Connection con, long id, String txt) throws SQLException {
    PreparedStatement ps = con.prepareStatement(
      "update memo set txt = ?, updated = current_timestamp where id = ?"
    );
    ps.setString(1, txt);
    ps.setLong(2, id);
    int row = ps.executeUpdate();
    System.out.print(row);
    System.out.print(" row updated [id=");
    System.out.print(id);
    System.out.println("]");
    System.out.println();
  }
  private static long insert(Connection con, String txt) throws SQLException {
    PreparedStatement ps = con.prepareStatement(
      "insert into memo (txt) values (?) returning id"
    );
    ps.setString(1, txt);
    ResultSet rs = ps.executeQuery();
    rs.next();
    long id = rs.getLong("id");
    System.out.print("inserted [id=");
    System.out.print(id);
    System.out.println("]");
    System.out.println();
    return id;
  }
  static void selectAll(Connection con) throws SQLException {
    PreparedStatement ps = con.prepareStatement(
      "select * from memo order by updated"
    );
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      System.out.print(rs.getLong("id"));
      System.out.print(", ");
      System.out.print(rs.getString("txt"));
      System.out.print(", ");
      System.out.println(rs.getTimestamp("updated"));
    }
    System.out.println();
    rs.close();
    ps.close();
  }
}
