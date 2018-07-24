package ssjp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/req/accept")
public class AcceptFilter implements Filter {
  @Override public void doFilter(
    ServletRequest rq, ServletResponse rs, FilterChain fc)
  throws IOException, ServletException {
    System.out.println("Before servlet doGet.");
    fc.doFilter(rq, rs); // 次のフィルターorサーブレットに処理を渡す。
    System.out.println("After servlet doGet.");
  }
  @Override public void init(FilterConfig c) throws ServletException {}
  @Override public void destroy() {}
}
