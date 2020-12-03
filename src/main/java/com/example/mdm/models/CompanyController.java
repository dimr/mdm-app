package com.example.mdm.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyController {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    public CompanyController(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Optional<Company> optionalCompany = this.companyRepository.findById(id);
        return ResponseEntity.ok(optionalCompany.get());
    }


    @GetMapping("/companies")
    public ResponseEntity<Page<Company>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.companyRepository.findAll(pageable));
    }


}
