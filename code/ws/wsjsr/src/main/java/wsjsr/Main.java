package wsjsr;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

public class Main {
  public static void main(String[] args) {
    Server server = new Server(8080);
//    ServerConnector connector = new ServerConnector(server);
//    connector.setPort(8080);
//    server.addConnector(connector);

    // Setup the basic application "context" for this application at "/"
    // This is also known as the handler tree (in jetty speak)
//    ServletContextHandler ctxt
//      = new ServletContextHandler(ServletContextHandler.SESSIONS);
    WebAppContext ctxt = new WebAppContext();
    ctxt.setContextPath("/");
    ctxt.setBaseResource(Resource.newClassPathResource("/public"));
    server.setHandler(ctxt);

    try {
      // Initialize javax.websocket layer
      ServerContainer ws
        = WebSocketServerContainerInitializer.configureContext(ctxt);
      // Add WebSocket endpoint to javax.websocket layer
      ws.addEndpoint(EchoSocket.class);
      ws.addEndpoint(ChatSocket.class);
      server.start();
      server.join();
    } catch (Throwable t) {
      t.printStackTrace(System.err);
    }
  }
}
