package com.stock.aop.populateApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stock.test.Test;

public class CallerMain {

	public static void main(String[] args) {
		try {
			 
		   
	
		AnnotationConfigApplicationContext context =
													new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		//Now getting beans from the spring container context
		Test hey = context.getBean("test",Test.class);
		
		hey.test1();
		
		context.close();
		
		}catch(Exception e) {
			  
			 
		}
		
	}

}
