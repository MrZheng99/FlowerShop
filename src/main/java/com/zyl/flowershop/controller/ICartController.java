package com.zyl.flowershop.controller;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICartController {
	public ResponseJson add(Cart cart);

	public ResponseJson findByUid(Integer uid);

}
