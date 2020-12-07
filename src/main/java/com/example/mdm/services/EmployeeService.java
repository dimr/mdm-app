package com.example.mdm.services;

import com.example.mdm.dtos.EmployeeDTO;
import com.example.mdm.models.Employee;
import com.example.mdm.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mappper;
    private final EmployeeDTO employeeDTO;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mappper, EmployeeDTO employeeDTO) {
        this.employeeRepository = employeeRepository;
        this.mappper = mappper;
        this.employeeDTO = employeeDTO;
    }
    public ResponseEntity<EmployeeDTO> findEmployeeById(Long id){
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findEmployeeById(id));
        if (!optionalEmployee.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(mappper.map(optionalEmployee.get(),EmployeeDTO.class));
    }
}
