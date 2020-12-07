package com.example.mdm.controllers;


import com.example.mdm.models.Device;
import com.example.mdm.models.EmployeeRepository;
import com.example.mdm.repositories.DeviceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DeviceController {

    private final EmployeeRepository employeeRepository;
    private final DeviceRepository deviceRepository;

    public DeviceController(EmployeeRepository employeeRepository, DeviceRepository deviceRepository) {
        this.employeeRepository = employeeRepository;
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/devices")
    public ResponseEntity<Page<Device>> getAll(Pageable page){
        return ResponseEntity.ok(this.deviceRepository.findAll(page));
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getById(@PathVariable Long id){
        Optional <Device> optionalDevice = this.deviceRepository.findById(id);
        if (!optionalDevice.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalDevice.get());
    }
}
