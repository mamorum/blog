package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawFigure extends JFrame {
  public static void main(String[] args) {
    DrawFigure frame = new DrawFigure();
    frame.setTitle("図形を描く");
    frame.getContentPane().add(new MainPanel());
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  static class MainPanel extends JPanel {
    private static final int WIDTH=480, HEIGHT=480;
    public MainPanel() {
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 線を描く
      g.drawLine(10, 10, 100, 10);
      // 赤に変更
      g.setColor(Color.RED);
      // 四角形を描く
      g.drawRect(10, 20, 40, 40);
      g.fillRect(60, 20, 40, 40);
      // 青に変更
      g.setColor(Color.BLUE);
      // 円を描く
      g.drawOval(10, 70, 40, 40);
      g.fillOval(60, 70, 40, 40);
    }
  }
}
