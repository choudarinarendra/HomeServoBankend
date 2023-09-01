package com.jsp.HomeServo.service;

import java.sql.Date;
import java.time.Duration;
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
import com.jsp.HomeServo.dao.ServiceCoastDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.ServiceCoast;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.util.ResponseStructure;



@Service
public class ServiceCoastService {
@Autowired
ServiceCoastDao coastDao;
@Autowired
VendorDao vendorDao;
@Autowired
WorkDao workDao;
@Autowired
ServiceCoast serviceCoast;
@Autowired
private CustomerDao customerDao;
public ResponseEntity<ResponseStructure<ServiceCoast>> save(int work_id,int ven_id){
	Vendor vendor=vendorDao.getByIdVendor(ven_id);
	if(vendor!=null) {
		 Work work=workDao.getWorkById(work_id);
		 if(work!=null) {
			 double costperDay=vendor.getCostPerDay();
			 Date start=work.getStartDate();
			 Date end=work.getEndDate();
			 Duration duration=Duration.between(start.toLocalDate().atStartOfDay(),end.toLocalDate().atStartOfDay());
			  int  Days=(int) duration.toDays();
			  ServiceCoast serviceCoast=new ServiceCoast();
			   serviceCoast.setDays(Days);
			   serviceCoast.setTotalAmount(Days*costperDay);
			   ServiceCoast serviceCoast2=coastDao.saveServiceCoast(serviceCoast);
			   work.setCost(serviceCoast2);
			   List<ServiceCoast>list= new ArrayList<ServiceCoast>();
			   list.add(serviceCoast2);
			   list.addAll(vendor.getCost());
			   vendor.setCost(list);
			   workDao.updateWork(work);
			   vendorDao.updateVendor(vendor);
			   ResponseStructure<ServiceCoast> structure=new ResponseStructure<>();
				structure.setData(serviceCoast2);
				structure.setMessage("cost saved successfull");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCoast>>(structure,HttpStatus.CREATED);

			   
		 }else {
			 throw new NoSuchElementFoundByWork("Work id="+work_id+" is invalid");
		 }
	}else {
		throw new NoSuchElementFoundByVendor("vendor id="+ven_id+" is invalid");
	}
}
public ResponseEntity<ResponseStructure<ServiceCoast>>payment(int cus_id,ServiceCoast serviceCoast){
	Customer customer=customerDao.getByIdCustomer(cus_id);
	if(customer!=null) {
		ServiceCoast serviceCoast2=coastDao.getByserviceCoast(serviceCoast.getId());
		 if(serviceCoast2!=null) {
			 ResponseStructure<ServiceCoast> structure=new ResponseStructure<>();
				structure.setData(coastDao.payServiceCoast(serviceCoast));
				structure.setMessage("payment is successfull");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ServiceCoast>>(structure,HttpStatus.CREATED);
		 }else {
			 throw new NoSuchElementFoundByCustomer("Service id="+serviceCoast.getId()+" is invalid"); 
		 }
		
	}else {
		throw new NoSuchElementFoundByCustomer("Customer id="+cus_id+" is invalid");
	}
}
}
