package com.lb.springmvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.lb.springmvc.dao.RoleDao;
import com.lb.springmvc.dao.base.impl.GenericDaoImpl;
import com.lb.springmvc.domain.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao{
	
}
