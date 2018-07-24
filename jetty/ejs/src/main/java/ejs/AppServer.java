package ejs;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class AppServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    ctx.getSessionHandler().setMaxInactiveInterval(1800);
    ctx.addServlet(HelloServlet.class, "/hello");
    ctx.addFilter(
      LogFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST)
    );
    svr.start();
    svr.join();
  }
}
