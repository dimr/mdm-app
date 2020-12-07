package com.example.mdm.CompanyService;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.models.Company;
import com.example.mdm.models.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

//    private Object CompanyDTO;
    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;


    @Autowired
    public CompanyService(CompanyRepository companyRepository, ModelMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

        public List<CompanyDTO> findAllCompanies(){
        List<Company> companies = this.companyRepository.findAll();
        return mapper.map(companies,new TypeToken<List<CompanyDTO>>(){}.getType());

    }
    public Optional<Company> findCompanyById(Long id){
        Optional<Company> company = companyRepository.findById(id);
        return company;
    }

}
