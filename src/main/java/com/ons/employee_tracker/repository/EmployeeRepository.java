package com.ons.employee_tracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ons.employee_tracker.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	Employee findByusername(String username);
}
