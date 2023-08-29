package com.jsp.HomeServo.duplicate;

import org.springframework.stereotype.Component;

import com.jsp.HomeServo.dto.Address;

@Component
public class CustomerDuplicate {
 private int id;
 private String name;
 private String email;
 private long phone;
 private int familyCount;
 private Address address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
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
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getFamilyCount() {
	return familyCount;
}
public void setFamilyCount(int familyCount) {
	this.familyCount = familyCount;
}
}
