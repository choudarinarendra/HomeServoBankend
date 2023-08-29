package com.jsp.HomeServo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Exception.EmailNotFound;
import com.jsp.HomeServo.Exception.NoSuchElementFoundByCustomer;
import com.jsp.HomeServo.Exception.PasswordNotFound;
import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.duplicate.CustomerDuplicate;
import com.jsp.HomeServo.util.ResponseStructure;



@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	CustomerDuplicate duplicate;
	@Autowired
	ModelMapper modelMapper;
	//if want same(POSTMAN AND OUR STATUS)status then we want for ResponseEntity
   public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer){
	   ResponseStructure<Customer>structure=new ResponseStructure<>();
	   structure.setData(dao.saveCustomer(customer));
	   structure.setMessage("data saved sussesfully");
	   structure.setStatus(HttpStatus.CREATED.value());
	   return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
   }
   public ResponseEntity<ResponseStructure<Customer>>updateCustomer(Customer customer){
	   Customer customer2=dao.update(customer);
	   if(customer2!=null){
		   ResponseStructure<Customer>structure=new ResponseStructure<>();
		   structure.setData(customer2);
		   structure.setMessage("updated succussfully");
		   structure.setStatus(HttpStatus.FOUND.value());
		  return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
	   }
	   else {
		   throw new NoSuchElementFoundByCustomer("customer id is not found in  your custmomer object ");
	   }
   }
   public ResponseEntity<ResponseStructure<CustomerDuplicate>> getByIdCustomer(int id) {
		 Customer customer=dao.getByIdCustomer(id);
		ResponseStructure<CustomerDuplicate> structure=new ResponseStructure<>();
		if(customer!=null) {
//			   duplicate.setEmail(customer.getEmail());
//			   duplicate.setFamilyCount(customer.getFamilyCount());
//			   duplicate.setId(customer.getId());
//			   duplicate.setName(customer.getName());
//			   duplicate.setPhone(customer.getPhone());
			CustomerDuplicate customerDuplicate=(CustomerDuplicate)this.modelMapper.map(customer, CustomerDuplicate.class);
			structure.setData(customerDuplicate);
			structure.setMessage("successfully fetched data");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<CustomerDuplicate>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByCustomer("customer id is not found for your id  "+id+"  to display");
		}
		
	}
  
   public ResponseEntity<ResponseStructure<Customer>>login(String email,String password){
	   Customer customer=dao.getByemail(email);
		
		if(customer!=null) {
			if(customer.getPassword().equals(password)) {
				ResponseStructure<Customer> structure=new ResponseStructure<>();
				structure.setData(customer);
				structure.setMessage("customer login succssfully");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new PasswordNotFound( "customer  password is not found for your password "+customer.getPassword()+"to display");
			}
		}
		else {
			throw new EmailNotFound("customer  email is not found for your email to display");
		}
   }
   public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Customer customer=dao.delete(id);
		ResponseStructure<Customer> structure=new ResponseStructure<>();
		if(customer!=null) {
			structure.setData(customer);
			structure.setMessage("data deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			
		}
		else {
			throw new NoSuchElementFoundByCustomer("customer id is not found for your id  "+  id   +"  to display");
		}
		
	}
}
