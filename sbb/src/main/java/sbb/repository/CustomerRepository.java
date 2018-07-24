package sbb.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import sbb.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	Page<Customer> findByUserIdAndLastNameStartsWithOrderByIdDesc(Long userId, String lastName, Pageable page);
	Page<Customer> findByUserIdOrderByIdDesc(Long userId, Pageable page);
	Optional<Customer> findOneByIdAndUserId(Long id, Long userId);
	void deleteByUserId(Long id);
}
