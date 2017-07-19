package ssej.servlet.res;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/res/html")
@SuppressWarnings("serial")
public class HtmlServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/html");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      "<html><body><p>Hello!</p></body></html>"
    );
  }
}
