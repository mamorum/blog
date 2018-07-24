package ejs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;

public class FileServer {
  public static void main(String[] args) throws Exception {
    Server svr = new Server(8080);
    ServletContextHandler ctx = new ServletContextHandler(
      ServletContextHandler.SESSIONS
    );
    svr.setHandler(ctx);
    ctx.setContextPath("/");
    //-> 静的コンテンツの場所をクラスパスで指定
    ctx.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    ctx.addServlet(DefaultServlet.class, "/");
    svr.start();
    svr.join();
  }
}
