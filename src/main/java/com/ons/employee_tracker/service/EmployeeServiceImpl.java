package com.ons.employee_tracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ons.employee_tracker.entity.Employee;
import com.ons.employee_tracker.repository.EmployeeRepository;

@Service (value="userService")
public class EmployeeServiceImpl implements IEmployeeService, UserDetailsService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getEmployees() {
		List<Employee> list= new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Employee getEmployeeById(long id) {
		return repository.findOne(id);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		repository.delete(id);;
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Employee employee = repository.findByusername(userId);
		if(employee == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
