package sandbox;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface Result {
  void accept(int index, ResultSet ps) throws SQLException;
}
