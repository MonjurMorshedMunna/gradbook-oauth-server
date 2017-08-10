package com.gradbook.models.userroles;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "userRole")
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

  @Cacheable
  UserRole findByUserId(Long userId);
}
