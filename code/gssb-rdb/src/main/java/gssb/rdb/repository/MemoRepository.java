package gssb.rdb.repository;

import org.springframework.data.repository.CrudRepository;

import gssb.rdb.model.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
	Iterable<Memo> findByText(String text);
}
