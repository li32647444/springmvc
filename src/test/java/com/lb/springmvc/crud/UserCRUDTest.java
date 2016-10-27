package com.lb.springmvc.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.lb.springmvc.domain.User;
import com.lb.springmvc.util.Hibernate4Util;

public class UserCRUDTest {

	@SuppressWarnings("unchecked")
	@Test
	public void list(){
		List<User> list = Hibernate4Util.getCurrentSession().createQuery("FROM User").list();
		if(list!=null && list.size()>0){
			for(User u:list){
				System.out.println(u);
			}
		} else {
			System.out.println("User data does not exist! The table is empty.");
		}
	}
	
	@Test
	public void add(){
		User user = new User("admin","123456",1);
		Hibernate4Util.getCurrentSession().save(user);
		System.out.println("Save success!");
	}
	
	@Test
	public void save(){
		User user = new User("admin","123456",1);
		Session session = Hibernate4Util.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		System.out.println("Save success!");
	}
	
	@Test
	public void update(){
		Session session = Hibernate4Util.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.get(User.class, 1L);
		u.setPassword("123123");
		tx.commit();
		session.close();
		System.out.println("Update success!");
	}
	
	@Test
	public void delete(){
		Session session = Hibernate4Util.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User u = (User) session.createQuery("FROM User u WHERE u.userName=:userName")
				.setParameter("userName", "admin")
				.uniqueResult();
		session.delete(u);
		tx.commit();
		session.close();
		System.out.println("Delete success!");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findByName(){
		Session session = Hibernate4Util.getCurrentSession();
		List<User> list = session.createCriteria(User.class)
					.add(Restrictions.eq("userName", "admin"))
					.list();
		if(list!=null && list.size()>0){
			for(User u:list){
				System.out.println(u);
			}
		} else {
			System.out.println("User data does not exist! The table is empty.");
		}
	}
}
