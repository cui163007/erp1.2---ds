package com.jiyun.erp.action;

import org.apache.struts2.ServletActionContext;

import com.jiyun.erp.pojo.Emp;
import com.jiyun.erp.service.EmpService;
import com.jiyun.erp.utils.MD5Utils;

public class EmpAction {
	private EmpService empService;
	private Emp emp;
	private String msg;

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	//登录
	public String login(){
		//登录时，将密码加密
		emp.setPassword(MD5Utils.md5(emp.getPassword()));
		emp = empService.login(emp);
		if(emp!=null){
			//登录成功，把用户信息放在session里。
			ServletActionContext.getRequest().getSession().setAttribute("emp", emp);
			return "main";
		}
		msg = "用户名或密码不存在，请重新输入！";
		//ActionContext.getContext().put("msg", "用户名或密码不存在，请重新输入！");
		return "login";
	}
	//跳转到修改页面
	public String toChangePwd(){
		return "changePwd";
	}
	//修改密码
	public String changePwd(){
		//先比较旧密码是否正确，再执行下面的操作
		String oldpassword = emp.getPassword();
		Emp emp1 = (Emp) ServletActionContext.getRequest().getSession().getAttribute("emp");
		if(emp1.getPassword().equals(MD5Utils.md5(oldpassword))){//旧密码正确，可以修改
			String newpassword = ServletActionContext.getRequest().getParameter("newpassword");
			emp1.setPassword(MD5Utils.md5(newpassword));
			empService.update(emp1);
			return "login";
		}
		msg = "原密码错误，请重新输入";
		return "changePwd";
	}
	//注销
}
