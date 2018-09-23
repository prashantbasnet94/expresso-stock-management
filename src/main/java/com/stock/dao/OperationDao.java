package com.stock.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StockDao;

public class OperationDao {
	
	
 
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(RegistrationDao.class)
													.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			
			/*String dateRaw = "06/27/2007";
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date date = (Date)formatter.parse(dateRaw);  */
			
			
			RegistrationDao tempRegis =new RegistrationDao("prashant","basnet","prashantbast","prashant.basnet@selu.edu",date,"hob33");
			
			session.beginTransaction();
			session.save(tempRegis);
			
			session.getTransaction().commit();
			
			
			/*
			 	System.out.println("create a new studnet object");
				StockDao tempStudent = new StockDao( 4, "prashant","azela2",0, 0, 0, 0, "1.4b", 0);
				
				//start a transaction
				session.beginTransaction();
				
				//save the student object
				System.out.println("Saving the student....");
				session.save(tempStudent);
				
				
				//comit transaction
				session.getTransaction().commit();
			 */
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
												
			

}
