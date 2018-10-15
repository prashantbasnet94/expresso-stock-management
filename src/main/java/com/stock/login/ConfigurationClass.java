package com.stock.login;


import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages="com.stock")
public class ConfigurationClass{
	@Autowired
	private Environment environment;
	
	private Logger logger =Logger.getLogger(getClass().getName());

	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource 
										= new ComboPooledDataSource();
		
		
		//set up the jdbc driver class
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// log the connection props
		logger.info(">>>>>>>>"+environment.getProperty("jdbc.url"));
		logger.info(">>>>>>>>"+environment.getProperty("jdbc.user"));
		
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));

		securityDataSource.setInitialPoolSize(getIntProperty("connectoin.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connectoin.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connectoin.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connectoin.pool.maxIdleTime"));

		
		return 		securityDataSource;
	
		
	 
	}
	
	private int getIntProperty(String propName) {
		String propVal =environment.getProperty(propName);
			
		//now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
		
}
	
	
}
