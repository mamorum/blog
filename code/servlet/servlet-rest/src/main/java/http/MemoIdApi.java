package http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MemoRepository;

@WebServlet("/memo/*") //-> "/memo/:id"
@SuppressWarnings("serial")
public class MemoIdApi extends HttpServlet {
  public void doPut(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    MemoRepository.update(
      id(req), req.getParameter("txt")
    );
  }
  public void doDelete(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    MemoRepository.delete(
      id(req)
    );
  }
  //-> Get id from URI. (ex."/memo/1" -> return 1)
  private Long id(HttpServletRequest from) {
    String[] uri = from.getRequestURI().split("/");
    if (uri.length != 3) return null;
    return Long.valueOf(uri[2]);
  }
}
