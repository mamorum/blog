package sma.controller;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sma.service.TaskService;

@RestController
public class AsyncController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final AtomicLong l = new AtomicLong();
	@Autowired TaskService taskService;

	@RequestMapping(value = "/async", method = RequestMethod.GET)
	public Map<String, String> callAsync() {

		logger.info("Request received");
		taskService.async();
		Map<String, String> result = Collections.singletonMap(
			"msg", "Task finished " + l.incrementAndGet() + " times."
		);
		logger.info("Servlet thread released");

		return result;
	}
}
