package com.jsp.HomeServo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.ServiceCoast;
import com.jsp.HomeServo.repo.ServiceCoastRepo;

@Repository
public class ServiceCoastDao {
	@Autowired
	ServiceCoastRepo repo;
  public ServiceCoast saveServiceCoast(ServiceCoast serviceCoast) {
	  return repo.save(serviceCoast);
  }
  public ServiceCoast getByserviceCoast(int id) {
	  ServiceCoast coast=repo.findById(id).get();
	  if(coast!=null) {
		  return coast;
	  }
	  return null;
  }
  public ServiceCoast payServiceCoast(ServiceCoast coast) {
		if(repo.findById(coast.getId()).isPresent()) {
			ServiceCoast coast2=repo.findById(coast.getId()).get();
			coast2.setMode(coast.getMode());
			return repo.save(coast2);
		}
		else {
			return null;
		}
	}
}
