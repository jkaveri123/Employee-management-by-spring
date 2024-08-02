package com.jsp.Employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Employee_management.Entity.EmployeeDetails;

public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Integer> {

}
