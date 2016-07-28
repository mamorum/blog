package gssb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // JSON を返すコントローラに付与。
public class HelloController {

    // リクエスト /hello に対して実行されるメソッド。
    @RequestMapping("/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello, World!");
    }
}
