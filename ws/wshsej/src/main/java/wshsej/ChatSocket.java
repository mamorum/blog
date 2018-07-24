package wshsej;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ChatSocket {
  @OnWebSocketConnect
  public void onConnect(Session user) throws Exception {
      String uname = "User" + nextUserNumber++;
      ssn2uname.put(user, uname);
      broadcastMessage("Server", (uname + " joined the chat"));
  }
  @OnWebSocketMessage
  public void onMessage(Session user, String msg) {
      broadcastMessage(ssn2uname.get(user), msg);
  }
  @OnWebSocketClose
  public void onClose(Session user, int statusCode, String reason) {
      String uname = ssn2uname.get(user);
      ssn2uname.remove(user);
      broadcastMessage("Server", (uname + " left the chat"));
  }

  // this map is shared between sessions and threads, so it needs to be thread-safe (http://stackoverflow.com/a/2688817)
  static Map<Session, String> ssn2uname = new ConcurrentHashMap<>();
  static int nextUserNumber = 1; //Used for creating the next username

  public static void broadcastMessage(String uname, String msg) {
    for (Session ssn: ssn2uname.keySet()) {
      if (ssn.isOpen()) {
        try {
          ssn.getRemote().sendString(
            uname + " says " + msg + ", " +
            "users " + ssn2uname.values()
          );
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
