package com.lb.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.springmvc.dao.RoleDao;
import com.lb.springmvc.domain.Role;
import com.lb.springmvc.service.RoleService;
import com.lb.springmvc.service.base.impl.BaseServiceImpl;

@Service(value="roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDao> implements RoleService{
	
	@Autowired
	private RoleDao roleDao;
	
	public void setUserDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
}
