package gssb.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MstController {

  @RequestMapping("/hello-mst")
  public String hello(
    @RequestParam(defaultValue="World") String name,
    Map<String, Object> model
  ) {
    model.put("name", name);
    model.put("date", new Date());
    return "hello-mst";
  }
}
