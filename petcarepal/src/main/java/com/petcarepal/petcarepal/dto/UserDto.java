package com.petcarepal.petcarepal.dto;

public class UserDto {
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	private String confirm;
	private String petinfo;
	private String phone;
	private String verificationCode;
	
	

	public UserDto(String email, String password, String role, String fullname , String phone, String petinfo, String confirm,String verificationCode) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.petinfo = petinfo;
		this.phone = phone;
		this.confirm = confirm;
		this.verificationCode = verificationCode;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getPetinfo() {
		return petinfo;
	}

	public void setPetinfo(String petinfo) {
		this.petinfo = petinfo;
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
