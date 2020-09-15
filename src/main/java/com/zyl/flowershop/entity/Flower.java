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
	private String intro;// 简述
	private Integer store;
	private String pack;// 包装

	private String sale;
	private Integer sid;
	private Integer tid;

	private Double lprice; // 最低价
	private Double hprice;// 最低价
	private Integer page;// 第几页
	private Integer rows;// 数量
	private String flowerImg;
	private FlowerType type;
	private FlowerSeries series;
	private String status;

	public Flower(String fname, String description, String flowerLan, String deliveryDesc, Double price, String intro,
			String pack, String sale, Integer store, Integer sid, Integer tid, String flowerImg) {
		this.fname = fname;
		this.description = description;
		this.flowerLan = flowerLan;
		this.deliveryDesc = deliveryDesc;
		this.price = price;
		this.intro = intro;
		this.pack = pack;
		this.store = store;
		this.sale = sale;
		this.sid = sid;
		this.tid = tid;
		this.flowerImg = flowerImg;
	}

	public Flower() {

	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Double getLprice() {
		return lprice;
	}

	public void setLprice(Double lprice) {
		this.lprice = lprice;
	}

	public Double getHprice() {
		return hprice;
	}

	public void setHprice(Double hprice) {
		this.hprice = hprice;
	}

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
				+ ", deliveryDesc=" + deliveryDesc + ", price=" + price + ", intro=" + intro + ", store=" + store
				+ ", pack=" + pack + ", sale=" + sale + ", sid=" + sid + ", tid=" + tid + ", lprice=" + lprice
				+ ", hprice=" + hprice + ", page=" + page + ", rows=" + rows + ", flowerImg=" + flowerImg + ", type="
				+ type + ", series=" + series + ", status=" + status + "]";
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
		result = prime * result + ((hprice == null) ? 0 : hprice.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((lprice == null) ? 0 : lprice.hashCode());
		result = prime * result + ((pack == null) ? 0 : pack.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		if (hprice == null) {
			if (other.hprice != null)
				return false;
		} else if (!hprice.equals(other.hprice))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (lprice == null) {
			if (other.lprice != null)
				return false;
		} else if (!lprice.equals(other.lprice))
			return false;
		if (pack == null) {
			if (other.pack != null)
				return false;
		} else if (!pack.equals(other.pack))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
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
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getFirstImg() {
		if (this.flowerImg != null)
			return this.flowerImg.split(",")[0];
		return null;
	}

}
