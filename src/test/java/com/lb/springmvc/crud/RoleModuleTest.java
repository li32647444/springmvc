package com.lb.springmvc.crud;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lb.springmvc.domain.Module;
import com.lb.springmvc.domain.Role;
import com.lb.springmvc.service.ModuleService;
import com.lb.springmvc.service.RoleService;
import com.lb.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-common.xml")
public class RoleModuleTest {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
	@Test
	public void addRoleModule(){
		Module module1 = new Module("用户管理","/user/list",1,1);
		Module module1_1 = new Module("用户列表","/user/list",2,1);
		moduleService.add(module1_1);
		Module module1_2 = new Module("新增用户","/user/add",2,2);
		moduleService.add(module1_2);
		Module module1_3 = new Module("修改列表","/user/update",2,3);
		moduleService.add(module1_3);
		Module module1_4 = new Module("删除列表","/user/delete",2,4);
		moduleService.add(module1_4);
		List<Module> childrens1= new ArrayList<Module>();
		childrens1.add(module1_1);
		childrens1.add(module1_2);
		childrens1.add(module1_3);
		childrens1.add(module1_4);
		module1.setModuleChildrens(childrens1);
		moduleService.add(module1);
		Role role = new Role("管理员");
		role.setModules(childrens1);
		roleService.add(role);
	}
	
	
	
}
