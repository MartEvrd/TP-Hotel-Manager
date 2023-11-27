package com.epita.spring.tphotelmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TpHotelManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpHotelManagementApplication.class, args);
        System.out.println("-----------------------------------");
        System.out.println("Application Spring lancée avec succès !");
        System.out.println("-----------------------------------");
    }

}
