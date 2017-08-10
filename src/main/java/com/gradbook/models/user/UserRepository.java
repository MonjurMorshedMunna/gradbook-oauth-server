package com.gradbook.models.user;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "user")
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

  User findByEmail(String email);
}
