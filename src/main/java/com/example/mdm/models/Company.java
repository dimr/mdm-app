package com.example.mdm.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity
@Table(name="companies",schema="public")
public class Company {
    @Id
    private Long id;
    private String name;
    private String address;

    public  Company(){}
    public Company(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "company")
    private List<Employee> employees=new ArrayList<>();



    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
        employee.setCompany(this);
    }


    public Long getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }
}
