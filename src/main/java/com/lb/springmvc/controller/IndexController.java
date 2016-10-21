package com.lb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"/","toIndex"},method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,HttpServletResponse response){
		System.out.println("IndexController.toIndex()==>");
		return "index";
	}
	
}
