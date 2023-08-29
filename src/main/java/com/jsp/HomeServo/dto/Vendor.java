package com.jsp.HomeServo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phoneNo;
	private String role;
	private double costPerDay;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ServiceCoast> cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<ServiceCoast> getCost() {
		return cost;
	}
	public void setCost(List<ServiceCoast> cost) {
		this.cost = cost;
	}
	
}
	