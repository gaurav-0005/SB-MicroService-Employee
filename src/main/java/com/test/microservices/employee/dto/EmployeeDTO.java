package com.test.microservices.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

    private DepartmentDTO departmentObj;
}
