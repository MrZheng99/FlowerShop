package com.zyl.flowershop.entity;

import lombok.Data;

@Data
public class Cart {
	private Integer cid;
	private Integer fid;
	private Integer uid;// 用户id
	private Integer sid;// 库存id
	private Integer num;// 当前购买量
}
