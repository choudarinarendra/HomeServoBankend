package com.jsp.HomeServo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo repo;

	public Address getAddressById(int id) {
		if (repo.findById(id).isPresent()) {
			Address address = repo.findById(id).get();
			return address;
		}
		return null;
	}

	public Address updateAddress(Address address) {
		if (repo.findById(address.getId()).isPresent()) {
			
			return  repo.save(address);
		}
		return null;
	}
}
