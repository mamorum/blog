package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MoveBall extends JFrame {
  public static void main(String[] args) {
    MainPanel p = new MainPanel();
    p.setPreferredSize(new Dimension(240, 240)); // (width, height)
    Thread th = new Thread(p);
    th.start();
    MoveBall f = new MoveBall();
    f.setTitle("ボールを動かす");
    f.setResizable(false);
    f.getContentPane().add(p);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  static class MainPanel extends JPanel implements Runnable {
    private static final int ballSize=10;
    private int x=1, y=1;  // ボールの位置（円中心の座標）
    private int vx=1, vy=1;  // ボールの速度
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 青いボールを描く
      g.setColor(Color.BLUE);
      g.fillOval(x - ballSize / 2, y - ballSize / 2, ballSize, ballSize);
    }
    @Override public void run() {
      while (true) {
        x += vx;
        y += vy;
        repaint();
        try { Thread.sleep(17); }  // ≒ 58.823...fps
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
