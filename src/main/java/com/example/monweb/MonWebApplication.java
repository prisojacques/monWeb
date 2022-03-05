package com.example.monweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller","service", "entities", "DAO"})
@EnableJpaRepositories("DAO")
@EntityScan("entities")
public class MonWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(MonWebApplication.class, args);
    }

}
