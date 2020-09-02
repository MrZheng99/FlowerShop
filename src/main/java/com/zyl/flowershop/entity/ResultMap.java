package com.zyl.flowershop.entity;

/**
 * easyUi返回数据格式
 * 
 * @author ZM
 * @date 2020年9月2日
 */
public class ResultMap {
	private Integer total;
	private Object rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "ResultMap [total=" + total + ", rows=" + rows + "]";
	}

	public ResultMap(Integer total, Object rows) {
		this.total = total;
		this.rows = rows;
	}

}
