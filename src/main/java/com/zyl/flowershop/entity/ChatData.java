package com.zyl.flowershop.entity;

public class ChatData {
	private String msg;
	private String sendDate;
	private Boolean sendTo;
	private User user;
	private Admin admin;

	public ChatData(String msg, String sendDate, Boolean sendToUser, User user, Admin admin) {
		super();
		this.msg = msg;
		this.sendDate = sendDate;
		this.sendTo = sendToUser;
		this.user = user;
		this.admin = admin;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public Boolean getSendToUser() {
		return sendTo;
	}

	public void setSendToUser(Boolean sendToUser) {
		this.sendTo = sendToUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "ChatData [msg=" + msg + ", sendDate=" + sendDate + ", sendToUser=" + sendTo + ", user=" + user
				+ ", admin=" + admin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((sendTo == null) ? 0 : sendTo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatData other = (ChatData) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (sendTo == null) {
			if (other.sendTo != null)
				return false;
		} else if (!sendTo.equals(other.sendTo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
