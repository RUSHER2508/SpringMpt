package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.Admin;
import com.spring.services.Services;

@Controller
public class AdminController {
	
	@Autowired
	Services services;

	@GetMapping(value="/login")
	public String login() {
		return "adminLoginPage";
	}

	@PostMapping(value="/login")
	public ModelAndView loginPage(HttpServletRequest req,ModelAndView mv) {
		Admin admin = new Admin();

		int adminId= Integer.parseInt(req.getParameter("adminId"));

		String password = req.getParameter("password");
/*		Boolean c = services.login(adminId, password);
		if(c)
		{
		mv.addObject("admin",admin);
		mv.setViewName("msg");
		}
		else {
			System.out.println("Erroe");
		}
*/		Boolean a = services.login(adminId, password);
		if(a) {
		HttpSession session = req.getSession();	
		session.setAttribute("admin", admin);
		mv.setViewName("redirect:./userHome");
		}
		else {
			mv.setViewName("redirect:./login");
		}
		return mv;

	}

}
