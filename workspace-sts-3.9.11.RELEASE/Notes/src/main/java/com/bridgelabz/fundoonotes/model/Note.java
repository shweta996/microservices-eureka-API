package com.bridgelabz.fundoonotes.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Note {
	@Id
	private String noteId;
	private String title;
	private String description;
	private LocalDateTime creationTime;
	private LocalDateTime updatedTime;
	private String userId;
	private boolean isArchieve;
	private boolean isTrash;
	private boolean isPin;
	private String colorCode;
	@DBRef
	private List<Label> labelList;

	public Note() {

	}

	public Note(String title, String description, LocalDateTime creationTime, LocalDateTime updatedTime, String userId,
			boolean isArchieve, boolean isTrash, boolean isPin, String colorCode, List<Label> labelList) {
		super();
		this.title = title;
		this.description = description;
		this.creationTime = creationTime;
		this.updatedTime = updatedTime;
		this.userId = userId;
		this.isArchieve = isArchieve;
		this.isTrash = isTrash;
		this.isPin = isPin;
		this.colorCode = colorCode;
		this.labelList = labelList;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isArchieve() {
		return isArchieve;
	}

	public void setArchieve(boolean isArchieve) {
		this.isArchieve = isArchieve;
	}

	public boolean isTrash() {
		return isTrash;
	}

	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}

	public boolean isPin() {
		return isPin;
	}

	public void setPin(boolean isPin) {
		this.isPin = isPin;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<Label> labelList) {
		this.labelList = labelList;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", description=" + description + ", creationTime="
				+ creationTime + ", updatedTime=" + updatedTime + ", userId=" + userId + ", isArchieve=" + isArchieve
				+ ", isTrash=" + isTrash + ", isPin=" + isPin + ", colorCode=" + colorCode + ", labelList=" + labelList
				+ "]";
	}

	
}
