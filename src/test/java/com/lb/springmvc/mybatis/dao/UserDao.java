package com.lb.springmvc.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lb.springmvc.domain.User;

@Repository
public interface UserDao {
	
	public List<User> list(User user);
	
	public User findById(Long id);

	public void add(User add);
	
	public void update(User add);
	
	public void delete(Long id);
}
