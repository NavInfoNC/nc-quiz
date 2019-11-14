package com.tecyle.question.model;

import com.tecyle.question.core.MdChoiceQuestion;

public class ViewChoiceObject {
	private MdChoiceQuestion question;
	private String[] answerClass;
	private String[] answerChecked;
	private String score;
	private String maxScore;
	public MdChoiceQuestion getQuestion() {
		return question;
	}
	public void setQuestion(MdChoiceQuestion question) {
		this.question = question;
	}
	public String[] getAnswerClass() {
		return answerClass;
	}
	public void setAnswerClass(String[] answerClass) {
		this.answerClass = answerClass;
	}
	public String[] getAnswerChecked() {
		return answerChecked;
	}
	public void setAnswerChecked(String[] answerChecked) {
		this.answerChecked = answerChecked;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(String maxScore) {
		this.maxScore = maxScore;
	}
}
