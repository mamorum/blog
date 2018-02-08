package sample.ws.echo;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//-> パスが "/echo" のリクエストを処理するクラス
@ServerEndpoint("/echo")
public class EchoSocket {
  //-> クライアントが接続してきたときの処理
  @OnOpen public void open(Session ssn) {
    System.out.println("@OnOpen: " + ssn.getId());
  }
  //-> クライアントがメッセージを送ってきたときの処理
  @OnMessage public String msg(String msg) {
    System.out.println("@OnMessage: " + msg);
    return msg;
  }
  //-> クライアントが接続を閉じてきたときの処理
  @OnClose public void close(CloseReason rsn) {
    System.out.println("@OnClose: " + rsn);
  }
  //-> エラーが発生したときの処理
  @OnError public void error(Throwable t) {
    System.err.println("@OnError:");
    t.printStackTrace(System.err);
  }
}
