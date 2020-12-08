package com.example.mdm.controllers;

import com.example.mdm.dtos.EmployeeDTO;
import com.example.mdm.models.Employee;
import com.example.mdm.repositories.EmployeeRepository;
import com.example.mdm.repositories.DeviceRepository;
import com.example.mdm.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeControler {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // in post request bind @RequestParam Annotation, read form data and bind parameter
    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<EmployeeDTO>> getAllEmployees( Employee newEmployee) {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> saveOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.saveOrUpdateEmployee(employeeDTO);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeById(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
//
//    @GetMapping("/employees")
//    public ResponseEntity<Page<Employee>> getAll(Pageable pageable) {
//        return ResponseEntity.ok(this.employeeRepository.findAll(pageable));
//    }
}
