package org.veromatrix.trame.entryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class TrameEntryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrameEntryServiceApplication.class, args);
	}

}
