package com.lb.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.springmvc.dao.ModuleDao;
import com.lb.springmvc.domain.Module;
import com.lb.springmvc.service.ModuleService;
import com.lb.springmvc.service.base.impl.BaseServiceImpl;

@Service(value="moduleService")
public class ModuleServiceImpl extends BaseServiceImpl<Module, ModuleDao> implements ModuleService{
	
	@Autowired
	private ModuleDao moduleDao;
	
	public void setUserDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
}
