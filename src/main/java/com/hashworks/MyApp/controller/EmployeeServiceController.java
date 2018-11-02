package com.hashworks.MyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hashworks.MyApp.Repository.DatabaseAccess;
import com.hashworks.MyApp.model.Employee;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	DatabaseAccess da;
	
	// GET REQUEST
//	@RequestMapping(value ="/employees")
//	public ResponseEntity<Object> getEmployee() {
//		// creates a new response Entity with the given the body  and status code
//		employees = DA.isData();
//		return new ResponseEntity<>(employees, HttpStatus.OK);
//		
//	}
	
	@RequestMapping(value ="/employees")
	public List<Employee> getEmployee() {
		List<Employee> employees;
        employees = da.isData(); 
        return employees;
	}
		
	//POST REQUEST
	@RequestMapping(value ="/employees", method = RequestMethod.POST)
	public String createEmployee(@RequestBody Employee emp) {
		da.create(emp);
		return "Employee created successfully";
	}

//	//PUT REQUEST
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public String updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
		da.updateEmployee(id,emp);
		return "Updated Successfully";
	}
	
	//DELETE REQUEST
	@RequestMapping(value ="/employees/{id}", method = RequestMethod.DELETE) 
	public String deleteEmployee(@PathVariable("id") String id) {
		da.deleteEmployee(id);
		return "Deleted Succesfully";
	}
}
