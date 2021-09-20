package com.sumativa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.Usuario;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login.jsp";
	}
	
	
//	@RequestMapping(value="/login",method = RequestMethod.GET)
//	public String login(@RequestParam(value="email") String email,
//			@RequestParam(value="password") String password) {
//		
//		System.out.println("parametros recibidos get: "+email+" "+ password);
//		
//		return "index.jsp";
//	}
//	
//	@RequestMapping(value="/login",method = RequestMethod.POST)
//	public String loginPost(@RequestParam(value="email") String email,
//			@RequestParam(value="password") String password) {
//		
//		System.out.println("parametros recibidos Post: "+email+" "+ password);
//		
//		return "index.jsp";
//	}
	
}
