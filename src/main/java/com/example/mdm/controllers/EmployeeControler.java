package com.example.mdm.controllers;

import com.example.mdm.dtos.EmployeeDTO;
import com.example.mdm.models.Employee;
import com.example.mdm.repositories.EmployeeRepository;
import com.example.mdm.repositories.DeviceRepository;
import com.example.mdm.services.EmployeeService;
import lombok.extern.java.Log;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;


@RestController
@RequestMapping("")
public class EmployeeControler {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handlerErrors(DataIntegrityViolationException e){
        return "Duplicate email" + e.getCause().toString();
    }

//    @ExceptionHandler(Exception.class)
//    public String handlerErrors(JDBCException e){
//        return "Duplicate email" + e.getCause().toString()+" ";
//    }


    // in post request bind @RequestParam Annotation, read form data and bind parameter
    @CrossOrigin
    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }
    @CrossOrigin
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

    @GetMapping("/employees/test/{companyName}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByCompanyName(@PathVariable String companyName){
        return employeeService.getEmployeesByCompanyName(companyName);
    }
//
//    @GetMapping("/employees")
//    public ResponseEntity<Page<Employee>> getAll(Pageable pageable) {
//        return ResponseEntity.ok(this.employeeRepository.findAll(pageable));
//    }
}
