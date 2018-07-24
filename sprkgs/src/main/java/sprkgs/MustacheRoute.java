package sprkgs;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;

import com.samskivert.mustache.Mustache;

public class MustacheRoute {
  static void register() {
    get("/mst", (req, res) -> {
      Map<String, String> data = Collections.singletonMap(
        "name", req.queryParams("name")
      ); // throws MustacheException, if map value is null.
      return render("/tmpl/hello.mst", data);
    });
  }
  static String render(String path, Object data)
    throws UnsupportedEncodingException
  {
    return Mustache.compiler().compile(
      new BufferedReader(new InputStreamReader(
          MustacheRoute.class.getResourceAsStream(path), "utf-8")
      )
    ).execute(data);
  }
}
