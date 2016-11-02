package com.lb.springmvc.mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lb.springmvc.domain.User;
import com.lb.springmvc.mybatis.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-common.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void list(){
		List<User> list = userDao.list(null);
		if(list!=null && list.size()>0){
			for(User u:list){
				System.out.println(u);
			}
		} else {
			System.out.println("User data does not exist! The table is empty.");
		}
	}
	
	@Test
	public void findById(){
		User user = userDao.findById(1l);
		if(user!=null){
			System.out.println(user);
		} else {
			System.out.println("User is null!");
		}
	}
	
	@Test
	public void add(){
		User add = new User("5","1",1);
		userDao.add(add);
		System.out.println(add.getId());
		list();
	}
	
	@Test
	public void update(){
		User user = userDao.findById(5l);
		user.setPassword("password");
		userDao.update(user);
		list();
	}
	
	@Test
	public void delete(){
		userDao.delete(5l);
		list();
	}
	
}
