package sbt.repository;

import org.springframework.data.repository.CrudRepository;

import sbt.model.Tsubuyaki;

public interface TsubuyakiRepository extends CrudRepository<Tsubuyaki, Long> {
	Iterable<Tsubuyaki> findAllByOrderByUpdatedTimeDesc();
}
