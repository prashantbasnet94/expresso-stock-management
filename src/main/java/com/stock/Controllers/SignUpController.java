package com.stock.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.dao.HibernateOperator;
import com.stock.dao.RegistrationDao;
import com.stock.dao.UserImplements;

@Controller
public class SignUpController {
	private HibernateOperator hibernateOperator;


	@GetMapping("/signUp")
	public String SignUp(Model  model) {
		System.out.println("<------------------------------------------------------");

		UserImplements tempRegis = new UserImplements( );
		model.addAttribute("data",tempRegis);
		return "signUp";
		
	}
	
	

	
	@RequestMapping("/authenticate")
	public String processForm(HttpServletRequest request,
			@Valid @ModelAttribute("data") UserImplements theRegis,
			BindingResult theBindingResult) {
	 
		if (theBindingResult.hasErrors()) {
			System.out.println(theBindingResult.toString());
			return "signUp";
		}
		else {
			
			
			System.out.println("----------------------------about to save -------------------------");
			hibernateOperator.save(request, theRegis);
			return "login";
		}
			
		 
		
		 
		 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	@RequestMapping("/authenticate")
	public String authenticate( HttpServletRequest request, Model model) {
		

		
		String firstName =request.getParameter("firstName");
	
		

		System.out.println();
	
		 return"index";
	
	}*/
	
	
	
}