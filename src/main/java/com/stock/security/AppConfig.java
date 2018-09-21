package com.stock.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //ADD OUR USERS
		 UserBuilder users =User.withDefaultPasswordEncoder();
		 
		 auth.inMemoryAuthentication()
		 							.withUser(users.username("john").password("test123").roles("Employee"))
		 							.withUser(users.username("prashant").password("basnet").roles("manager"));
		 							
		 	
	}

	
	
}
