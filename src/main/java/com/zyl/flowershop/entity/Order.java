package com.zyl.flowershop.entity;

import lombok.Data;

@Data
public class Order {
	private Integer oid;
	private String odate;
	private String receiveDate;
	private Double amount;
	private Address address;

}
