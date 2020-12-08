package com.example.mdm.services;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.dtos.EmployeeDTO;
import com.example.mdm.models.Company;
import com.example.mdm.models.Employee;
import com.example.mdm.repositories.CompanyRepository;
import com.example.mdm.repositories.EmployeeRepository;
import com.jayway.jsonpath.JsonPath;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mappper;
    private final EmployeeDTO employeeDTO;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mappper, EmployeeDTO employeeDTO,CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.mappper = mappper;
        this.employeeDTO = employeeDTO;
        this.companyRepository = companyRepository;
    }
    public ResponseEntity<EmployeeDTO> findEmployeeById(Long id){
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findEmployeeById(id));
        if (!optionalEmployee.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(mappper.map(optionalEmployee.get(),EmployeeDTO.class));
    }

    public ResponseEntity<Page<EmployeeDTO>> findAllEmployees(){
        List<Employee> employees = this.employeeRepository.findAll();

        return ResponseEntity.ok(new PageImpl<>(this.mappper.map(employees, new TypeToken<List<EmployeeDTO>>() {
        }.getType())));
    }

    private CompanyDTO convertToDto(Company company){
        CompanyDTO companyDTO = mappper.map(company,CompanyDTO.class);
        return companyDTO;
    }

    public ResponseEntity<EmployeeDTO> saveOrUpdateEmployee(EmployeeDTO employeeDTO){
        boolean exists = employeeDTO.getId()!=null;
        System.out.println("SEND: "+employeeDTO.toString());
        if (exists){
            Optional<Employee> employee = employeeRepository.findById(8L);
            Employee updatedEmployee;
            Company company=this.companyRepository.findByName("comquent");
//            this.mappper.map(company,CompanyDTO.class);
//            employeeDTO.setCompany(new Company(C);
//            Optional<CompanyDTO> optionalCompany = companyService.findCompanyByName("comquent");
            CompanyDTO companyDTO = convertToDto(company);
            employeeDTO.setCompany(companyDTO);
            this.mappper.map(employeeDTO,employee.get());
            updatedEmployee=employeeRepository.save(employee.get());
            // mapt to existing entity reverse mapping?
            System.out.println("EMPLOYEE NEW"+ updatedEmployee);
            return ResponseEntity.ok(employeeDTO);

        }
        System.out.println("ERROR");
        return ResponseEntity.ok(employeeDTO);
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        Employee employee = employeeRepository.findEmployeeById(id);
        employeeRepository.delete(employee);
        return ResponseEntity.ok(String.format("Deleted employee with id = %s",id));

    }
}
