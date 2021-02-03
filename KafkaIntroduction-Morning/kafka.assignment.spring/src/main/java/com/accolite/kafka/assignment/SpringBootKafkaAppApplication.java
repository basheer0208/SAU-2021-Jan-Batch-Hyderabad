package com.accolite.kafka.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootKafkaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaAppApplication.class, args);
	}
}
