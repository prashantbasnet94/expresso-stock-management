package com.stock.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	
	 
	@GetMapping("/signed")
	public String SignUp() {
	

	//	UserImplements tempRegis = new UserImplements( );
	//	model.addAttribute("data",tempRegis);
		return "signed";
		
	}

 
	
	
}
