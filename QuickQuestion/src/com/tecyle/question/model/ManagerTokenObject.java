package com.tecyle.question.model;

public class ManagerTokenObject implements Comparable<ManagerTokenObject> {
	private String tokenHtml;
	private String userName;
	private String stateClass;
	private String state;
	private String score;
	private String token;
	public String getTokenHtml() {
		return tokenHtml;
	}
	public void setTokenHtml(String tokenHtml) {
		this.tokenHtml = tokenHtml;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStateClass() {
		return stateClass;
	}
	public void setStateClass(String stateClass) {
		this.stateClass = stateClass;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	@Override
	public int compareTo(ManagerTokenObject o) {
		// TODO Auto-generated method stub
		return token.compareTo(o.token);
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
