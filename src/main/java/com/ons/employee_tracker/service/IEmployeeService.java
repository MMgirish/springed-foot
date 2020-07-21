package com.ons.employee_tracker.service;

import java.util.List;

import com.ons.employee_tracker.entity.Employee;


public interface IEmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(long id);
	
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(long id);
}
