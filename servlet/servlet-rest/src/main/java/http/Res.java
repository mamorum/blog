package http;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Res {
  static Gson gson = new Gson();
  static void json(HttpServletResponse res, Object toJson)
    throws IOException
  {
    res.setContentType("application/json");
    res.setCharacterEncoding("utf-8");
    res.getWriter().println(
      gson.toJson(toJson)
    );
  }
}
