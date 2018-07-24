package ssjp.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/set")
@SuppressWarnings("serial")
public class SetSessionServlet extends HttpServlet {
  public void doGet(
    HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    //-> パラメータを取得してセッションに設定
    String val = req.getParameter("param");
    HttpSession ssn = req.getSession();
    ssn.setAttribute("ssn", val);
    //-> HTMLを返す
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body>設定完了</body></html>"
    );
  }
}
