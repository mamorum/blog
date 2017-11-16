package sandbox;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface Param {
  void bind(PreparedStatement ps) throws SQLException;
}
