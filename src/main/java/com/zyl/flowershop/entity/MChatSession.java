package com.zyl.flowershop.entity;

import javax.websocket.Session;

public class MChatSession {
	private Session session;
	private Admin admin;
	private User user;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public MChatSession(Session session, Admin admin, User user) {
		super();
		this.session = session;
		this.admin = admin;
		this.user = user;
	}

	@Override
	public String toString() {
		return "MChatSession [session=" + session + ", admin=" + admin + ", user=" + user + "]";
	}

}
