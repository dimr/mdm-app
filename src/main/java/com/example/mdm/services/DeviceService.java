package com.example.mdm.services;

import com.example.mdm.dtos.DeviceDTO;
import com.example.mdm.models.Device;
import com.example.mdm.repositories.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper mapper;
    private final DeviceDTO deviceDTO;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,ModelMapper modelMapper,DeviceDTO deviceDTO){
        this.deviceRepository=deviceRepository;
        this.mapper=modelMapper;
        this.deviceDTO=deviceDTO;
    }


    public ResponseEntity<DeviceDTO> findDeviceById(Long id){
        Optional<Device> optionalDevice = Optional.ofNullable(deviceRepository.findDeviceById(id));
        DeviceDTO deviceMapper=mapper.map(optionalDevice.get(),DeviceDTO.class);
        return ResponseEntity.ok(deviceMapper);
    }




}
