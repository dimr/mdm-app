package com.example.mdm.repositories;

import com.example.mdm.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String companyName);
}
