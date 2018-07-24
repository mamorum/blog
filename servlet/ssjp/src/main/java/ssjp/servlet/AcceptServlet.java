package ssjp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/accept")
@SuppressWarnings("serial")
public class AcceptServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Get.");
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Post.");
  }
  public void doPut(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Put.");
  }
  public void doDelete(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Delete.");
  }
}