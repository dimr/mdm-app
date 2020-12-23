package com.management.mdm.dtos;


import com.management.mdm.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class DeviceDTO {
    private Long id;
    private String serial_number;
    private String type;

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    private Employee employee;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    private long employee_id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", type='" + type + '\'' +
                ", employee=" + employee +
                ", employee_id=" + employee_id +
                '}';
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
