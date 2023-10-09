package eu.deltasource.training.retailchain;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Log4j2
public class RetailchainApplication {

	public static void main(String[] args) {
		log.info("Before Starting application");
		SpringApplication.run(RetailchainApplication.class, args);
	}

}
