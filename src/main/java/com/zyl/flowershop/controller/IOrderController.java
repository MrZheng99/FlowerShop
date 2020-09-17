package com.zyl.flowershop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IOrderController {

	public ResponseJson findByUid(HttpSession session);

	public ResponseJson findAll();

	public ResponseJson findByDate();

	public ResponseJson findDefault();

	public ResponseJson findByFlag(Order order);

	public ResponseJson updateFlag(Order order);

	public ResponseJson update(Order order);

	public ResponseJson insert(List<Cart> carts);

	public String getPayPage(Long oid, User user);

	public ResponseJson updateReceiveInfo(Order order, User user);

}
