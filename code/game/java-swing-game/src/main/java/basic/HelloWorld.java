package basic;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HelloWorld extends JFrame {
  public HelloWorld() {
    setTitle("Hello Worldを表示する");
    // メインパネルを作成してフレームに追加
    MainPanel panel = new MainPanel();
    Container contentPane = getContentPane();
    contentPane.add(panel);
    // （下）フレーム -> ContentPane -> パネル（上）
    // パネルサイズに合わせてフレームサイズを自動設定
    pack();
  }
  public static void main(String[] args) {
    HelloWorld frame = new HelloWorld();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  static class MainPanel extends JPanel {
    // パネルサイズ
    private static final int WIDTH=480, HEIGHT=480;

    public MainPanel() {
      // パネルの推奨サイズを設定、pack()するときに必要
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      // 変数などの初期化
    }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 盤面を描いたり、フィールドを描いたりする
    }
  }
}
