package wsssej;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class EchoSocket {
  @OnWebSocketMessage
  public void onWebSocketText(Session ssn, String msg) {
    System.out.println("msg: " + msg);
    // Echo message back, asynchronously
    ssn.getRemote().sendString(msg.toUpperCase(), null);
  }
}
