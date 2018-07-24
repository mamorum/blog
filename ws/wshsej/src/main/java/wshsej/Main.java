package wshsej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.websocket.server.WebSocketHandler;

public class Main {
  public static void main(String[] args) throws Exception {
    // init handlers ->
    //// app
    AppHandler appHand = new AppHandler();
    //// rsc
    ResourceHandler rscHand = new ResourceHandler();
    rscHand.setBaseResource(
      Resource.newClassPathResource("/public")
    );
    //// ws
    ContextHandler echoHand = new ContextHandler("/echo");
    echoHand.setHandler(  //-> ws://.../echo/ (not .../echo)
      new WebSocketHandler.Simple(EchoSocket.class)
    );
    ContextHandler chatHand = new ContextHandler("/chat");
    chatHand.setHandler(  //-> ws://.../chat/ (not .../chat)
      new WebSocketHandler.Simple(ChatSocket.class)
    );
    // start server ->
    Server svr = new Server(8080);
    HandlerList hands = new HandlerList();
    hands.setHandlers(
      new Handler[] {appHand, echoHand, chatHand, rscHand}
    );
    svr.setHandler(hands);
    svr.start();
    svr.join();
  }
  private static class AppHandler extends SessionHandler {
    @Override public void doHandle(
        String target, Request base,
        HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException
    {
      res.setContentType("text/plain");
      res.setCharacterEncoding("utf-8");
      if ("/app".equals(target)) {
        res.getWriter().println("App Handler");
        base.setHandled(true);
      }
      // ws のパスとかぶるとダメ
//      else if ("/chat/".equals(target)) {
//        res.getWriter().println("App Handler -> /chat");
//        base.setHandled(true);
//      }
      super.doHandle(target, base, req, res);
    }
  }
}
