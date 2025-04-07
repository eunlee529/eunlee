package com.mbc.kee12;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.setAttribute("loginstate", false);
		return "main";
	}
	@RequestMapping(value = "/main")
	public String home1(Locale locale, Model model) {
		
		
		return "main";
	}
	
	
}
