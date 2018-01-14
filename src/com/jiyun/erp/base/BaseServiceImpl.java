package com.jiyun.erp.base;

import java.util.List;

public class BaseServiceImpl<T,E extends BaseDao<T>> {
	
	private E deptDao;
	
	public void setDeptDao(E deptDao) {
		this.deptDao = deptDao;	
	}	

	public List<T> list() {
		return deptDao.list();
	}


	public List<T> pageList(int pageNo, int pageSize, BaseVo baseVo) {
		return deptDao.pageList(pageNo,pageSize,baseVo);
	}


	public int totalCount(BaseVo baseVo) {
		return deptDao.totalCount(baseVo);
	}


	public void save(T t) {
		deptDao.save(t);
	}


	public void delete(T t) {
		deptDao.delete(t);
	}


	public T findById(Integer id) {
		return deptDao.findById(id);
	}


	public void update(T t) {
		deptDao.update(t);
	}
}
