package com.example.mdm.CompanyService;

import com.example.mdm.models.Company;
import com.example.mdm.models.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

//    private Object CompanyDTO;
    private final CompanyRepository companyRepository;
    private ModelMapper mapper;


    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    //    public List<CompanyDTO> finalAllCompanies(){
//        List<Company> companies = this.companyRepository.findAll();
//
//    }
    public Optional<Company> findCompanyById(Long id){
        Optional<Company> company = companyRepository.findById(id);
        return company;
    }

}
