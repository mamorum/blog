package sbb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import sbb.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	Long countByUsername(String username);
	Page<User> findAllByOrderByIdDesc(Pageable page);
	Page<User> findByUsernameStartsWithOrderByIdDesc(String username, Pageable page);
}
