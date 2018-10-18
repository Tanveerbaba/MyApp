package com.hashworks.MyApp.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hashworks.MyApp.model.Employee;

@Repository
public class DatabaseAccess {
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	private List<Employee> employees = new ArrayList<Employee>();
	
	// Get all the Employees
	public List<Employee> isData() {
		String SQL = "select * from employee";
     
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
        employees.clear();
		for (Map<String, Object> row : rows) 
	    {
	         Employee employee = new Employee();
	         employee.setId((String)row.get("id"));
	         employee.setName((String)row.get("name"));
	         employee.setJobPosition((String)row.get("jobposition"));
	         employee.setExperience((Float)row.get("experience"));
	         employees.add(employee);
     	}	

		return employees;
	}
	
	
	// Insert new Employee
	public int create(Employee emp) {
		String SQL = "insert into employee values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getJobPosition()+"','"+emp.getExperience()+"')"; 
		return jdbcTemplate.update(SQL);
	}
	
	//Update an existing Employee	
	public int updateEmployee(String id, Employee emp) {
		String SQL = "update employee set name='" + emp.getName() + "',jobposition='" + emp.getJobPosition() + "',experience='" + emp.getExperience() + "' where id= '" + id + "' ";
		return jdbcTemplate.update(SQL);
	}
	
	//Delete an Employee
	public int deleteEmployee(String id) {
		String SQL = "delete from employee where id='" + id + "' ";
		return jdbcTemplate.update(SQL);
	}
}
