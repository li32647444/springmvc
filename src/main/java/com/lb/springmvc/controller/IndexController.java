package com.lb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value = "toIndex")
	public String toIndex(HttpServletRequest request,HttpServletResponse response){
		return "index";
	}
	
}
