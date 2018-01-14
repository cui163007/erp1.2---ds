package com.jiyun.erp.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jiyun.erp.base.BaseDaoImpl;
import com.jiyun.erp.base.BaseVo;
import com.jiyun.erp.dao.DeptDao;
import com.jiyun.erp.pojo.Dept;
import com.jiyun.erp.vo.DeptVo;

public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao {

	public void buildCriteria(DetachedCriteria criteria,BaseVo baseVo){
		
	DeptVo deptVo=(DeptVo) baseVo;
	
	if(deptVo!=null){
		if(deptVo.getTelephone()!=null && !"".equals(deptVo.getTelephone())){
			criteria.add(Restrictions.eq("telephone", deptVo.getTelephone()));
		}
		if(deptVo.getName()!=null &&!"".equals(deptVo.getName())){
			criteria.add(Restrictions.like("name", "%"+deptVo.getName()+"%"));
		}
	}
	}

}
