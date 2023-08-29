package com.jsp.HomeServo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.ServiceCoast;
import com.jsp.HomeServo.service.ServiceCoastService;
import com.jsp.HomeServo.util.ResponseStructure;


@RestController
public class ServiceCoastController {
	@Autowired

	private ServiceCoastService coastService;

	@PostMapping("/cost/{work_id}/{ven_id}")
	
	public ResponseEntity<ResponseStructure<ServiceCoast>> saveCoast(@PathVariable int work_id,
			@PathVariable int ven_id) {
		return coastService.save(work_id, ven_id);
	}
	@PutMapping("/cost/{cus_id}")
	public ResponseEntity<ResponseStructure<ServiceCoast>> payment(@PathVariable int cus_id,@RequestBody ServiceCoast coast) {
		return coastService.payment(cus_id, coast);
	}
}
