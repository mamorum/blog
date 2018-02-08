package wsjsr;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoSocket {
  @OnOpen
  public void onWebSocketConnect(Session ssn) {
    System.out.println("Socket Connected: " + ssn.getId());
  }
  @OnMessage
  public String echo(String msg) {
    System.out.println("Received TEXT message: " + msg);
    return msg;
  }
  @OnClose
  public void onWebSocketClose(CloseReason rsn) {
    System.out.println("Socket Closed: " + rsn);
  }
//  @OnError
//  public void onWebSocketError(Throwable cause) {
//    cause.printStackTrace(System.err);
//  }
}
