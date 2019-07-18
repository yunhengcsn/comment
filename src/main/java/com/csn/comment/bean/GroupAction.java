package com.csn.comment.bean;

import java.io.Serializable;

public class GroupAction implements Serializable {
	
	private Long groupId;
	private Long actionId;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getActionId() {
		return actionId;
	}
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
}