package com.rs.fer.bean;

public class Address {

	private int id;
	private String lineone;
	private String linetwo;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private int userid;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getLineone() {
		return lineone;
	}

	public void setLineone(String lineone) {
		this.lineone = lineone;
	}

	public String getLinetwo() {
		return linetwo;
	}

	public void setLinetwo(String linetwo) {
		this.linetwo = linetwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}