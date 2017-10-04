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
import com.jogamp.opengl.util.Animator;

public class HelloWorld {
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
  static Animator anim = new Animator();
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
      gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
    }
    @Override public void reshape(
      GLAutoDrawable d, int x, int y, int xLen, int yLen) {
    }
    @Override public void display(GLAutoDrawable d) {
      GL2 gl = d.getGL().getGL2();
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }
    @Override public void dispose(GLAutoDrawable d) {
      anim.stop();
    }
  };
}