package com.lb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lb.springmvc.controller.base.BaseController;
import com.lb.springmvc.domain.User;
import com.lb.springmvc.service.UserService;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = { "/", "toLogin" }, method = RequestMethod.GET)
	public String toLogin(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}
	
	@RequestMapping(value = { "toQQLogin" }, method = RequestMethod.GET)
	public String toQQLogin(HttpServletRequest request, HttpServletResponse response) {
		return "qqlogin";
	}
	
	@RequestMapping(value = { "toShakeLogin" }, method = RequestMethod.GET)
	public String toShakeLogin(HttpServletRequest request, HttpServletResponse response) {
		return "login/shakeLogin";
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || "".equals(username)){
			request.setAttribute("msg", "请输入用户名！");
			return "请输入用户名！";
		} else if(password == null || "".equals(password)){
			request.setAttribute("msg", "请输入密码！");
			return "请输入密码！";
		}
		User user = userService.findByUserNameAndPassword(username, password);
		if(user == null){
			request.setAttribute("msg", "用户名或者密码错误！");
			return "用户名或者密码错误！";
		}
		return "success";
	}

}
