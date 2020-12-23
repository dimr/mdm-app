package com.management.mdm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String serial_number;
    private String type;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;

    @Column(name="employee_id",insertable = false, updatable = false)
    private long employee_id;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public Device(String serialId, Employee employee) {
        this.serial_number = serialId;
        this.employee = employee;
    }

    public Device() {

    }

    public Device(String serial_number, String type) {
        this.serial_number = serial_number;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getSerial_number() {
        return this.serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", type='" + type + '\'' +
                ", employee_id=" + employee_id +
                '}';
    }
}
