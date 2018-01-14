package com.jiyun.erp.base;

import java.util.List;

public interface BaseService<T> {
	//查所有（不分页）
		List<T> list();
		//分页查
		List<T> pageList(int pageNo, int pageSize, BaseVo baseVo);
		//总条数
		int totalCount(BaseVo baseVo);
		void save(T t);
		void delete(T t);
		T findById(Integer id);
		void update(T t);
}
