package com.jsp.Employee_management.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Employee_management.Entity.EmployeeDetails;
import com.jsp.Employee_management.clone.EmployeeClone;
import com.jsp.Employee_management.service.EmployeeService;
import com.jsp.Employee_management.util.ResponseStructure;


@RestController
public class EmployeeController {
@Autowired
EmployeeService service;
@Autowired
ModelMapper mapper;
@PostMapping("/save")


public EmployeeClone register(@RequestBody EmployeeDetails e) {
	 EmployeeDetails register = service.SaveEmployee(e);
	try {
		EmployeeClone ec=m1(register);
		return ec;
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return null;
	
}
@PostMapping("/emp")
private EmployeeClone m1(@RequestBody EmployeeDetails emp) {
	EmployeeClone c=mapper.map(emp, EmployeeClone.class);
	return c;
}
@PostMapping("/sendhtml")
public String sendHtml(@RequestBody EmployeeDetails emp) {
	try {
		service.sendHtmlEmail(emp);
		return "msg send successfully";
	}catch(Exception e) {
		return "internal error";
	}
}
@GetMapping("/find")
public ResponseEntity<ResponseStructure<EmployeeDetails>> findById(@RequestParam int id){
	return service.fetchEmployeeDetails(id);
}
}
