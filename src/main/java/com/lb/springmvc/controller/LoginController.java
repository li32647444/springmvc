package com.lb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
		private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

		@RequestMapping(value = {"/","toLogin"},method = RequestMethod.GET)
		public String toLogin(HttpServletRequest request,HttpServletResponse response){
			return "login";
		}
		
		@RequestMapping(value = {"Login"},method = RequestMethod.GET)
		public String login(HttpServletRequest request,HttpServletResponse response){
			return "index";
		}
}
