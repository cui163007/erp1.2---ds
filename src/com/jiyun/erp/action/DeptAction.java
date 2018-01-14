package com.jiyun.erp.action;

import java.util.List;

import com.jiyun.erp.base.BaseAction;
import com.jiyun.erp.pojo.Dept;
import com.jiyun.erp.service.DeptService;
import com.jiyun.erp.vo.DeptVo;

public class DeptAction extends BaseAction{
	private DeptService deptService;
	private Dept dept;
	private List<Dept> list;
	private DeptVo deptVo;//查询参数

	

	public DeptVo getDeptVo() {
		return deptVo;
	}
	public void setDeptVo(DeptVo deptVo) {
		this.deptVo = deptVo;
	}
	
	public List<Dept> getList() {
		return list;
	}
	public void setList(List<Dept> list) {
		this.list = list;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	//查询（非分页）
	//	public String list(){
	//		list = deptService.list();
	//		return "success";
	//	}
	//查询（分页）
	public String list(){
		//分好页的记录
		list = deptService.pageList(pageNo,pageSize,deptVo);
		//总条数
		totalCount = deptService.totalCount(deptVo);
		//总页数  
		pageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		return "success";
	}
	//跳转到新增页面
	public String input(){
		return "success";
	}
	//保存
	public String save(){
		deptService.save(dept);
		return "toList";
	}
	//删除
	public String delete(){
		deptService.delete(dept);
		return "toList";
	}
	//跳转到修改页面
	public String toUpdate(){
		//单个对象查询，根据主键查询
		dept = deptService.findById(dept.getId());
		return "toUpdate";
	}
	//修改
	public String update(){
		deptService.update(dept);
		return "toList";
	}
}
