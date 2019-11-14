package com.tecyle.question.model;

public class ViewScoreDetailObject {
	public String getItemClass() {
		return itemClass;
	}
	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemScore() {
		return itemScore;
	}
	public void setItemScore(String itemScore) {
		this.itemScore = itemScore;
	}
	public String getItemMaxScore() {
		return itemMaxScore;
	}
	public void setItemMaxScore(String itemMaxScore) {
		this.itemMaxScore = itemMaxScore;
	}
	private String itemClass;
	private String itemName;
	private String itemScore;
	private String itemMaxScore;
}
