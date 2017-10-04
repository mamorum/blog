package tutorial.ja;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.Animator;

public class FirstStepNewt implements GLEventListener { //(1)
  public static void main(String[] args) {
    new FirstStepNewt();
  }

  Animator animator;
  public FirstStepNewt() {
    GLCapabilities caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));//(2)
    GLWindow glWindow = GLWindow.create(caps); //(3)
    glWindow.setTitle("First demo (Newt)"); //(4)
    glWindow.setSize(300, 300); //(5)

    glWindow.addWindowListener(new WindowAdapter() { //(6)
      @Override
      public void windowDestroyed(WindowEvent evt) {
        System.exit(0);
      }
    });
    glWindow.addGLEventListener(this); //(7)

    animator = new Animator(); //(8)
    animator.add(glWindow);
    animator.start();
    glWindow.setVisible(true); //(10)
  }

  @Override
  public void init(GLAutoDrawable drawable) {
    // ウィンドウを青く塗りつぶす（色を指定する）
    GL2 gl = drawable.getGL().getGL2();
    gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

  @Override
  public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
  }

  @Override
  public void dispose(GLAutoDrawable drawable) {
    if(animator != null) animator.stop();
  }
}