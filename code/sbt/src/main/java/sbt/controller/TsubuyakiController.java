package sbt.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbt.model.Tsubuyaki;
import sbt.repository.TsubuyakiRepository;

@RestController @RequestMapping("/tsubuyaki")
public class TsubuyakiController {

	@Autowired TsubuyakiRepository repo;

	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Tsubuyaki> create(
			@Valid @RequestBody Tsubuyaki tsubuyaki
	) {
		return Collections.singletonMap(
			"tsubuyaki", repo.save(tsubuyaki)
		);
	}

	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Iterable<Tsubuyaki>> read() {
		return Collections.singletonMap(
			"tsubuyaki", repo.findAllByOrderByUpdatedTimeDesc()
		);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public void update(
			@PathVariable Long id, @RequestParam String txt
	) {
		Tsubuyaki tsubuyaki = repo.findOne(id);
		tsubuyaki.txt = txt;
		repo.save(tsubuyaki);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repo.delete(id);
	}
}
