package gssb.nosql.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gssb.nosql.mongodb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	Iterable<Customer> findByLastName(String lastName);
}
