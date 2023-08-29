package com.jsp.HomeServo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.duplicate.CustomerDuplicate;
import com.jsp.HomeServo.service.CustomerService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> save(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	@PutMapping("/customers")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<ResponseStructure<CustomerDuplicate>> getByIdCustomer(@PathVariable int id) {
		return service.getByIdCustomer(id);
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable int id) {
		return service.deleteCustomer(id);
	}
	
	@GetMapping("/customers/login")
	public ResponseEntity<ResponseStructure<Customer>> login(@RequestParam String email , @RequestParam String password){
		return service.login(email, password);
	}
}
