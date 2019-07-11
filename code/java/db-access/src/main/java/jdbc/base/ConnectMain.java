package jdbc.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Driver.connect()) {
      //-> 現在日時を取得するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "select current_timestamp"
      );
      //-> SQLを実行してデータを取得
      ResultSet rs = ps.executeQuery();
      //-> データのカーソルを１つ進める
      rs.next();
      //-> データを表示
      System.out.print("Now ");
      System.out.println(rs.getTimestamp("now"));
      //-> 後処理
      rs.close();
      ps.close();
    }
  }
}
