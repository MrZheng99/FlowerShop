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

@Service
public class CartService implements ICartService {
	@Autowired
	private RedisTemplate<String, Cart> redisTemplate;

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
		return null;
	}

	@Override
	public ResponseJson find(Integer uid) {
		Map<Object, Object> map = redisTemplate.boundHashOps(String.valueOf(uid)).entries();
		List<Cart> listCart = new ArrayList<Cart>();
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			listCart.add((Cart) entry.getValue());
		}
		System.out.println(listCart);
		return null;
	}

	@Override
	public ResponseJson delete(Cart cart) {
		return null;
	}

	@Override
	public ResponseJson update(Integer uid) {
		return null;
	}

}
