package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
