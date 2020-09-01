package com.zyl.FlowerShop.entity;

public class Advertisement {
	private Integer atid;
	private String url;// 点击广告图片需要跳转的地方
	private String adImg;// 广告图片url
	private String position;
	private String status;

	public Integer getAtid() {
		return atid;
	}

	public void setAtid(Integer atid) {
		this.atid = atid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAdImg() {
		return adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Advertisement [atid=" + atid + ", url=" + url + ", adImg=" + adImg + ", position=" + position
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adImg == null) ? 0 : adImg.hashCode());
		result = prime * result + ((atid == null) ? 0 : atid.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Advertisement other = (Advertisement) obj;
		if (adImg == null) {
			if (other.adImg != null)
				return false;
		} else if (!adImg.equals(other.adImg))
			return false;
		if (atid == null) {
			if (other.atid != null)
				return false;
		} else if (!atid.equals(other.atid))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
