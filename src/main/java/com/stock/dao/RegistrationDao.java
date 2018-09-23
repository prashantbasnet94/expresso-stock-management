package com.stock.dao;


 
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Registration")
public class RegistrationDao {


 
	public RegistrationDao(String first_name, String last_name, String user_id, String email, String dob,
			String password) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_id = user_id;
		this.email = email;
		this.dob = dob;
		this.password = password;
	}

	private String first_name;
	

	private String last_name;
	
	@Id
	private String user_id;
	

	private String email;
	

	private String dob;
	
	private String password;

 
	
	
	
	
	
	

}
