package com.example.mdm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private ICompany companyService;

    @GetMapping("/all")
    List<Company> all(){
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(34);
        ints.add(2);

        return companyService.findall();
    }
}
