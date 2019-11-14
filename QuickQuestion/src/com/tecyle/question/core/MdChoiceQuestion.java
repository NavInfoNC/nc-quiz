package com.tecyle.question.core;

import java.util.List;

public class MdChoiceQuestion extends MdQuestion {
	private String title;
	private List<MdQuestionChoice> choices;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MdQuestionChoice> getChoices() {
		return choices;
	}
	public void setChoices(List<MdQuestionChoice> choices) {
		this.choices = choices;
	}
	
}
