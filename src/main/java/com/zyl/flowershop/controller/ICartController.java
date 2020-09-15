package com.zyl.flowershop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICartController {
	public ResponseJson add(Cart cart, HttpSession session);

	public ResponseJson update(Cart cart, HttpSession session);

	public ResponseJson delete(Cart cart, HttpSession session);

	public ResponseJson order(List<Cart> carts, HttpSession session);

	public ResponseJson findByUid(HttpSession session);

}
