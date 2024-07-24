package com.petcarepal.petcarepal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petcarepal.petcarepal.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
	User findByEmail(String email);
}
