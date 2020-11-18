package com.example.mdm.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Long id;

    private String name;
    private String email;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "employee")
    private Set<Device> devices =new HashSet<>();

    public Employee(){}
    public Employee(String name) {
        this.name = name;
    }


    public Set<Device> allDevice() {
        return this.devices;
    }
//    @ManyToOne(fetch= FetchType.LAZY)
//    public List<Device> devices(){
//
//    }
    public void addDevice(Device device){
        this.devices.add(device);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }


//    public void setDevices(Set<Device> devices) {
//        this.devices = devices;
//    }
}
