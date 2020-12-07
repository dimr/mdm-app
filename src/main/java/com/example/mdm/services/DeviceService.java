package com.example.mdm.services;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.dtos.DeviceDTO;
import com.example.mdm.models.Device;
import com.example.mdm.repositories.DeviceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public ResponseEntity<Page<DeviceDTO>> findAllDevices(){
        List<Device> devices = this.deviceRepository.findAll();
        return ResponseEntity.ok(new PageImpl<>(mapper.map(devices, new TypeToken<List<DeviceDTO>>() {
        }.getType())));

    }



}
