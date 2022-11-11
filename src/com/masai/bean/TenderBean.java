package com.masai.bean;

import java.sql.Date;
import java.util.Objects;

public class TenderBean {
	private String id;
	private String name;
	private String type;
	private int price;
	private String location;
	private Date deadline;
	public TenderBean(String id, String name, String type, int price, String location, Date deadline) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.location = location;
		this.deadline = deadline;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "TenderBean [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", location="
				+ location + ", deadline=" + deadline + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getType()=" + getType() + ", getPrice()=" + getPrice() + ", getLocation()=" + getLocation()
				+ ", getDeadline()=" + getDeadline() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deadline, id, location, name, price, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenderBean other = (TenderBean) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(type, other.type);
	}
	
}
