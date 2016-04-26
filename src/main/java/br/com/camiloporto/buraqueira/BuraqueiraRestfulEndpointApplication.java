package br.com.camiloporto.buraqueira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BuraqueiraRestfulEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuraqueiraRestfulEndpointApplication.class, args);
	}
}
