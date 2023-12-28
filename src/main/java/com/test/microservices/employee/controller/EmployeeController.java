package com.test.microservices.employee.controller;


import com.test.microservices.employee.dto.EmployeeDTO;
import com.test.microservices.employee.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){

        employeeDTO=employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> getEmpByID(@PathVariable("empId") String empId){

        EmployeeDTO departmentDTO=employeeService.getEmpByID(Long.parseLong(empId));
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> employeeDTOList= employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDTOList,HttpStatus.OK);
    }


}
