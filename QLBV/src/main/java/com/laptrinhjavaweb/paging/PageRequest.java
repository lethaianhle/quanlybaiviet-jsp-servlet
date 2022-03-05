package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private Sorter sort;

	public PageRequest(Integer page, Integer maxPageItem) {
		this.page = page;
		this.maxPageItem = maxPageItem;
	}
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sort) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getOffSet() {
		if(this.page != null && this.maxPageItem != null) {
			return (this.page - 1) * this.maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	public Sorter getSort() {
		return this.sort;
	}

	public void setSort(Sorter sort) {
		this.sort = sort;
	}

	@Override
	public Sorter getSorter() {
		if(this.sort != null) {
			return this.sort;
		}
		return null;
	}


}
