package com.lb.springmvc.crud;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lb.springmvc.domain.User;
import com.lb.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-common.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@SuppressWarnings("resource")
	@Test
	public void springCfgTest() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext-common.xml");
			context.start();
			System.out.println("start");
			UserService userService = (UserService) context.getBean("userService");
			System.out.println(userService);
			User user = userService.findByUserNameAndPassword("admin", "123456");
			System.out.println(user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		System.out.println("=============list>>");
		List<User> list = userService.list();
		if (list != null && list.size() > 0) {
			for (User u : list) {
				System.out.println(u.getUserName() + " " + u.getPassword());
			}
		} else {
			System.out.println("Users is null!");
		}
	}

	@Test
	public void add(){
		User add  = new User("1","1",1);
		userService.add(add);
		list();
	}

	@Test
	public void update(){
		User update = userService.list().get(1);
		update.setUserName("11");
		userService.update(update);
		list();
	}
	
	@Test
	public void delete(){
		User delete = userService.list().get(1);
		userService.delete(delete.getId());
		list();
	}
	
}
