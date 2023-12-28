package com.test.microservices.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    public Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
