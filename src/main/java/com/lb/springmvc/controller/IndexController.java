package com.lb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	// 添加slf4j日志实例对象
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = {"toIndex"},method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,HttpServletResponse response){
		return "index";
	}
	
	@RequestMapping(value = {"toNotFound"},method = RequestMethod.GET)
	public String toNotFound(HttpServletRequest request,HttpServletResponse response){
		return "notFound";
	}
	
}
