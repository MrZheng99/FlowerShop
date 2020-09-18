package com.zyl.flowershop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IOrderService {

	public ResponseJson findAll();

	public ResponseJson findByDate();

	public ResponseJson findByFlag(Order order);

	public ResponseJson findByOid(Long oid, HttpSession session);

	public ResponseJson findByUid(HttpSession session);

	public ResponseJson insert(List<Cart> carts);

	public ResponseJson insertOne(Cart cart, User user);

	public ResponseJson updateFlag(Order order);

	public ResponseJson update(Order order);

	public String getPayPage(Long oid, User user);

	public ResponseJson updateReceiveInfo(Order order, User user);

	public ResponseJson findDefault();

	public ResponseJson findTypeTime(Order order);
}
