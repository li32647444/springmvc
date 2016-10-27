package com.lb.springmvc.crud;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lb.springmvc.domain.Role;
import com.lb.springmvc.domain.User;
import com.lb.springmvc.service.RoleService;
import com.lb.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-common.xml")
public class UserRoleTest {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@Test
	public void addUserRole(){
		Role role1 = new Role("管理员");
		roleService.add(role1);
		Role role2 = new Role("测试员");
		roleService.add(role2);
		List<Role> roles= new ArrayList<Role>();
		roles.add(role1);
		roles.add(role2);
		User user = new User("admin","123456",1);
		user.setRoles(roles);
		userService.add(user);
	}

	@Test
	public void delUser(){
		userService.delete(2l);
	}
}
