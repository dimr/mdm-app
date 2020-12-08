package com.example.mdm.repositories;

import com.example.mdm.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findEmployeeById(Long id);

    List<Employee> findEmployeeByCompanyName(String companyName);
}
