package com.zyl.flowershop.entity;

public class ChatMessage {
	private String msg;
	private Integer uid;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public ChatMessage(String msg, Integer uid) {
		super();
		this.msg = msg;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "ChatMessage [msg=" + msg + ", uid=" + uid + "]";
	}

}
