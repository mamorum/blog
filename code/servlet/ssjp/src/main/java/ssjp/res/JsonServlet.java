package ssjp.res;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/res/json")
@SuppressWarnings("serial")
public class JsonServlet extends HttpServlet {
  private static final Gson gson = new Gson();
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    res.setContentType("application/json");
    res.setCharacterEncoding("utf-8");
    String name = req.getParameter("name");
    String msg = (
      new StringBuilder("Hello, ")
    ).append(name).toString();
    res.getWriter().println(gson.toJson(
      Collections.singletonMap("msg", msg)
    ));
  }
}
