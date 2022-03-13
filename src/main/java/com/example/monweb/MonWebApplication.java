package com.example.monweb;

import DAO.AdresseRepository;
import DAO.UserRepository;
import entities.Adresse;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller","service", "entities", "DAO"})
@EnableJpaRepositories("DAO")
@EntityScan("entities")
public class MonWebApplication implements CommandLineRunner {

    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(MonWebApplication.class, args);
        System.out.println("le server est lance");
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Jack", "priso",17,null);
        User user2 = new User("Lydie", "priso",17,null);

        Adresse adresse1 = new Adresse("ahnhof",25,null);
        Adresse adresse2 = new Adresse("Eichen",22,null);
        Adresse adresse3 = new Adresse("Müll",69,null);

        userRepository.save(user1);
        userRepository.save(user2);




        adresse1.addUser(user1);
        adresse2.addUser(user2);
        adresse3.addUser(user1);

        /*user1.addAdresse(adresse1);
        user2.addAdresse(adresse2);
        user2.addAdresse(adresse3);*/
        adresseRepository.save(adresse1);
        adresseRepository.save(adresse2);
        adresseRepository.save(adresse3);

    }
}
