package com.petcarepal.petcarepal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.petcarepal.petcarepal.model.UserDtls;



public interface UserRepository extends JpaRepository<UserDtls,Long> {
	@Query("SELECT u FROM UserDtls u WHERE u.email = ?1")
    public UserDtls findByEmail(String email);
	
}
