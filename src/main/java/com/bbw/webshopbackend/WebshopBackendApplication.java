package com.bbw.webshopbackend;

import com.bbw.webshopbackend.model.User;
import com.bbw.webshopbackend.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class WebshopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
// save a couple of customers
			repository.save(new User());
			repository.save(new User());
			repository.save(new User());
			repository.save(new User());
			repository.save(new User());
// fetch all customers

		};
	}

}
