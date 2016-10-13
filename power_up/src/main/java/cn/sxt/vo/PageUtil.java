package cn.sxt.vo;

import java.util.List;

public class PageUtil {
	private int currentNum = 1;
	private int pageMaxNum;
	private int pageSize;
	private List<User> list;
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	public int getPageMaxNum() {
		return pageMaxNum;
	}
	public void setPageMaxNum(int pageMaxNum) {
		this.pageMaxNum = pageMaxNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public PageUtil(int currentNum, int pageMaxNum, int pageSize, List<User> list) {
		super();
		this.currentNum = currentNum;
		this.pageMaxNum = pageMaxNum;
		this.pageSize = pageSize;
		this.list = list;
	}
	public PageUtil() {
		super();
	}
	
	
}
