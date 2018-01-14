package com.jiyun.erp.base;

import java.util.List;

public interface BaseDao<T> {
	//查所有
		List<T> list();
		//分页查
		List<T> pageList(int pageNo, int pageSize, BaseVo baseVo);
		//获取总条数
		int totalCount(BaseVo baseVo);
		//新增
		void save(T t);
		//删除
		void delete(T t);
		//根据主键查询
		T findById(Integer id);
		void update(T t);
}
