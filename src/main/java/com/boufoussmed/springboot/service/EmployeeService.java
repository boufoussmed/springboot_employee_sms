package com.boufoussmed.springboot.service;

import com.boufoussmed.springboot.entity.Employee;
import com.boufoussmed.springboot.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
	
		List<Employee> getAllEmployees();
		Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	void deleteEmployee(Long id);

	Employee getEmployeeByEmail(String email);
}
