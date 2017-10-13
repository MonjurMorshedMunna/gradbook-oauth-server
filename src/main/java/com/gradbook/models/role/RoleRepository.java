package com.gradbook.models.role;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "role")
public interface RoleRepository extends JpaRepository<Role, Long>{

}
