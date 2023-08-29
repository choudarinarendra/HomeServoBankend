package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired

	private CustomerRepo rep;

	public Customer saveCustomer(Customer customer) {
		return rep.save(customer);
	}

	public Customer update(Customer customer) {
		if(rep.findById(customer.getId()).isPresent()) {
			// this is fetching from dataBase
			Customer dataBase=rep.findById(customer.getId()).get();
			if(customer.getPassword()==null) {
				//if we are not updating any field then keep as name
				customer.setPassword(dataBase.getPassword());
			}
			else if(customer.getEmail()==null) {
				customer.setEmail(dataBase.getEmail());
			}else if(customer.getWork()==null) {
				customer.setWork(dataBase.getWork());
			}
//				customer.setPhone(dataBase.getPhone());
//				customer.setName(dataBase.getName());
//				customer.setFamilyCount(dataBase.getFamilyCount());
//				customer.setAddress(dataBase.getAddress());
//				customer.setWork(dataBase.getWork());
			
			return rep.save(customer);
		}
		return null;
	}

	public Customer getByIdCustomer(int id) {
		if (rep.findById(id).isPresent()) {
			Customer customer = rep.findById(id).get();
			return customer;
		} else {
			return null;
		}
	}

	

	public Customer getByemail(String email) {
		Customer customer = rep.findByEmail(email);
		if (customer != null) {
			return customer;
		}
		return null;
	}

	public Customer delete(int id) {
		Optional<Customer> optional = rep.findById(id);
		if (optional.isPresent()) {
			
			 rep.delete(optional.get());
			 
			 return optional.get();
		}
		return null;
		
	}

}
