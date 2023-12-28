package com.test.microservices.employee.services;

import com.test.microservices.employee.dto.DepartmentDTO;
import com.test.microservices.employee.dto.EmployeeDTO;
import com.test.microservices.employee.entity.EmployeeEntity;
import com.test.microservices.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class EmployeeServicesImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity EmployeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO,EmployeeEntity,"userid");
        employeeRepository.save(EmployeeEntity);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmpByID(Long empId) {

        EmployeeDTO EmployeeDTO = new EmployeeDTO();
        Optional<EmployeeEntity> EmployeeEntityObj = employeeRepository.findById(empId);

        if(null!=EmployeeEntityObj && !EmployeeEntityObj.isEmpty()) {
            BeanUtils.copyProperties(EmployeeEntityObj.get(), EmployeeDTO, "departmentObj");

            ResponseEntity<DepartmentDTO> departmentDTO = restTemplate.getForEntity("http://localhost:8082/department/" + EmployeeDTO.getDepartmentId(),
                    DepartmentDTO.class);

            log.info("departmentDTO " + departmentDTO);

            if (null != departmentDTO.getBody())
                EmployeeDTO.setDepartmentObj(departmentDTO.getBody());
        }
        return EmployeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeDTO> EmployeeDTOList=new ArrayList<>();
        List<EmployeeEntity> EmployeeEntityList=employeeRepository.findAll();

        for (EmployeeEntity EmployeeEntity:EmployeeEntityList){
            EmployeeDTO EmployeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(EmployeeEntity, EmployeeDTO);
            EmployeeDTOList.add(EmployeeDTO);
        }
        return EmployeeDTOList;
    }
}
