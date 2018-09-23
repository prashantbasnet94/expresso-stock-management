package com.stock.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

;

public class HibernateOperator {
	
 
	
 
	public static void save(HttpServletRequest request,@Valid @ModelAttribute("data") UserImplements theRegis) {


		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(RegistrationDao.class)
													.buildSessionFactory();
		Session session =factory.getCurrentSession();
		
		try {
			System.out.println("<----------------------->");
			System.out.println(request.getParameter("dob"));
		 
		/*	DateFormat formatter = new SimpleDateFormat("MM-DD-YYYY");
			Date date = (Date)formatter.parse(request.getParameter("dob"));  */
			
	 

			
			RegistrationDao tempRegis =new RegistrationDao(theRegis.getFirst_name(),
														   theRegis.getLast_name(),
														   theRegis.getUser_id(),
														   theRegis.getEmail(),
														   request.getParameter("dob"),
														   theRegis.getPassword());
			
			session.beginTransaction();
			session.save(tempRegis);
			
			session.getTransaction().commit();
			
			
			 
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
 
												
							
			

}
