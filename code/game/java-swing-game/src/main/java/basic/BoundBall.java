package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoundBall extends JFrame {
  public static void main(String[] args) {
    MainPanel p = new MainPanel();
    p.setPreferredSize(new Dimension(240, 240)); // (width, height)
    Thread th = new Thread(p);
    th.start();
    BoundBall f = new BoundBall();
    f.setTitle("ボールを動かす");
    f.setResizable(false);
    f.getContentPane().add(p);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  static class MainPanel extends JPanel implements Runnable {
    private static final int
      lenX=240, lenY=240, lenBall=10,
      boundWidth=lenX-lenBall, boundHeight=lenY-lenBall;
    private int x=0, y=0;  // ボールの位置（円左上の座標）
    private int vx=2, vy=1;  // ボールの速度
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 青いボールを描く
      g.setColor(Color.RED);
      g.fillOval(x, y, lenBall, lenBall);
    }
    @Override public void run() {
      while (true) {
        x += vx;
        y += vy;
        if (x < 0 || x > boundWidth) {
          vx = -vx; // 左or右に当たったらx方向速度の符号を反転
        }
        if (y < 0 || y > boundHeight) {
          vy = -vy; // 上or下に当たったらy方向速度の符号を反転
        }
        repaint();
        try { Thread.sleep(17); }  // ≒ 58.823...fps
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
