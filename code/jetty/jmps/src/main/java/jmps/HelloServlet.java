package jmps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
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