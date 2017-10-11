package ejsvr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloWorldServer {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    server.setHandler(new HwHandler());
    server.start();
    server.join();
  }
  static class HwHandler extends AbstractHandler {
    @Override public void handle(
      String target, Request baseRequest,
      HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html; charset=utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<h1>Hello World</h1>");
      baseRequest.setHandled(true);
    }
  }
}