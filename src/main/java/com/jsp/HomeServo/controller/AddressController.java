package com.jsp.HomeServo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.service.AddressService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class AddressController {
@Autowired
AddressService service;
@GetMapping("/address/{id}")
public ResponseEntity<ResponseStructure<Address>>getByAddress(@PathVariable int id){
	return service.getByAddress(id);
}
@PutMapping("/address")
public ResponseEntity<ResponseStructure<Address>>updateAddress(@RequestBody Address address){
	return service.updateAddress(address);
}
}
