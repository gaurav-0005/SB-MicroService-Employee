package com.test.microservices.employee.services;

import com.test.microservices.employee.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {


      public EmployeeDTO saveEmployee(EmployeeDTO departmentDTO);
      public EmployeeDTO getEmpByID(Long deptId);
      public List<EmployeeDTO> getAllEmployee();

}
