package com.zyl.flowershop.entity;

import lombok.Data;

@Data
public class OrderDetails {
	private Integer odid;
	private String num;
	private String fname;
	private Double price;
	private String sale;
	private Long oid;

	public OrderDetails(String num, String fname, Double price, String sale, Long oid) {
		super();

		this.num = num;
		this.fname = fname;
		this.price = price;
		this.sale = sale;
		this.oid = oid;
	}

	public Integer getOdid() {
		return odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "OrderDetails [odid=" + odid + ", num=" + num + ", fname=" + fname + ", price=" + price + ", sale="
				+ sale + ", oid=" + oid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((odid == null) ? 0 : odid.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (odid == null) {
			if (other.odid != null)
				return false;
		} else if (!odid.equals(other.odid))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
	}

}
