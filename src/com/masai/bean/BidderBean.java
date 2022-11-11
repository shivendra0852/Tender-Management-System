package com.masai.bean;

import java.sql.Date;
import java.util.Objects;

public class BidderBean {
	private String id;
	private String vid;
	private String tid;
	private int price;
	private Date deadline;
	private String status;
	public BidderBean(String id, String vid, String tid, int price, Date deadline, String status) {
		super();
		this.id = id;
		this.vid = vid;
		this.tid = tid;
		this.price = price;
		this.deadline = deadline;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BidderBean [id=" + id + ", vid=" + vid + ", tid=" + tid + ", price=" + price + ", deadline=" + deadline
				+ ", status=" + status + ", getId()=" + getId() + ", getVid()=" + getVid() + ", getTid()=" + getTid()
				+ ", getPrice()=" + getPrice() + ", getDeadline()=" + getDeadline() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deadline, id, price, status, tid, vid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidderBean other = (BidderBean) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(id, other.id) && price == other.price
				&& Objects.equals(status, other.status) && Objects.equals(tid, other.tid)
				&& Objects.equals(vid, other.vid);
	}
	
	
}	