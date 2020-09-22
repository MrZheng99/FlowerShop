package com.zyl.flowershop.entity;

public class Order {
	private Long oid;
	private Integer uid;

	private String createDate;
	private String payDate;
	private String sendDate;
	private String receiveDate;
	private String receivePerson;
	private String tel;

	private Double amount;
	private String address;
	private Integer flag;

	private String tname;
	private Integer sales;
	private String fname;
	
	private String y; //年
	private String m; //月
	private String d; //日

	private boolean assignDate;
	private boolean assignType;
	
	private Integer tid;
	private Integer fid;
	
	class OrderProgress {
		public final Integer unpaid = 0; // "未付款"
		public final Integer paid = 1; // "已付款"
		public final Integer unshiped = 2;// "已发货"
		public final Integer shiped = 3;// "已收货"
	}

	
	public Integer getFid() {
		return fid;
	}



	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Order(Long oid, Integer uid, String createDate, String payDate, String sendDate, String receiveDate,
			String receivePerson, String tel, Double amount, String address, Integer flag, String tname, Integer sales,
			String fname, String y, String m, String d, boolean assignDate, boolean assignType,Integer tid,Integer fid) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.createDate = createDate;
		this.payDate = payDate;
		this.sendDate = sendDate;
		this.receiveDate = receiveDate;
		this.receivePerson = receivePerson;
		this.tel = tel;
		this.amount = amount;
		this.address = address;
		this.flag = flag;
		this.tname = tname;
		this.sales = sales;
		this.fname = fname;
		this.y = y;
		this.m = m;
		this.d = d;
		this.assignDate = assignDate;
		this.assignType = assignType;
		this.tid = tid;
		this.fid = fid;
	}



	public Integer getTid() {
		return tid;
	}



	public void setTid(Integer tid) {
		this.tid = tid;
	}



	public boolean isAssignDate() {
		return assignDate;
	}



	public void setAssignDate(boolean assignDate) {
		this.assignDate = assignDate;
	}



	public boolean isAssignType() {
		return assignType;
	}



	public void setAssignType(boolean assignType) {
		this.assignType = assignType;
	}



	public String getY() {
		return y;
	}



	public void setY(String y) {
		this.y = y;
	}



	public String getM() {
		return m;
	}



	public void setM(String m) {
		this.m = m;
	}



	public String getD() {
		return d;
	}



	public void setD(String d) {
		this.d = d;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public Integer getSales() {
		return sales;
	}



	public void setSales(Integer sales) {
		this.sales = sales;
	}



	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getReceivePerson() {
		return receivePerson;
	}

	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", createDate=" + createDate + ", payDate=" + payDate
				+ ", sendDate=" + sendDate + ", receiveDate=" + receiveDate + ", receivePerson=" + receivePerson
				+ ", tel=" + tel + ", amount=" + amount + ", address=" + address + ", flag=" + flag + ", tname=" + tname
				+ ", sales=" + sales + ", fname=" + fname + ", y=" + y + ", m=" + m + ", d=" + d + ", assignDate="
				+ assignDate + ", assignType=" + assignType + ", tid=" + tid + ", fid=" + fid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + (assignDate ? 1231 : 1237);
		result = prime * result + (assignType ? 1231 : 1237);
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((payDate == null) ? 0 : payDate.hashCode());
		result = prime * result + ((receiveDate == null) ? 0 : receiveDate.hashCode());
		result = prime * result + ((receivePerson == null) ? 0 : receivePerson.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (assignDate != other.assignDate)
			return false;
		if (assignType != other.assignType)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (payDate == null) {
			if (other.payDate != null)
				return false;
		} else if (!payDate.equals(other.payDate))
			return false;
		if (receiveDate == null) {
			if (other.receiveDate != null)
				return false;
		} else if (!receiveDate.equals(other.receiveDate))
			return false;
		if (receivePerson == null) {
			if (other.receivePerson != null)
				return false;
		} else if (!receivePerson.equals(other.receivePerson))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

}
