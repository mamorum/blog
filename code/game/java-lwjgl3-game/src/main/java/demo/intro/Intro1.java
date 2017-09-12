package demo.intro;

import static org.lwjgl.glfw.GLFW.*;

public class Intro1 {
  public static void main(String[] args) {
    if (!glfwInit()) System.exit(1);
    glfwTerminate();
    System.out.println("Fin.");
  }
}
