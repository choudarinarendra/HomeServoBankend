package com.jsp.HomeServo.service;

import javax.persistence.SecondaryTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.Exception.NoSuchElementFoundByAddress;
import com.jsp.HomeServo.dao.AddressDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.util.ResponseStructure;

@Service
public class AddressService {
  @Autowired
  AddressDao addressDao;
  public ResponseEntity<ResponseStructure<Address>> getByAddress(int id){
	  Address address=addressDao.getAddressById(id);
	  if(address!=null) {
		  ResponseStructure<Address>structure=new ResponseStructure<>();
		  structure.setData(address);
		  structure.setMessage("Successfully fetch you data");
		  structure.setStatus(HttpStatus.FOUND.value());
		  return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	  }else {
		 throw new NoSuchElementFoundByAddress("Address id not presenet :"+id);
	  }
  }
  public ResponseEntity<ResponseStructure<Address>>updateAddress(Address address){
	 Address dataBase=addressDao.getAddressById(address.getId());
	 if(dataBase!=null) {
		 ResponseStructure<Address>structure=new ResponseStructure<>();
		 structure.setData(addressDao.updateAddress(address));
		 structure.setMessage("Address Update Successfully");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
	 }else {
		 throw new NoSuchElementFoundByAddress("Address id not presenet :"+address.getId());
	 }
  }
}
