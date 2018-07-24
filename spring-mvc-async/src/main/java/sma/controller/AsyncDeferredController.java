package sma.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import sma.service.TaskService;

@RestController
public class AsyncDeferredController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired TaskService taskService;

	@RequestMapping(value = "/deferred", method = RequestMethod.GET)
	public DeferredResult<Map<String, String>> executeSlowTask() {

		logger.info("Request received");
		DeferredResult<Map<String, String>> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(taskService::execute)
            .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        logger.info("Servlet thread released");

        return deferredResult;
	}
}
