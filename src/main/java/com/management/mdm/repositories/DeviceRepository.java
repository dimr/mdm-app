package com.management.mdm.repositories;

import com.management.mdm.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {


    Device findDeviceById(Long id);

    List<Device> findDeviceByEmployeeId(Long id);
}
