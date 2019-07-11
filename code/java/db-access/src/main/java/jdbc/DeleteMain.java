package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.base.Driver;

public class DeleteMain {
  public static void main(String[] args)
    throws ClassNotFoundException, SQLException
  {
    try (Connection con = Driver.connect()) {
      //-> データを削除するSQLを準備
      PreparedStatement ps = con.prepareStatement(
        "delete from memo where txt = ?"
      );
      //-> SQLの?に文字列を設定
      ps.setString(1, "update-test");
      //-> SQLを実行して更新件数を取得
      int count = ps.executeUpdate();
      //-> 更新件数を表示
      System.out.print("DELETE ");
      System.out.println(count);
      //-> 後処理
      ps.close();
    }
  }
}
