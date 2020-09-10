package com.zyl.flowershop.entity;

import lombok.Data;

@Data
public class OrderDetails {
	private Integer odid;
	private String num;
	private Flower flower;
	private Order order;

}
