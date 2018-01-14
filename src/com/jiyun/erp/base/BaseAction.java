package com.jiyun.erp.base;

public class BaseAction {
	private String msg;
	public int pageNo = 1;//当前页 --前台向后台传
	public int pageSize = 5;//每页条数大小--前台向后台传（目前没有改变）
	public int pageCount;//总页数 --后台向前台传
	public int totalCount;//总条数--后台向前台传
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
