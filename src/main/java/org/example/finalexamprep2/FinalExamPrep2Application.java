package org.example.finalexamprep2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalExamPrep2Application {

    public static void main(String[] args) {
        SpringApplication.run(FinalExamPrep2Application.class, args);
    }

    @Bean
    public CommandLineRunner demoData(CustomerDao customerDao) {
        return args -> {
            customerDao.save(new Customer(115, "Jasper Diaz", "Savings De-luxe", 15000.0, 5));
            customerDao.save(new Customer(112, "Zanip Mendez", "Savings De-luxe", 5000.0, 2));
            customerDao.save(new Customer(113, "Geronima Esper", "Savings Regular", 6000.0, 5));
        };
    }

}
