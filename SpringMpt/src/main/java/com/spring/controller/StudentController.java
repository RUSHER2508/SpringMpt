package com.spring.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.beans.Admin;
import com.spring.beans.Student;
import com.spring.services.Services;

@Controller
public class StudentController {

	@Autowired
	Services services;
	AnnotationConfigApplicationContext adminctx= 
			new AnnotationConfigApplicationContext(Admin.class);


	@GetMapping(value="/getDetails")
	public String get() {
		return "get";
	}

	@RequestMapping(value="/getDetails",method= RequestMethod.POST)
	public ModelAndView getStudent(HttpServletRequest req,ModelAndView mv) {

		Integer regno = Integer.parseInt(req.getParameter("regno"));
		Student student = services.searchStudent(regno);
		System.out.println(student);
		mv.addObject("student",student);
		mv.setViewName("searchStudent");

		return mv;

	}
	@GetMapping(value="/createStudent")
	public String createStudent() {
		return "create";
	}

	@PostMapping(value="/createStudent")
	public ModelAndView createStudent(HttpServletRequest req,ModelAndView mv) {
		Integer regno = Integer.parseInt(req.getParameter("regno"));
		String fname= req.getParameter("fname");
		String lname= req.getParameter("lname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Double monthlyMarks= Double.parseDouble(req.getParameter("mmarks"));
		Double quaterlyMarks= Double.parseDouble(req.getParameter("qmarks"));
		Double aggregateMarks = Double.parseDouble(req.getParameter("aggregate"));
		Student student = new Student();
		student.setLname(lname);
		student.setPassword(password);
		student.setRegno(regno);
		student.setFname(fname);
		student.setAggregateMarks(aggregateMarks);
		student.setEmail(email);
		student.setMonthlyMarks(monthlyMarks);
		student.setQuaterlyMarks(quaterlyMarks);
		Boolean s = services.createStudent(student);
		if(s) {
			System.out.println("Done");
			mv.addObject("student",student);
			mv.setViewName("createS");
			
		}
		else {
			System.out.println("Error");
		}
		return mv;

	}

	
	@GetMapping(value="/deleteStudent")
	public String delete() {
		return "deletePage";
	}
	
	
	@PostMapping(value="/deleteStudent")
public ModelAndView deletePage(HttpServletRequest req,ModelAndView mv)
{
		Student student = new Student();
		Integer regno = Integer.parseInt(req.getParameter("regno"));
		Boolean c = services.deleteStudent(regno);
		if(c) {
		mv.addObject("student",student);
		mv.setViewName("delete");
		}
		else {
			System.out.println("error");
		}
		return mv;
}
	
	@GetMapping("/userHome")
	public String userHomePage(){
		return "userHome";
	}

	@GetMapping("/logout")
	public void logOut(HttpServletRequest req,HttpServletResponse resp)
	{
		HttpSession session=req.getSession();
		if(session!=null){
			session.invalidate();
			Cookie cookie [] = req.getCookies();
			if(cookie!=null){
				for(Cookie c: cookie){
					if(c.getName().equals("JSESSIONID")){
						c.setMaxAge(0);
						resp.addCookie(c);
						break;
					}
				}
			}
		
			try {
				resp.sendRedirect("./login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				resp.sendRedirect("./login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}

	}
	
	@GetMapping(value="/update")
	public String updateUserPage() {
		return "update";
	}

	@PostMapping(value="/update")
	public ModelAndView updateUser(HttpServletRequest req,ModelAndView mv) {
		Admin admin = adminctx.getBean(Admin.class,"admin");
		Admin tempUser=(Admin) req.getSession().getAttribute("admin");
		admin.setAdminId(tempUser.getAdminId());
		int regno = Integer.parseInt(req.getParameter("regno"));
		String oldEmail = req.getParameter("oldEmail");
		String newEmail = req.getParameter("newEmail");
		Boolean u = services.updateStudent(regno, oldEmail, newEmail);
		String updatedMessage = "Updated successfully";
		if(u) {
			System.out.println("Updated successfully");
			mv.addObject("updatedMessage",updatedMessage);
			mv.setViewName("updatedMessage");
			return mv;

		}
		else {
			System.out.println("Not updated");
		}
		return null;
	}
	
	@GetMapping(value="/aggregate")
	public String aggregate() {
		return "aggregate";
	
	}
	
	@PostMapping(value="/aggregate")
	public ModelAndView aggregatePage(HttpServletRequest req,ModelAndView mv) {

		int regno = Integer.parseInt(req.getParameter("regno"));
		double monthlyMarks = Double.parseDouble(req.getParameter("mmarks"));
		 double quaterlyMarks = Double.parseDouble(req.getParameter("qmarks"));
		 Double aggregate = services.aggregate(regno, monthlyMarks, quaterlyMarks);
		 mv.addObject("aggregate",aggregate);
		 mv.setViewName("aggregatePage");
		return mv;
	
	}
	
	@GetMapping(value="/grade")
	public String gradePage() {
		return "grade";
	}
	
	@PostMapping(value="/grade")
	public ModelAndView grade(HttpServletRequest req,ModelAndView mv) {
		int regno =Integer.parseInt(req.getParameter("regno"));
		double aggregate= Double.parseDouble(req.getParameter("aggregate"));
		String grade=services.grade(regno, aggregate);
		mv.addObject("grade",grade);
		mv.setViewName("gradePage");
		return mv;
		
	}
	

}
