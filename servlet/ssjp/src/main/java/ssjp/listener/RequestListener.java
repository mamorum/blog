package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
  @Override public void requestInitialized(ServletRequestEvent sre) {
    HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
    System.out.print(LocalDateTime.now());
    System.out.print(" Request initialized ");
    System.out.println(req.getRequestURI());
  }
  @Override public void requestDestroyed(ServletRequestEvent sre) {
    HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
    System.out.print(LocalDateTime.now());
    System.out.print(" Request destroyed ");
    System.out.println(req.getRequestURI());
  }
}
