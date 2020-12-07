package com.example.mdm.models;


import com.example.mdm.services.CompanyService;
import com.example.mdm.dtos.CompanyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;


    }

    @GetMapping("/companies")
    public ResponseEntity<Page<CompanyDTO>> getAllCompanies(){
        return companyService.findAllCompanies();
    }


    @GetMapping("companies/{name}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable String name) {
        return this.companyService.findCompanyByName(name);
    }

//    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
//        Optional<Company> optionalCompany = this.companyRepository.findById(id);
//        return ResponseEntity.ok(optionalCompany.get());
//    }
//
//
//    @GetMapping("/companies")
//    public ResponseEntity<Page<Company>> getAll(Pageable pageable) {
//        return ResponseEntity.ok(this.companyRepository.findAll(pageable));
//    }


}
