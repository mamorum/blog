package ejs;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
  @Override public void doFilter(
    ServletRequest rq, ServletResponse rs, FilterChain chain)
  throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) rq;
    String log = (new StringBuilder()
      .append(LocalDateTime.now())
      .append(" ").append(req.getMethod())
      .append(" ").append(req.getRequestURI())
    ).toString();
    System.out.println(log);
    chain.doFilter(rq, rs);
  }
  @Override public void init(FilterConfig c) throws ServletException {}
  @Override public void destroy() {}
}
