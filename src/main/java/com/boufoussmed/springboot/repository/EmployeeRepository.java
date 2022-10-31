package com.boufoussmed.springboot.repository;

import com.boufoussmed.springboot.entity.Employee;
import com.boufoussmed.springboot.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
