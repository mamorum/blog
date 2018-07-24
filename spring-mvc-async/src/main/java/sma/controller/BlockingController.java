package sma.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sma.service.TaskService;

@RestController
public class BlockingController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired TaskService taskService;

	@RequestMapping(value = "/block", method = RequestMethod.GET)
	public Map<String, String> executeSlowTask() {

		logger.info("Request received");
		Map<String, String> result = taskService.execute();
		logger.info("Servlet thread released");

		return result;
	}
}
