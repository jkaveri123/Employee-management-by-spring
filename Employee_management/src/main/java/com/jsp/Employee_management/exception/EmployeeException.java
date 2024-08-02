package com.jsp.Employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.Employee_management.util.ResponseStructure;


@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> userNotFound(
			IdNotFound e) {

		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStateCode(HttpStatus.NOT_FOUND.value());
		rs.setData(e.getMsg());
		rs.setMessage("id not found .pls try again with new data");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);

	}
}
