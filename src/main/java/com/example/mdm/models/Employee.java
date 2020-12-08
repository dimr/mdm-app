package com.example.mdm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// because of postgresql
    private Long id;

    private String name;
    private String email;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "employee")
    private Set<Device> devices = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }


    public Set<Device> getDevices() {
        return this.devices;
    }

    public Company getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //    @ManyToOne(fetch= FetchType.LAZY)
//    public List<Device> devices(){
//
//    }
    public void addDevice(Device device) {
        if (device==null)
            return;
        this.devices.add(device);
        device.setEmployee(this);

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
