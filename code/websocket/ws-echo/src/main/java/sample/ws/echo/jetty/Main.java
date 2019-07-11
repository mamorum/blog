package sample.ws.echo.jetty;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import sample.ws.echo.EchoSocket;

public class Main {
  public static void main(String[] args) throws Exception {
    //-> setup context
    WebAppContext ctxt = new WebAppContext();
    ctxt.setContextPath("/ws-echo");
    //-> setup static file
    ctxt.setBaseResource(
      Resource.newResource("src/main/webapp")
    );
    //-> setup server
    Server svr = new Server(8080);
    svr.setHandler(ctxt);
    //-> setup websocket
    ServerContainer ws
      = WebSocketServerContainerInitializer.configureContext(ctxt);
    ws.addEndpoint(EchoSocket.class);
    //-> start server
    svr.start();
    svr.join();
  }
}
