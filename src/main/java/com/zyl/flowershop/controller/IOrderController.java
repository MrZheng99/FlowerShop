package com.zyl.flowershop.controller;

import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;

public interface IOrderController {
	public ResponseJson findCurrent();
	
	public ResponseJson findAll();

	public ResponseJson findByDate();

	public ResponseJson insert(Order order);

	public ResponseJson updateFlag(Order order);
}
