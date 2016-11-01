package com.lb.springmvc.controller;

import java.util.List;

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
public class RegisterController extends BaseController{

	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping(value = { "register" }, method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || "".equals(username)){
			return "请输入用户名！";
		} else if(password == null || "".equals(password)){
			return "请输入密码！";
		}
		List<User> list = userService.getByObject(new User(username));
		if(list != null && list.size()>0){
			return "该用户名已注册！";
		}
		userService.add(new User(username, password, 1));
		return "success";
	}

}
