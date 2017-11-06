package fw;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Sql {
  public static int exec(Connection c, String sql) throws SQLException {
    PreparedStatement ps = c.prepareStatement(sql);
    return ps.executeUpdate();
  }
  public static int exec(
    Connection c, String sql, Consumer<PreparedStatement> param
  ) throws SQLException {
    PreparedStatement ps = c.prepareStatement(sql);
    param.accept(ps);
    return ps.executeUpdate();
  }
  public static ResultSet query(Connection c, String sql, Param param) {
    try {
      PreparedStatement p = c.prepareStatement(sql);
      param.bind(p);
      return p.executeQuery();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static void query(Connection c, String sql, Param p, Result r) {
    try (PreparedStatement ps = c.prepareStatement(sql)) {
      p.bind(ps);
      try (ResultSet rs = ps.executeQuery()) {
        for (int i=0; rs.next(); i++) {
          r.accept(i, rs);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
