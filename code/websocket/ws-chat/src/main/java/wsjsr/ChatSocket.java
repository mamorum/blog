package wsjsr;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatSocket {
  static AtomicInteger id = new AtomicInteger(0);
  static Map<Session, Integer> ssn2id = new ConcurrentHashMap<>();
  @OnOpen
  public void open(Session ssn) {
    System.err.println("ChatSocket: " + this.toString());
    System.out.println("Socket Connected: " + ssn.getId());
    Integer i = id.incrementAndGet();
    ssn2id.put(ssn, i);
    ssn2id.keySet().forEach(s -> {
      s.getAsyncRemote().sendText("[ID:" + i + "] Loggined.");
    });
//    ssn.getOpenSessions().forEach(s -> {
//      s.getAsyncRemote().sendText("[ID:" + i + "] Loggined.");
//    });
  }
  @OnMessage
  public void msg(String msg, Session ssn) {
    System.out.println("Received TEXT message: " + msg);
    Integer i = ssn2id.get(ssn);
    ssn2id.keySet().forEach(s -> {
      s.getAsyncRemote().sendText("[ID:" + i + "] \"" + msg + "\"");
    });
//    ssn.getOpenSessions().forEach(s -> {
//      s.getAsyncRemote().sendText("[ID:" + i + "] \"" + msg + "\"");
//    });
  }
  @OnClose
  public void close(Session ssn, CloseReason rsn) {
    System.out.println("Socket Closed: " + ssn.getId());
    Integer i = ssn2id.remove(ssn);
    ssn2id.keySet().forEach(s -> {
      s.getAsyncRemote().sendText("[ID:" + i + "] Logout.");
    });
  }

  @OnError
  public void onWebSocketError(Throwable cause) {
    cause.printStackTrace(System.err);
  }
}
