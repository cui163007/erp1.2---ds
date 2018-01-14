package com.jiyun.erp.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//先判断session中，是否存在该用户信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object emp = session.getAttribute("emp");
		if(emp==null){
			return "login";
		}
		return arg0.invoke();//放行
	}

}
