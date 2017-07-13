package com.gradbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gradbook.enums.RoleType;
import com.gradbook.models.role.Role;
import com.gradbook.models.role.RoleRepository;
import com.gradbook.models.user.User;
import com.gradbook.models.user.UserRepository;
import com.gradbook.models.userroles.UserRole;
import com.gradbook.models.userroles.UserRoleRepository;

@Component
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public ResponseEntity<?> registerUser(final User user){
		userRepository.save(user);
		Role role = roleRepository.findOne( Long.valueOf(RoleType.USER.getValue()) );
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleRepository.save(userRole);
		return ResponseEntity.ok("created");
	}

}
