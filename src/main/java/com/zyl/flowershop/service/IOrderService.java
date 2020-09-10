package com.zyl.flowershop.service;

import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;

public interface IOrderService {
	public ResponseJson findCurrent();
	
	public ResponseJson findAll();

	public ResponseJson findByDate();
	
	public ResponseJson insert(Order order);
	
	public ResponseJson updateFlag(Order order);
}
