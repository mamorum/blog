package game.basic;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class DrawFigure {
  public static void main(String[] args) {
    wind.setTitle("Hello World");
    wind.setSize(300, 300);
    wind.addWindowListener(wl);
    wind.addGLEventListener(el);
    anim.add(wind);
    anim.start();
    wind.setVisible(true);
  }
  // Window, Animator ->
  static GLWindow wind = GLWindow.create(
    new GLCapabilities(GLProfile.get(GLProfile.GL2))
  );
  static FPSAnimator anim = new FPSAnimator(60);
  // Listeners ->
  static WindowListener wl = new WindowAdapter() {
    @Override public void windowDestroyed(WindowEvent e) {
      System.exit(0);
    }
  };
  static GLEventListener el = new GLEventListener() {
    @Override public void init(GLAutoDrawable d) {
      // ウィンドウの色を指定
      GL2 gl = d.getGL().getGL2();
      gl.glClearColor(0.9f, 0.9f, 0.9f, 1.0f);
    }
    @Override public void reshape(
      GLAutoDrawable d, int x, int y, int xLen, int yLen) {
    }
    @Override public void display(GLAutoDrawable d) {
      GL2 gl = d.getGL().getGL2();
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      //-> 線を描く
      //// glBegin - glEnd の間で図形の頂点を指定
      //// glVertex2f で二次元の座標値を設定
      //// ウィンドウの中心座標は (0.0f, 0.0f)
      ////// 折線で四角を書く（始点と終点も結ばれる）
      gl.glBegin(GL2.GL_LINE_LOOP);
      gl.glColor3f(1.0f, 0.0f, 0.0f); // 色指定
      gl.glVertex2f(-0.9f, 0.9f);
      gl.glVertex2f(-0.1f, 0.9f);
      gl.glVertex2f(-0.1f, 0.1f);
      gl.glVertex2f(-0.9f, 0.1f);
      gl.glEnd();
      ////// 円を書く
      gl.glBegin(GL2.GL_TRIANGLE_FAN);
      gl.glColor3f(0.0f, 0.0f, 1.0f); // 色指定
      int triangles = 50;
      double twoPi = 2.0 * 3.14159;
      double radius = 0.4;
      double delta = twoPi / triangles;
      double x = 0.5;
      double y = 0.5;
      gl.glVertex2d(x, y); // origin
      for(int i = 0; i <= triangles; i++)
        gl.glVertex2d(
           x + (radius * Math.cos(i*delta)),
           y + (radius * Math.sin(i*delta))
        );
      gl.glEnd();
    }
    @Override public void dispose(GLAutoDrawable d) {
      anim.stop();
    }
  };
}