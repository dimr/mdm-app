package com.example.mdm;


import com.example.mdm.models.Company;
import com.example.mdm.repositories.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCompanies {
    private static final Logger log = LoggerFactory.getLogger(LoadCompanies.class);

    @Bean
    CommandLineRunner initDatabase(CompanyRepository repository){
        try {
            log.info("Preloading---->" + repository.save(new Company("Ebf", "9 Strasse")));
            log.info("Preloading---->" + repository.save(new Company("onelity", "12 Pylaiotika thessaloniki")));
            log.info("Preloading---->" + repository.save(new Company("comquent", "23 str Kentro")));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return args -> {
        };
    }

}
