package com.zyl.flowershop.entity;

/**
 * 花
 * 
 * @author ZM
 * @date 2020年9月1日
 */
public class Flower {
	private Integer fid;
	private String fname;
	private String description;
	private String flowerLan;
	private String deliveryDesc;
	private Double price;
	private String flowerImg;
	private String sale;
	private FlowerType type;
	private FlowerSeries series;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlowerLan() {
		return flowerLan;
	}

	public void setFlowerLan(String flowerLan) {
		this.flowerLan = flowerLan;
	}

	public String getDeliveryDesc() {
		return deliveryDesc;
	}

	public void setDeliveryDesc(String deliveryDesc) {
		this.deliveryDesc = deliveryDesc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFlowerImg() {
		return flowerImg;
	}

	public void setFlowerImg(String flowerImg) {
		this.flowerImg = flowerImg;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public FlowerType getType() {
		return type;
	}

	public void setType(FlowerType type) {
		this.type = type;
	}

	public FlowerSeries getSeries() {
		return series;
	}

	public void setSeries(FlowerSeries series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "Flower [fid=" + fid + ", fname=" + fname + ", description=" + description + ", flowerLan=" + flowerLan
				+ ", deliveryDesc=" + deliveryDesc + ", price=" + price + ", flowerImg=" + flowerImg + ", sale=" + sale
				+ ", type=" + type + ", series=" + series + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDesc == null) ? 0 : deliveryDesc.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((flowerImg == null) ? 0 : flowerImg.hashCode());
		result = prime * result + ((flowerLan == null) ? 0 : flowerLan.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Flower other = (Flower) obj;
		if (deliveryDesc == null) {
			if (other.deliveryDesc != null)
				return false;
		} else if (!deliveryDesc.equals(other.deliveryDesc))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		if (flowerImg == null) {
			if (other.flowerImg != null)
				return false;
		} else if (!flowerImg.equals(other.flowerImg))
			return false;
		if (flowerLan == null) {
			if (other.flowerLan != null)
				return false;
		} else if (!flowerLan.equals(other.flowerLan))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
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
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
