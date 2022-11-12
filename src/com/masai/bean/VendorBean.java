package com.masai.bean;

import java.util.Objects;

public class VendorBean {
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	
	public VendorBean() {
		super();
	}
	public VendorBean(String id, String password, String name, String email, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "VendorBean [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + ", getId()=" + getId() + ", getPassword()=" + getPassword() + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorBean other = (VendorBean) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
	
}
