package com.jsp.HomeServo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer findByEmail(String email);
}
