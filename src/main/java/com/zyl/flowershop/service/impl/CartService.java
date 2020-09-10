package com.zyl.flowershop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.ICartService;
import com.zyl.flowershop.service.IOrderService;

@Service
public class CartService implements ICartService {
	@Autowired
	private RedisTemplate<String, Cart> redisTemplate;

	@Autowired
	private IOrderService orderService;

	@Override
	public ResponseJson add(Cart cart) {
		/**
		 * uid:key
		 * 
		 * fid:hashkey
		 * 
		 * uid+fid 唯一确定一个商品
		 * 
		 * cart:value
		 */
		redisTemplate.boundHashOps(String.valueOf(cart.getUid())).put(String.valueOf(cart.getFid()),
				String.valueOf(cart.getNum()));
		return new ResponseJson(200, "添加成功", null, true);
	}

	@Override
	public ResponseJson find(Integer uid) {
		Map<Object, Object> map = redisTemplate.boundHashOps(String.valueOf(uid)).entries();
		List<Cart> listCart = new ArrayList<Cart>();
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			listCart.add((Cart) entry.getValue());
		}
		return new ResponseJson(200, "获取成功", listCart, true);
	}

	@Override
	public ResponseJson delete(Cart cart) {
		redisTemplate.boundHashOps(String.valueOf(cart.getUid())).delete(String.valueOf(cart.getFid()));
		return new ResponseJson(200, "删除成功", null, true);
	}

	@Override
	public ResponseJson update(Cart cart) {
		return add(cart);
	}

	@Override
	public ResponseJson order(List<Cart> carts) {
		// 先清除缓存
		for (Cart cart : carts)
			delete(cart);
		return orderService.insert(carts);
	}

}
