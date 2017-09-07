package com.ly.common;

import java.util.List;

/**
* @ClassName: LyPage
* @Description: 
* @author linyan
* @date 2017年7月17日 下午2:54:37
*
*/
public class LyPage<T> {

	private int total;

	private int first;
	
	private int end;
	
	private int pageNo;
	
	private List<T> data;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getEnd() {
		
		
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
