package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 

@SpringBootApplication
@ComponentScan(basePackages = { "com.stock.service","com.stock.Controllers","com.stock.dao","com.stock.login"} )
@EntityScan(basePackages={"com.stock.dao"})

 
@EnableJpaRepositories("com.stock.registration")
 public class StockManagementSystemApplication {
	@Autowired
	
	
	public static void main(String[] args) {
	/*	Thread thread = new Thread(update);
		thread.start();
		*/
		SpringApplication.run(StockManagementSystemApplication.class, args);
	}
	 
	
}
