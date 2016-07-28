package gssb.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccessingExternalServiceController {

	// RestTemplate はスレッドセーフ
	// https://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate/
	private final RestTemplate rt = new RestTemplate();
	
	// 外部サービスの URL 
	// https://spring.io/guides/gs/consuming-rest/
	private final String url = "http://gturnquist-quoters.cfapps.io/api/random";
	
	// 外部サービスの JSON を、そのまま（JSON のまま）返却。
	@RequestMapping(value="/ex/exchange")
    public ResponseEntity<String> exchange() {
		return rt.exchange(url, HttpMethod.GET, null, String.class);
	}
	
	// 外部サービスの JSON を、一度オブジェクトにしてから返却。
	@RequestMapping(value="/ex/get-object")
	public RandomValue getObject() {
		return rt.getForObject(url, RandomValue.class);
	}
	public static class RandomValue {
		public String type;
		public Value value;		
	}
	public static class Value {
		public long id;
		public String quote;
	}
}

