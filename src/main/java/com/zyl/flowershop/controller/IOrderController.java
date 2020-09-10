package com.zyl.flowershop.controller;

import java.util.List;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;

public interface IOrderController {
	public ResponseJson findCurrent();

	public ResponseJson findAll();

	public ResponseJson findByDate();

	public ResponseJson updateFlag(Order order);

	public ResponseJson update(Order order);

	public ResponseJson insert(List<Cart> carts);

}
