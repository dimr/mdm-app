package com.management.mdm.services;

import com.management.mdm.dtos.DeviceDTO;
import com.management.mdm.models.Device;
import com.management.mdm.models.Employee;
import com.management.mdm.repositories.DeviceRepository;
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

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final ModelMapper mapper;
    private final DeviceDTO deviceDTO;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository,ModelMapper modelMapper,DeviceDTO deviceDTO, EmployeeRepository employeeRepository){
        this.deviceRepository=deviceRepository;
        this.mapper=modelMapper;
        this.deviceDTO=deviceDTO;
        this.employeeRepository = employeeRepository;
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

    public ResponseEntity<String> deleteDevice(Long id){
        Device device = deviceRepository.findDeviceById(id);
        deviceRepository.delete(device);
        return ResponseEntity.ok("Device Deleted");
    }

    public ResponseEntity<Page<DeviceDTO>> findDeviceByEmployeeId(Long employeeId){
        List<Device> devices = deviceRepository.findDeviceByEmployeeId(employeeId);
        Page<DeviceDTO> deviceDTOS=new PageImpl(devices);
        return ResponseEntity.ok(deviceDTOS);
    }


    public ResponseEntity<DeviceDTO> saveUpdateDevice(DeviceDTO deviceDTO){
        Device newDevice;
        Employee employee = employeeRepository.findEmployeeById((long) deviceDTO.getEmployee_id());

        if (deviceDTO.getId()==null){
            newDevice = mapper.map(deviceDTO,Device.class);
            newDevice.setEmployee_id(employee.getId());
            newDevice.setEmployee(employee);
            DeviceDTO deviceDTO1 = mapper.map(newDevice,DeviceDTO.class);
            deviceRepository.save(newDevice);
            return ResponseEntity.ok(mapper.map(newDevice,DeviceDTO.class));
        }
        else{
            newDevice=deviceRepository.findDeviceById(deviceDTO.getId());
            newDevice.setEmployee_id(deviceDTO.getEmployee_id());
            newDevice.setSerial_number(deviceDTO.getSerial_number());
            newDevice.setType(deviceDTO.getType());
            deviceRepository.save(newDevice);
        }
        return ResponseEntity.ok(deviceDTO);
    }
}
