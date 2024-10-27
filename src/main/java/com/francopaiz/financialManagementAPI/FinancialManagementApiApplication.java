package com.francopaiz.financialManagementAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

/*@EnableJpaRepositories(basePackages = "com.francopaiz.financialManagementAPI.repository.usuario.postgres")*/
public class FinancialManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialManagementApiApplication.class, args);
	}

}
