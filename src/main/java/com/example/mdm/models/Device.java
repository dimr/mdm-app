package com.example.mdm.models;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="employee_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;

    public Device(String serialId, Employee employee) {
        this.serialId = serialId;
        this.employee = employee;
    }

    public Device() {

    }

    public Long getId() {
        return this.id;
    }

    public String getSerialId() {
        return this.serialId;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }
}
