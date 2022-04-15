package com.example.microservice;

import com.example.microservice.entities.Compte;
import com.example.microservice.repos.CompteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepo repo){
		return args -> {
			repo.save(new Compte(null,1000,new Date(), Compte.CompteType.COURANT));
			repo.save(new Compte(null,2000,new Date(), Compte.CompteType.COURANT));
			repo.save(new Compte(null,3000,new Date(), Compte.CompteType.EPARGNE));
			repo.save(new Compte(null,4000,new Date(), Compte.CompteType.EPARGNE));
			repo.findAll().forEach(c -> {
				System.out.println("------------");
				System.out.println(c.getId());
				System.out.println(c.getSolde());
				System.out.println(c.getDateCreation());
				System.out.println(c.getType());
			});
		};
	}
}
