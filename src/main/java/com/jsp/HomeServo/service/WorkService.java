package com.jsp.HomeServo.service;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByVendor;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByWork;
import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class WorkService {
@Autowired
private  WorkDao workDao;
@Autowired
private CustomerDao customerDao;
@Autowired
private VendorDao vendorDao;
public ResponseEntity<ResponseStructure<Work>>savework(Work work,int cus_id){
	Customer customer=customerDao.getByIdCustomer(cus_id);
	if(customer!=null) {
		ResponseStructure<Work> structure=new ResponseStructure<>();
		work.setCustomer(customer);
		structure.setData(workDao.saveWork(work));
		structure.setMessage("save successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
	}else {
		throw new NoSuchElementFoundByCustomer("customer id :"+cus_id+"is in valid");
	}
}
public ResponseEntity<ResponseStructure<Work>>startDate(int work_id,int ven_id){
	Vendor vendor=vendorDao.getByIdVendor(ven_id);
	if(vendor!=null) {
		Work work=workDao.getWorkById(work_id);
		if(work!=null) {
			Date date=new Date(new java.util.Date().getTime());
			work.setStartDate(date);
			 work.setVendor(vendor);
			 ResponseStructure<Work> structure=new ResponseStructure<>();
			 structure.setData(workDao.saveWork(work));
			 structure.setMessage("saved successfully");
			 structure.setStatus(HttpStatus.CREATED.value());
			 return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.CREATED);
			 
		}else {
			throw new NoSuchElementFoundByWork("work id :"+work_id+"is in valid");
		}
		
	}else {
		throw new NoSuchElementFoundByVendor("vendor id :"+ven_id+"is in valid");
	}
}
public ResponseEntity<ResponseStructure<Work>>endDate(int work_id,int ven_id){
	Vendor vendor=vendorDao.getByIdVendor(ven_id);
	if(vendor!=null) {
		Work work=workDao.getWorkById(work_id);
		if(work!=null) {
			Date date=new Date(new java.util.Date().getTime());
			work.setEndDate(date);
			ResponseStructure<Work>structure=new ResponseStructure<>();
			structure.setData(workDao.saveWork(work));
			structure.setMessage("successfully completed your work");
			structure.setStatus(HttpStatus.CREATED.value());
			
			 return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.CREATED);
			 
		}else {
			throw new NoSuchElementFoundByWork("work id :"+work_id+"is in valid");
		}
		
	}else {
		throw new NoSuchElementFoundByVendor("vendor id :"+ven_id+"is in valid");
	}
}
public ResponseEntity<ResponseStructure<Work>> getWorkById(int ven_id,int work_id){
	Vendor vendor=vendorDao.getByIdVendor(ven_id);
	if(vendor!=null) {
		Work work=workDao.getWorkById(work_id);
		if(work!=null) {
			ResponseStructure<Work> structure=new ResponseStructure<>();
			structure.setMessage("data fetchrd successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(workDao.getWorkById(work_id));
			return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementFoundByWork("work id :"+work_id+"is in valid");
		}
		
		
	}
	else {
		throw new NoSuchElementFoundByVendor("vendor id :"+ven_id+"is in valid");
	}
}
public ResponseEntity<ResponseStructure<List<Work>>> getAll(int ven_id){
	
	Vendor vendor =vendorDao.getByIdVendor(ven_id);
	if(vendor!=null) {
		List<Work> list=workDao.getAllByWork();
		ResponseStructure<List<Work>> structure=new ResponseStructure<>();
		structure.setMessage("data fetchrd successfull");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(workDao.getAllByWork());
		return new ResponseEntity<ResponseStructure<List<Work>>>(structure,HttpStatus.FOUND);
	}
	else {
		throw new NoSuchElementFoundByVendor();
	}
}
}
