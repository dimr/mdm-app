package com.example.mdm.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeControler {
    private final EmployeeRepository employeeRepository;
    private final DeviceRepository deviceRepository;


    @Autowired
    public EmployeeControler(EmployeeRepository employeeRepository, DeviceRepository deviceRepository) {
        this.employeeRepository = employeeRepository;
        this.deviceRepository = deviceRepository;
    }

    // in post request bind @RequestParam Annotation, read form data and bind parameter
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalEmployee.get());
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeRepository.findAll(pageable));
    }
}
