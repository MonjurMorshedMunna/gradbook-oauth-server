package com.gradbook.models.user;

import org.codehaus.jackson.map.annotate.JsonCachable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "user")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable("user")
	User findByEmailAndPassword(String email, String password);

    @Cacheable("user")
    User findByEmail(String email);
}
