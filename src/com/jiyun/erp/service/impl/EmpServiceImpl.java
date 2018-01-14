package com.jiyun.erp.service.impl;

import com.jiyun.erp.dao.EmpDao;
import com.jiyun.erp.pojo.Emp;
import com.jiyun.erp.service.EmpService;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}


	public Emp login(Emp emp) {
		return empDao.login(emp);
	}


	public void update(Emp emp) {
		empDao.update(emp);
	}

}
