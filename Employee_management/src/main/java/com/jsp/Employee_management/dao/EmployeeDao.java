package com.jsp.Employee_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Employee_management.Entity.EmployeeDetails;
import com.jsp.Employee_management.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo repo;
	
	public EmployeeDetails saveEmployee(EmployeeDetails u) {
		// TODO Auto-generated method stub
		return repo.save(u);
	}
	public EmployeeDetails fetchEmployeeDetails(int id) {
		Optional<EmployeeDetails> r=repo.findById(id);
		if(r.isPresent()) {
			return r.get();
		}else {
			return null;
		}
		
		
	}
	

}
