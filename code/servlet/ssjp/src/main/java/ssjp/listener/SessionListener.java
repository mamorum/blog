package ssjp.listener;

import java.time.LocalDateTime;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
  @Override public void sessionCreated(HttpSessionEvent se) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Session created ");
    System.out.println(se.getSession().getId());
  }
  @Override public void sessionDestroyed(HttpSessionEvent se) {
    System.out.print(LocalDateTime.now());
    System.out.print(" Session destroyed ");
    System.out.println(se.getSession().getId());
  }
}
