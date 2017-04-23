package sprkgs;

import static spark.Spark.*;

import java.util.Collections;
import java.util.Map;

import com.google.gson.Gson;

public class Main {
  public static void main(String[] args) {
    staticFiles.location("/public");
    MustacheRoute.register();
    get("/hello", (req, res) -> "Hello World");
    get("/json", (req, res) -> {
      res.type("application/json;charset=UTF-8");
      return msg;
    }, gson::toJson);
  }
  static final Map<String, String> msg
    = Collections.singletonMap("msg", "Hello");

  static final Gson gson = new Gson();
}
