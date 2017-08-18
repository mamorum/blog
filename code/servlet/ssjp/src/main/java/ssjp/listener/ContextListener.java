package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
  @Override public void contextInitialized(ServletContextEvent sce) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Context initialized [path=");
    System.out.print(path(sce.getServletContext()));
    System.out.println("]");
  }
  @Override public void contextDestroyed(ServletContextEvent sce) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Context destroyed [path=");
    System.out.print(path(sce.getServletContext()));
    System.out.println("]");
  }
  private String path(ServletContext sc) {
    String path = sc.getContextPath();
    if (path == null | "".equals(path)) return "/";
    else return path;
  }
}
