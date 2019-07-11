package wsssej;

import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

@SuppressWarnings("serial")
@WebServlet("/echo")
public class EchoServlet extends WebSocketServlet {
  @Override
  public void configure(WebSocketServletFactory fac) {
    fac.register(EchoSocket.class);
  }
}
