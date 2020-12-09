package com.example.mdm.dtos;

import com.example.mdm.models.Device;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private CompanyDTO company;
    private String companyName;
    private List<Device> devices;
    private int numberOfDevices;

    public int getNumberOfDevices() {
//        setNumberOfDevices(this.devices.size());
        return numberOfDevices;
    }

    public void setNumberOfDevices(int numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", company=" + company +
                ", companyName='" + companyName + '\'' +
                ", devices=" + devices +
                '}';
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
