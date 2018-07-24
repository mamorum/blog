package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.base.Driver;

public class SelectMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Driver.connect()) {
      //-> データを取得するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "select id, txt, updated from memo where txt = ?"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "insert-test");
      //-> SQLを実行してデータを取得
      ResultSet rs = ps.executeQuery();
      //-> データを表示
      while (rs.next()) {
        System.out.print(rs.getLong("id"));
        System.out.print(", ");
        System.out.print(rs.getString("txt"));
        System.out.print(", ");
        System.out.println(rs.getTimestamp("updated"));
      }
      //-> 後処理
      rs.close();
      ps.close();
    }
  }
}
