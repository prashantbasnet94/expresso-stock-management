package com.stock.aop.populateApi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stock.test.Test;

public class CallerMain {

	public static void main(String[] args) {
	 
		AnnotationConfigApplicationContext context =
													new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		//Now getting beans from the spring container context
		Test hey = context.getBean("test",Test.class);
		
		hey.test1();
		
		context.close();
	}

}
