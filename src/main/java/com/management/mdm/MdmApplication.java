package com.management.mdm;

import com.management.mdm.models.Device;
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
//        DeviceDTO deviceDTO = new DeviceDTO();
//        deviceDTO.setId(1L);
//        deviceDTO.setType("mobile");
//        deviceDTO.setSerial_number("gsdgsd");
//
//        deviceDTO.setEmployee(new Employee("dimitrs"));
//        System.out.println(deviceDTO)
        Device device = new Device();
        device.setEmployee_id(10);
        device.setType("mobile");

        System.out.println(device.toString());
//        System.out.println(companyDTO.getName());
//        System.out.println(companyDTO.testFunction());
//        System.out.println(companyDTO);
    }

}
