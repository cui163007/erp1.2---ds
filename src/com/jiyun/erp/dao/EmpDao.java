package com.jiyun.erp.dao;

import com.jiyun.erp.pojo.Emp;

public interface EmpDao {

	Emp login(Emp emp);

	void update(Emp emp);

}
