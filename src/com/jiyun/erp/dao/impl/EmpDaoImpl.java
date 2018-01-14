package com.jiyun.erp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.jiyun.erp.dao.EmpDao;
import com.jiyun.erp.pojo.Emp;

public class EmpDaoImpl implements EmpDao {

	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public Emp login(Emp emp) {
		 List<Emp> empList = hibernateTemplate.findByExample(emp);
		 if(empList!=null && empList.size()>0){
			 return empList.get(0);
		 }
		 return null;
	}


	public void update(Emp emp) {
		hibernateTemplate.update(emp);
	}

}
