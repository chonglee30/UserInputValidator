package com.users.validator.model;

public class User {
	private String firstName;
	private String lastName;
	private String companyName;

	private String address;
	private String city;
	private String province;
	private String postal;
	private String phone1;
	private String phone2;
	private String email;
	private String web;

	public User(String firstName, String lastName, String companyName,
			String address, String city, String province, String postal,
			String phone1, String phone2, String email, String web) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;

		this.address = address;
		this.city = city;
		this.province = province;
		this.postal = postal;

		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.web = web;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}

}
