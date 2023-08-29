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

import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.service.VendorService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class VendorController {
	@Autowired
	private VendorService service;
	@PostMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(@RequestBody Vendor vendor) {
		return service.saveVendor(vendor);
	}
	@PutMapping("/vendors")
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@RequestBody Vendor vendor) {
		return service.updateVnVendor(vendor);
	}
	@GetMapping("/vendors/{id}")
	public ResponseEntity<ResponseStructure<Vendor>> getByIdVendor(@PathVariable int id) {
		return service.getByIdVendor(id);
	}
	@DeleteMapping("/vendors/{id}")
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@PathVariable int id) {
		return service.deleteVendor(id);
	}
	@GetMapping("/vendors/All/{cust_id}")
	public List<Vendor> getAllVendors(@PathVariable int cust_id){
		return service.getAllVendors(cust_id);
	}
	@GetMapping("/vendors/login")
	public ResponseEntity<ResponseStructure<Vendor>> login(@RequestParam String email,@RequestParam String password){
		return service.login(email, password);
	}
}
