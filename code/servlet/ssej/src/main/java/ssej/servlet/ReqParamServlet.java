package ssej.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/param")
@SuppressWarnings("serial")
public class ReqParamServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("text/plain");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      req.getParameter("msg")
    );
  }
}
