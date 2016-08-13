package gssb.nosql.mongodb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gssb.nosql.mongodb.model.Customer;
import gssb.nosql.mongodb.repository.CustomerRepository;

@RestController @RequestMapping(path="/customers")
public class CustomerController {

	@Autowired CustomerRepository repo;
	
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, String> create(
		@RequestBody Customer customer
	) {
		Customer created = repo.save(customer);
		return Collections.singletonMap("id", created.id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Iterable<Customer>> find(
		@RequestParam String lastName
	) {
		Iterable<Customer> finded = repo.findByLastName(lastName);
		return Collections.singletonMap("customers", finded);
	}
}
