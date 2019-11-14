package com.tecyle.question.core;

public class MdJudgementQuestion extends MdQuestion {
	private String title;
	private boolean isCorrect;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
