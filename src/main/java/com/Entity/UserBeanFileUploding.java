package com.Entity;

import org.springframework.web.multipart.MultipartFile;

public class UserBeanFileUploding {

	String firstname;
	MultipartFile profile;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public MultipartFile getProfile() {
		return profile;
	}
	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	
	
}
