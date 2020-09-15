package com.zyl.flowershop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IFlowerDao;
import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.CartItem;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.ICartService;
import com.zyl.flowershop.service.IOrderService;
import com.zyl.flowershop.util.SessionKey;

@Service
public class CartService implements ICartService {
	@Autowired
	private RedisTemplate<String, Cart> redisTemplate;

	@Autowired
	private IOrderService orderService;
	@Autowired
	private IFlowerDao flowerDao;

	@Override
	public ResponseJson add(Cart cart, HttpSession session) {
		/**
		 * uid:key
		 * 
		 * fid:hashkey
		 * 
		 * uid+fid 唯一确定一个商品
		 * 
		 * cart:value
		 */
		User user = (User) session.getAttribute(SessionKey.CURRENT_USER);
		cart.setUid(user.getUid());
		redisTemplate.boundHashOps(String.valueOf(cart.getUid())).put(String.valueOf(cart.getFid()),
				String.valueOf(cart.getNum()));
		return new ResponseJson(200, "添加成功", null, true);
	}

	@Override
	public ResponseJson find(HttpSession session) {
		User user = (User) session.getAttribute(SessionKey.CURRENT_USER);
		String uid = String.valueOf(user.getUid());
		Map<Object, Object> map = redisTemplate.boundHashOps(uid).entries();
		List<Integer> fids = new ArrayList<Integer>();
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			fids.add(Integer.valueOf((String) entry.getKey()));
		}
		System.out.println(fids);
		if (fids.size() > 0) {
			List<CartItem> listCartItem = flowerDao.findCartItems(fids);
			for (CartItem item : listCartItem) {
				item.setNum((String) map.get(String.valueOf(item.getFid())));
			}

			return new ResponseJson(200, "获取成功", listCartItem, true);
		}
		return new ResponseJson(200, "获取成功", null, true);
	}

	@Override
	public ResponseJson delete(Cart cart, HttpSession session) {
		User user = (User) session.getAttribute(SessionKey.CURRENT_USER);
		cart.setUid(user.getUid());
		redisTemplate.boundHashOps(String.valueOf(cart.getUid())).delete(String.valueOf(cart.getFid()));
		return new ResponseJson(200, "删除成功", null, true);
	}

	@Override
	public ResponseJson update(Cart cart, HttpSession session) {
		return add(cart, session);
	}

	@Override
	public ResponseJson order(List<Cart> carts, HttpSession session) {
		// 先清除缓存
		for (Cart cart : carts)
			delete(cart, session);
		return orderService.insert(carts);
	}

}
