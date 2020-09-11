package com.zyl.flowershop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICartService {
	public ResponseJson add(Cart cart);

	public ResponseJson find(HttpSession session);

	public ResponseJson delete(Cart cart);

	public ResponseJson update(Cart cart);

	public ResponseJson order(List<Cart> carts);

}
