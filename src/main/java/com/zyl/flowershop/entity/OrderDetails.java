package com.zyl.flowershop.entity;

public class OrderDetails {
	private Integer odid;
	private String num;
	private String fname;
	private Double price;
	private String intro;
	private Long oid;
	private String sale;
	private String flowerFirstImg;

	public OrderDetails() {
	}

	public OrderDetails(String num, String fname, Double price, String sale, String intro, String flowerFirstImg,
			Long oid) {
		super();

		this.num = num;
		this.fname = fname;
		this.price = price;
		this.sale = sale;

		this.flowerFirstImg = flowerFirstImg;
		this.intro = intro;
		this.oid = oid;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getFlowerFirstImg() {
		return flowerFirstImg;
	}

	public void setFlowerFirstImg(String flowerFirstImg) {
		this.flowerFirstImg = flowerFirstImg;
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

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "OrderDetails [odid=" + odid + ", num=" + num + ", fname=" + fname + ", price=" + price + ", intro="
				+ intro + ", oid=" + oid + ", sale=" + sale + ", flowerFirstImg=" + flowerFirstImg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flowerFirstImg == null) ? 0 : flowerFirstImg.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
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
		if (flowerFirstImg == null) {
			if (other.flowerFirstImg != null)
				return false;
		} else if (!flowerFirstImg.equals(other.flowerFirstImg))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
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
