package com.test.microservices.employee.repository;

import com.test.microservices.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>{
}
