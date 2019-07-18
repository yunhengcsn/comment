package com.csn.comment.bean;

import java.io.Serializable;
import java.util.Date;

public class SysParam implements Serializable {
	
	private String paramKey;
	private Date paramValue;
	private String paramDesc;
	
	public String getParamKey() {
		return paramKey;
	}
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}
	public Date getParamValue() {
		return paramValue;
	}
	public void setParamValue(Date paramValue) {
		this.paramValue = paramValue;
	}
	public String getParamDesc() {
		return paramDesc;
	}
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
}