package com.zyl.flowershop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICartController {
	public ResponseJson add(Cart cart);

	public ResponseJson update(Cart cart);

	public ResponseJson delete(Cart cart);

	public ResponseJson order(List<Cart> carts);

	public ResponseJson findByUid(HttpSession session);

}
