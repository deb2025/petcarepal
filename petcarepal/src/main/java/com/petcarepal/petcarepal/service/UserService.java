package com.petcarepal.petcarepal.service;



import com.petcarepal.petcarepal.dto.UserDto;
import com.petcarepal.petcarepal.model.User;

public interface UserService {
	
	User save(UserDto userDto, String url);
	boolean emailExists(String email);
	
	
	
	 
}
