package com.zyl.flowershop.service;

import java.util.List;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICartService {
	public ResponseJson add(Cart cart);

	public ResponseJson find(Integer uid);

	public ResponseJson delete(Cart cart);

	public ResponseJson update(Cart cart);

	public ResponseJson order(List<Cart> carts);

}
