package com.example.mdm;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.models.Company;
import com.example.mdm.models.Device;
import com.example.mdm.models.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MdmApplication {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(MdmApplication.class, args);
        Employee employee1 = new Employee("the_employee");
        Device device = new Device("fdsfsdf","laptopm");
        employee1.addDevice(device);
        employee1.addDevice(new Device("fldk","mobile"));
        System.out.println(employee1.getDevices().toString());

        System.out.println(employee1.getDevices());
        System.out.println("END");
        Company company = new Company("first company");
        company.setAddress("9 street mock");
        CompanyDTO companyDTO = new CompanyDTO();
        ModelMapper mapper = new ModelMapper();
        mapper.map(company,companyDTO);
//        System.out.println(companyDTO.getName());
//        System.out.println(companyDTO.testFunction());
//        System.out.println(companyDTO);
    }

}
