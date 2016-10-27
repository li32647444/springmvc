package com.lb.springmvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.lb.springmvc.dao.ModuleDao;
import com.lb.springmvc.dao.base.impl.GenericDaoImpl;
import com.lb.springmvc.domain.Module;

@Repository
public class ModuleDaoImpl extends GenericDaoImpl<Module> implements ModuleDao{
	
}
