package sbb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sbb.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
	Optional<UserInfo> findOneByUserId(Long userId);
	void deleteByUserId(Long userId);
}
