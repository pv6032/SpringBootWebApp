package com.pankaj.pkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String index() {
		//return "home.jsp";
		return "home";
	}
	
	/*
	@RequestMapping("home")
	@ResponseBody
	public String home() {
		return "home.jsp";
	}
	*/
	@RequestMapping("page1")
	public String p1() {
		return "pages/firstPage.jsp";
	}
	
	
	//////////////////////////////////////////////////   AFTER USING application.properties file     \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@RequestMapping("page2")
	public String p2() {
		return "secondPage";
	}
	
	@RequestMapping("page3")
	public String p3(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("Name: "+name);
		HttpSession session = request.getSession();
		session.setAttribute("myName", name);
		return "thirdPage";
	}
	
	@RequestMapping("page4") 
	public String p4(String name, HttpSession session) {
		session.setAttribute("yourName", name);
		return "fourthPage";
	}
	
	@RequestMapping("page5")
	public String p5(@RequestParam("name")String name5, HttpSession session) {  
		session.setAttribute("fifthName", name5);
		return "fifthPage";
	}
	
	@RequestMapping("page6")
	public ModelAndView p6(@RequestParam("name")String name6) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("sixthName", name6);
		mv.setViewName("sixthPage");
		return mv;
	}
	
	@RequestMapping("page7")  // http://localhost:8080/page7?alienId=7&alienName=Pankaj&alienLanguage=Marathi
	public ModelAndView p7(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("seventhPage");
		return mv;
	}
	
}