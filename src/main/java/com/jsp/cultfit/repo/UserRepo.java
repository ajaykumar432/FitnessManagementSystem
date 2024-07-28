package com.jsp.cultfit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.cultfit.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select a from User a where a.email=?1")
	public User findByEmail(String email); 
}
