package com.example.mdm.services;

import com.example.mdm.dtos.CompanyDTO;
import com.example.mdm.dtos.DeviceDTO;
import com.example.mdm.models.Device;
import com.example.mdm.models.Employee;
import com.example.mdm.repositories.DeviceRepository;
import com.example.mdm.repositories.EmployeeRepository;
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

//    public ResponseEntity<DeviceDTO> saveDevice(DeviceDTO deviceDTO){
//        Device device;
//
//    }
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
        System.out.println("_------------------------------"+deviceDTO);
        Employee employee = employeeRepository.findEmployeeById((long) deviceDTO.getEmployee_id());
        System.out.println("DEFORE ENTER.............."+deviceDTO.getId());
        if (deviceDTO.getId()==null){
            System.out.println("ENTERED.............."+employee);
//            newDevice= deviceRepository.findDeviceById((long) deviceDTO.getId());
            //map from DeviceDTO to device and save the device
            newDevice = mapper.map(deviceDTO,Device.class);
            System.out.println("INITIAL NEW DEVICE"+" "+deviceDTO.getId()+deviceDTO.getEmployee_id());

//            newDevice.setEmployee(employee);
            newDevice.setEmployee_id(employee.getId());
            newDevice.setEmployee(employee);
            DeviceDTO deviceDTO1 = mapper.map(newDevice,DeviceDTO.class);
            deviceRepository.save(newDevice);
            System.out.println("DEVICE ENTITY "+newDevice.toString());
            System.out.println("DEVICE DTO "+deviceDTO.toString());
            System.out.println("NEW DEVICE "+ newDevice.toString());
            System.out.println("NEW DTO "+ deviceDTO.toString());
            return ResponseEntity.ok(mapper.map(newDevice,DeviceDTO.class));
        }
        else{

            newDevice=deviceRepository.findDeviceById(deviceDTO.getId());
            System.out.println("FOUND DEVICE TO CHAGE: "+newDevice);
//            mapper.map(deviceDTO,Device.class);
//            System.out.println("NEW DEVIDE ->"+newDevice);
//            newDevice.setSerial_number(deviceDTO.getSerial_number());
//            newDevice.setSerial_number(deviceDTO.getSerial_number());

            deviceRepository.save(mapper.map(deviceDTO,Device.class));
        }
        System.out.println("OUT HERER------------------");
        return ResponseEntity.ok(deviceDTO);
    }
}
