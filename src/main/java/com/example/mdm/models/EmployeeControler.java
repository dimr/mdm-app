package com.example.mdm.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControler {
    @Autowired
    private IEmployee employeeService;



    @GetMapping("/employees")
    List<Employee> employees(){
        return employeeService.findAll();
    }
}
