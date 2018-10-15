package com.example.demo;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.stock.thread.populateApi.MainDatabasePopulate;

@SpringBootApplication
 
@ComponentScan(basePackages = { "com.stock.Controllers","com.stock.restController","com.stock.service"} )

public class StockManagementSystemApplication {

	@Autowired
	static
	MainDatabasePopulate populate = new MainDatabasePopulate();
	
	public static void main(String[] args) {
		Thread thread = new Thread(populate);
		thread.start();
		
		System.out.println("--------------------------------------------------------------------------------");
		SpringApplication.run(StockManagementSystemApplication.class, args);
		
	
		
	
	}
	
	 
	
}
