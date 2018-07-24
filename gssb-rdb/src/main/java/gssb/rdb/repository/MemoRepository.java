package gssb.rdb.repository;

import org.springframework.data.repository.CrudRepository;

import gssb.rdb.model.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long> {
  // 引数の text に一致するエンティティを取得。
  Iterable<Memo> findByText(String text);
}
