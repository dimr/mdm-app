package com.example.mdm.services;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.models.Company;
import com.example.mdm.models.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    //    private Object CompanyDTO;
    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;
    private final CompanyDTO companyDTO;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, ModelMapper mapper, CompanyDTO companyDTO) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
        this.companyDTO = companyDTO;
    }

    public ResponseEntity<Page<CompanyDTO>> findAllCompanies() {
        List<Company> companies = this.companyRepository.findAll();
        return ResponseEntity.ok(new PageImpl<>(mapper.map(companies, new TypeToken<List<CompanyDTO>>() {
        }.getType())));

    }

    public ResponseEntity<CompanyDTO> findCompanyByName(String name) {
        Optional<Company> optionalCompany = Optional.ofNullable(companyRepository.findByName(name));
        if (!optionalCompany.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        CompanyDTO CDTO = mapper.map(optionalCompany.get(), CompanyDTO.class);
        return ResponseEntity.ok(CDTO);
    }

}
