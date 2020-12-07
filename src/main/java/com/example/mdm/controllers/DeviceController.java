package com.example.mdm.controllers;


import com.example.mdm.dtos.DeviceDTO;
import com.example.mdm.models.Device;
import com.example.mdm.models.EmployeeRepository;
import com.example.mdm.repositories.DeviceRepository;
import com.example.mdm.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService=deviceService;
    }

//    @GetMapping("/devices")
//    public ResponseEntity<Page<Device>> getAll(Pageable page){
//        return ResponseEntity.ok(this.deviceRepository.findAll(page));
//    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<DeviceDTO> getById(@PathVariable Long id){
        return this.deviceService.findDeviceById(id);
    }
}
