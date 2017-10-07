package ejs;

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
    ctx.addServlet(HelloServlet.class, "/hello");
    svr.start();
    svr.join();
  }
}
