package com.petcarepal.petcarepal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "users")
@Entity
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true, length = 45)
    private String email;
     
    @Column(nullable = false, length = 64)
    private String password;
    
    @Column(nullable = false, length = 64)
    private String confirm;
    
    @Column(nullable = false, length = 10)
    private String phone;
     
    @Column(name = "full_name", nullable = false, length = 20)
    private String fullname;
     
    @Column(name = "pet_info", nullable = false, length = 20)
    private String petinfo;
	

	
	
}
