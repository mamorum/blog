package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpMain {
  public static void main(String[] args) throws SQLException {
    //-> コネクションプールの設定
    HikariConfig conf = new HikariConfig();
    conf.setJdbcUrl("jdbc:postgresql://localhost/test");
    conf.setUsername("neko");
    conf.setPassword("cat");
    //-> データソースを生成、コネクションを取得
    try (HikariDataSource ds = new HikariDataSource(conf)) {
      try (Connection con = ds.getConnection()) {
        //-> 現在日時を取得するSQLを準備
        PreparedStatement ps = con.prepareStatement(
          "select current_timestamp"
        );
        //-> SQLを実行してデータを取得
        ResultSet rs = ps.executeQuery();
        //-> データのカーソルを１つ進める
        rs.next();
        //-> データを表示
        System.out.print("NOW ");
        System.out.println(rs.getTimestamp("now"));
        //-> 後処理
        rs.close();
        ps.close();
      }
    }
  }
}
