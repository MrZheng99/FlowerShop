package com.zyl.flowershop.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.ICartController;
import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController implements ICartController {
	@Autowired
	private ICartService service;

	@Override
	@PostMapping("/add")
	public ResponseJson add(@RequestBody Cart cart) {
		return service.add(cart);
	}

	@Override
	@GetMapping("/find/{uid}")
	public ResponseJson findByUid(@PathVariable Integer uid) {
		return service.find(uid);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Cart cart) {
		return service.add(cart);
	}

	@Override
	@PostMapping("/delete")
	public ResponseJson delete(@RequestBody Cart cart) {
		return service.add(cart);
	}

	/***
	 * 点击购买 先清楚redis中的缓存
	 * 
	 * 然后生成订单，返回订单编号
	 * 
	 */
	@Override
	@PostMapping("/order")
	public ResponseJson order(@RequestParam List<Cart> carts) {
		return service.order(carts);
	}
}
