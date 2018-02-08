package wsjsr;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//import util.HTMLFilter;

@ServerEndpoint(value = "/websocket/chat")
public class TomChat {

//  private static final Log log = LogFactory.getLog(ChatAnnotation.class);

  private static final String GUEST_PREFIX = "Guest";
  private static final AtomicInteger connectionIds = new AtomicInteger(0);
  private static final Set<TomChat> connections = new CopyOnWriteArraySet<>();

  private final String nickname;
  private Session session;

  public TomChat() {
    nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
  }

  @OnOpen
  public void start(Session session) {
    this.session = session;
    connections.add(this);
    String message = String.format("* %s %s", nickname, "has joined.");
    broadcast(message);
  }

  @OnClose
  public void end() {
    connections.remove(this);
    String message = String.format("* %s %s", nickname, "has disconnected.");
    broadcast(message);
  }

  @OnMessage
  public void incoming(String message) {
    // Never trust the client
//    String filteredMessage = String.format("%s: %s", nickname, HTMLFilter.filter(message.toString()));
    String filteredMessage = String.format("%s: %s", nickname, message.toString());
    broadcast(filteredMessage);
  }

  @OnError
  public void onError(Throwable t) throws Throwable {
//    log.error("Chat Error: " + t.toString(), t);
  }

  private static void broadcast(String msg) {
    for (TomChat client : connections) {
      try {
        synchronized (client) {
          client.session.getBasicRemote().sendText(msg);
        }
      } catch (IOException e) {
//        log.debug("Chat Error: Failed to send message to client", e);
        connections.remove(client);
        try {
          client.session.close();
        } catch (IOException e1) {
          // Ignore
        }
        String message = String.format("* %s %s", client.nickname, "has been disconnected.");
        broadcast(message);
      }
    }
  }
}
