package com.management.mdm.controllers;

import com.management.mdm.dtos.EmployeeDTO;
import com.management.mdm.models.Employee;
import com.management.mdm.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
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
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        System.out.println("GETTING EMPLOYEE  "+id);
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
