package com.csn.comment.bean;

import java.io.Serializable;

public class BaseBean implements Serializable {
	
	private Page page;
	
	public BaseBean() {
	    this.page = new Page();
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}