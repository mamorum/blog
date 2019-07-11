package ssjp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/get")
@SuppressWarnings("serial")
public class GetSessionServlet extends HttpServlet {
  public void doGet(
    HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    //-> セッションから値を取得してHTMLを返す
    HttpSession ssn = req.getSession(false);
    if (ssn == null) {
      html("セッションなし", res);
    } else {
      String val = (String) ssn.getAttribute("ssn");
      html(val, res);
    }
  }
  private void html(
    String msg, HttpServletResponse res)
  throws IOException {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    PrintWriter o = res.getWriter();
    o.print("<html><body>");
    o.print(msg);
    o.println("</body></html>");
  }
}
