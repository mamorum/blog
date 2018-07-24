package http;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MemoRepository;
import model.Memo;

@WebServlet("/memo")
@SuppressWarnings("serial")
public class MemoApi extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    List<Memo> memo = MemoRepository.readAll();
    Res.json(
      res, Collections.singletonMap("memo", memo)
    );
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    Memo memo = MemoRepository.create(
      req.getParameter("txt")
    );
    Res.json(
      res, Collections.singletonMap("memo", memo)
    );
  }
}
