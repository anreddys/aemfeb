package com.aem.aemtraining.core.bean;

public class Employ {
	
	private String name;
	private String age;
	private String email;
	private String weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Employ [weight=" + weight + ", age=" + age + ", email=" + email + ", name=" + name + ", getWeight()="
				+ getWeight() + ", getAge()=" + getAge() + ", getEmail()=" + getEmail() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}