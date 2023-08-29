package com.jsp.HomeServo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.service.WorkService;
import com.jsp.HomeServo.util.ResponseStructure;

@RestController
public class WorkController {
	@Autowired
	private WorkService service;
	@PostMapping("/works/{cus_id}")
	public ResponseEntity<ResponseStructure<Work>> saveWork(@RequestBody Work work,@PathVariable int cus_id) {
		return service.savework(work,cus_id);
	}
	@PutMapping("/works/start/{work_id}/{ven_id}")
	public ResponseEntity<ResponseStructure<Work>> startDate(@PathVariable int work_id,@PathVariable int ven_id) {
		return service.startDate(work_id, ven_id);
	}
	@PutMapping("/works/end/{work_id}/{ven_id}")
	public ResponseEntity<ResponseStructure<Work>> endDate(@PathVariable int work_id,@PathVariable int ven_id) {
		return service.endDate(work_id, ven_id);
	}
	@GetMapping("/works/{ven_id}")
	public ResponseEntity<ResponseStructure<List<Work>>> getAllOfWork(@PathVariable int ven_id) {
		return service.getAll(ven_id);
	}
	 @GetMapping("/works/{ven_id}/{work_id}")
	public ResponseEntity<ResponseStructure<Work>> getWorkById(@PathVariable int ven_id,@PathVariable int work_id) {
		return service.getWorkById(ven_id, work_id);
	}

}
