package com.aem.aemtraining.core.bean;

public class Student {
	private String name;
	private String Address;
	private String email;
	private String Password;
	private String Telephone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", Address=" + Address + ", email=" + email + ", Password=" + Password
				+ ", Telephone=" + Telephone + "]";
	}
	
	
}
