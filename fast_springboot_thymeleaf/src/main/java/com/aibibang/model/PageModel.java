package com.aibibang.model;
/** 
* @author：Truman.P.Du  
* @createDate: 2018年7月19日 上午10:00:50 
* @version:1.0
* @description: 分页实体
*/

import java.util.List;

public class PageModel<T> {
	/**
	 * 数据
	 */
	private List<T> data;
	/**
	 * 当前页码
	 */
	private int pageIndex = 0;
	/**
	 * 总页数
	 */
	private int pageCount = 0;
	/**
	 * 每页显示数量
	 */
	private int pageNum = 10;

	public PageModel(int pageCount, int pageNum, List<T> data) {
		this.pageCount = pageCount;
		this.pageNum = pageNum;
		this.data = data;
	}

	public PageModel(int pageCount, List<T> data) {
		this.pageCount = pageCount;
		this.data = data;
	}

	public PageModel(List<T> data) {
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
