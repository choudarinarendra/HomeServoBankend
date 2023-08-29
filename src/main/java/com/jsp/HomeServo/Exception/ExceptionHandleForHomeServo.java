package com.jsp.HomeServo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.HomeServo.util.ResponseStructure;

@ControllerAdvice
public class ExceptionHandleForHomeServo extends ResponseEntityExceptionHandler{
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> SQLIntegrityConstraintViolationException(java.sql.SQLIntegrityConstraintViolationException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("dont inserd dublicate email id ");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundCustomer(EmailNotFound ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Enter currect Email");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PasswordNotFound.class)
	public ResponseEntity<ResponseStructure<String>> passwordNotFoundCustomer(PasswordNotFound pass){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Enter currect password");
		structure.setMessage(pass.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(NoSuchElementFoundByCustomer.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementFoundByCustomer(NoSuchElementFoundByCustomer id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Enter currect id");
		structure.setMessage(id.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchElementFoundByVendor.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementFoundByVendor(NoSuchElementFoundByVendor id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Enter currect Id");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(id.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(NoSuchElementFoundByWork.class)
    public ResponseEntity<ResponseStructure<String>>noSuchElementFoundByWork(NoSuchElementFoundByWork id){
    	ResponseStructure<String>structure=new ResponseStructure<>();
    	structure.setData("Enter currect id");
    	structure.setMessage(id.getMessage());
    	structure.setStatus(HttpStatus.NOT_FOUND.value());
    	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoSuchElementFoundByAddress.class)
    public ResponseEntity<ResponseStructure<String>>noSuchElementFoundByAddress(NoSuchElementFoundByAddress id){
    	ResponseStructure<String>structure=new ResponseStructure<>();
    	structure.setData("Enter currect id");
    	structure.setMessage(id.getMessage());
    	structure.setStatus(HttpStatus.NOT_FOUND.value());
    	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
}
