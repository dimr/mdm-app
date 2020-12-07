package com.example.mdm.controllers;


import com.example.mdm.dtos.DeviceDTO;
import com.example.mdm.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService=deviceService;
    }

    @GetMapping("/devices")
    public ResponseEntity<Page<DeviceDTO>> getAll(){
        return this.deviceService.findAllDevices();
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<DeviceDTO> getById(@PathVariable Long id){
        return this.deviceService.findDeviceById(id);
    }

    @DeleteMapping("/devices/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") Long id){
        return deviceService.deleteDevice(id);
    }

    @GetMapping("/devices/devices_by_employee/{employee_id}")
    public ResponseEntity<Page<DeviceDTO>> getDevicesByEmployeeId(@PathVariable("employee_id") Long employee_id){
        return deviceService.findDeviceByEmployeeId(employee_id);
    }

}
