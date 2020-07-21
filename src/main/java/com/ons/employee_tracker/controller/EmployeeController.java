package com.ons.employee_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.employee_tracker.entity.Employee;
import com.ons.employee_tracker.service.IEmployeeService;

@RestController
@RequestMapping("/users")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping (value = "/user", method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@RequestMapping(value = "/user", method= RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping (value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable (value = "id") Long id) {
		employeeService.deleteEmployee(id);
	}
	
	

}
