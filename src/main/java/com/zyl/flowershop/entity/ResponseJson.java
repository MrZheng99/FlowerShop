package com.zyl.flowershop.entity;

public class ResponseJson {
	private Integer status;
	private String msg;
	private Object data;
	private Boolean success;

	public ResponseJson() {
	}

	public ResponseJson(Integer status) {
		this.status = status;
		this.msg = null;
		this.data = null;
		this.success = null;
	}

	public ResponseJson(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
		this.data = null;
		this.success = null;
	}

	public ResponseJson(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.success = null;
	}

	public ResponseJson(Integer status, String msg, Object data, Boolean success) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.success = success;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ResponseJson [status=" + status + ", msg=" + msg + ", data=" + data + ", success=" + success + "]";
	}

}
