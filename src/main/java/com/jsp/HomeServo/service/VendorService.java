package com.jsp.HomeServo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Exception.EmailNotFound;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.Exception.PasswordNotFound;
import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.util.ResponseStructure;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class VendorService {
	@Autowired
	private VendorDao dao;
	@Autowired
	private CustomerDao customerDao;
	//if want same(POSTMAN AND OUR STATUS)status then we want for ResponseEntity(Enum)
	// FOUND and CREATED is costraines are in Enum of ResponceEntity
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(Vendor vendor) {
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		structure.setData(dao.saveVendor(vendor));
		structure.setMessage("data saved succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Vendor>> updateVnVendor(Vendor vendor) {
		Vendor vendor2=dao.updateVendor(vendor);
		if(vendor2!=null) {
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		structure.setData(vendor2);
		structure.setMessage("data updated successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.FOUND);
		}else {
			throw new NoSuchElementFoundByVendor("vendor id is not found in  your custmomer object");
		}
	}

	public ResponseEntity<ResponseStructure<Vendor>> getByIdVendor(int id) {
		Vendor vendor=dao.getByIdVendor(id);
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		if(vendor!=null) {
			structure.setData(dao.getByIdVendor(id));
			structure.setMessage("data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByVendor("vendor id is not found for your id  "+id+"  to display");
		}
	}
	public ResponseEntity<ResponseStructure<Vendor>> login(String email,String password){
		Vendor vendor=dao.getByEmailVendor(email);
		if(vendor!=null) {
			if(vendor.getPassword().equals(password)) {
				ResponseStructure<Vendor> structure=new ResponseStructure<>();
				structure.setData(vendor);
				structure.setMessage("login succesfull");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFound("vendor  password is not found for your password "+vendor.getPassword()+"to display");
			}
		}
		else {
			throw new EmailNotFound("vendor  email is not found for your email to display");
		}
	}
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(int id) {
		Vendor vendor=dao.deleteVendor(id);
		ResponseStructure<Vendor> structure = new ResponseStructure<>();
		if(vendor!=null) {
			structure.setData(vendor);
			structure.setMessage("data deleteded successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Vendor>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByVendor("vendor id is not found for your id  "+id+"  to display");
		}
		
	}

	public List<Vendor> getAllVendors(int cust_id) {
		Customer customer=customerDao.getByIdCustomer(cust_id);
		if(customer!=null) {
			return dao.getAllVendors();
		}
		else {
			throw new NoSuchElementFoundByCustomer("customer Id not present"+cust_id);
		}
	}

}
