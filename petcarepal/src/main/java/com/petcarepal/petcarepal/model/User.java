package com.petcarepal.petcarepal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user_info", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String email;
	private String password;
	private String confirm;
	private String phone;
	private String role;
	private String fullname;
	private String petinfo;
	private String verificationCode;
	
	public User() {
		super();
	}

	public User(String email, String password, String role, String fullname, String confirm , String petinfo, String phone,String verificationCode) {
		
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.phone = phone;
		this.petinfo = petinfo;
		this.confirm = confirm;
		this.verificationCode = verificationCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPetinfo() {
		return petinfo;
	}
	public void setPetinfo(String petinfo) {
		this.petinfo = petinfo;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	

	
	
	
	
	
	
	
	
	

}