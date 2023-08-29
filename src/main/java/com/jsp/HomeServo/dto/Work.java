package com.jsp.HomeServo.dto;


import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String typeOfWork;
	private Date startDate;
	private Date endDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@ManyToOne
	private Vendor vendor;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToOne
	private ServiceCoast cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeOfWork() {
		return typeOfWork;
	}
	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ServiceCoast getCost() {
		return cost;
	}
	public void setCost(ServiceCoast cost) {
		this.cost = cost;
	}
	 
}
