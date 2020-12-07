package com.example.mdm.repositories;

import com.example.mdm.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
