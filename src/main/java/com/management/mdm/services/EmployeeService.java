package com.management.mdm.services;

import com.management.mdm.dtos.CompanyDTO;
import com.management.mdm.dtos.EmployeeDTO;
import com.management.mdm.models.Company;
import com.management.mdm.models.Employee;
import com.management.mdm.repositories.CompanyRepository;
import com.management.mdm.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        // calculate the number of devices here and insert into EmployeeDTO
        EmployeeDTO employeeDTO = mappper.map(optionalEmployee.get(),EmployeeDTO.class);
        employeeDTO.setNumberOfDevices(optionalEmployee.get().getDevices().size());
        return ResponseEntity.ok(employeeDTO);
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

    public Employee convertToEntity(EmployeeDTO employeeDTO){
        Employee employee = mappper.map(employeeDTO,Employee.class);
        return employee;
    }
    public ResponseEntity<EmployeeDTO> saveOrUpdateEmployee(EmployeeDTO employeeDTO){
        boolean exists = employeeDTO.getId()!=null;

        if (exists){
            Optional<Employee> employee = employeeRepository.findById(employeeDTO.getId());
            Employee updatedEmployee;
            Company company=this.companyRepository.findByName(employeeDTO.getCompanyName());
            CompanyDTO companyDTO = convertToDto(company);
            employeeDTO.setCompany(companyDTO);
            this.mappper.map(employeeDTO,employee.get());
            updatedEmployee=employeeRepository.save(employee.get());
            return ResponseEntity.ok(employeeDTO);

        }
        else{
            Company company = companyRepository.findByName(employeeDTO.getCompanyName());
            Employee newEmployee = convertToEntity(employeeDTO);
            newEmployee.setCompany(company);
            employeeRepository.save(newEmployee);

            return ResponseEntity.ok(employeeDTO);
        }
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        Employee employee = employeeRepository.findEmployeeById(id);
        employeeRepository.delete(employee);
        return ResponseEntity.ok(String.format("Deleted employee with id = %s",id));

    }

    private EmployeeDTO employeeDTO(Employee employee){
        EmployeeDTO employeeDTO = mappper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }


    public ResponseEntity<List<EmployeeDTO>> getEmployeesByCompanyName(String conpanyName){
        List<Employee> employees = employeeRepository.findEmployeeByCompanyName(conpanyName);
        List<EmployeeDTO> employeeDTOS = employees.stream().map(this::employeeDTO).collect(Collectors.toList());
        return ResponseEntity.ok(employeeDTOS);
    }
}
