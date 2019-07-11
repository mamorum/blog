package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.base.Driver;

public class InsertMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Driver.connect()) {
      //-> データを1件登録するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "insert into memo (txt) values (?)"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "insert-test");
      //-> SQLを実行して更新件数を取得
      int count = ps.executeUpdate();
      //-> 更新件数を表示
      System.out.print("INSERT ");
      System.out.println(count);
      //-> 後処理
      ps.close();
    }
  }
}
