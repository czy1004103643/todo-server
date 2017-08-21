package com.tms.entity;

public class Agenda {
	
	private int id;
	private String content;
	private String time;
	private long userId;
	private User user;
	private int luckyMoney;
	private int status;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getLuckyMoney() {
		return luckyMoney;
	}
	public void setLuckyMoney(int luckyMoney) {
		this.luckyMoney = luckyMoney;
	}
}
