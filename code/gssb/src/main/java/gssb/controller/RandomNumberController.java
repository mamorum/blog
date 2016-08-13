package gssb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gssb.service.RandomNumberService;

@RestController
public class RandomNumberController {

	// サービスクラスがＤＩされる。
	@Autowired RandomNumberService random;
	
	// 乱数をレスポンスとして返却する。
	@RequestMapping("/random")
    public Map<String, Integer> random() {
		int value = random.zeroToNine();
        return Collections.singletonMap("value", value);
    }
}
