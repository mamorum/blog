package sma.service;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final Logger logger = LoggerFactory.getLogger(TaskService.class);

	public Map<String, String> execute() {
		try {
			Thread.sleep(5000);
			logger.info("Slow task executed");
			return Collections.singletonMap("msg", "Task finished");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	@Async
	public void async() {
		try {
			Thread.sleep(5000);
			logger.info("Slow task executed by @Async.");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}
