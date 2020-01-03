package com.bridgelabz.fundoonotes.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Label {
	@Id
	private String labelId;
	private String labelName;
	private String userId;
	private LocalDateTime creationTime;
	private LocalDateTime updationTime;


	public Label() {

	}

	public Label(String labelId, String labelName, String userId, LocalDateTime creationTime, LocalDateTime updationTime) {
		super();
		this.labelId = labelId;
		this.labelName = labelName;
		this.userId = userId;
		this.creationTime = creationTime;
		this.updationTime = updationTime;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime localDateTime) {
		this.creationTime = localDateTime;
	}

	public LocalDateTime getUpdationTime() {
		return updationTime;
	}

	public void setUpdationTime(LocalDateTime localDateTime) {
		this.updationTime = localDateTime;
	}

	@Override
	public String toString() {
		return "Label [labelId=" + labelId + ", labelName=" + labelName + ", userId=" + userId + ", creationTime="
				+ creationTime + ", updationTime=" + updationTime + "]";
	}

}
