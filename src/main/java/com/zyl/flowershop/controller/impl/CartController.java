package com.zyl.flowershop.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.ICartController;
import com.zyl.flowershop.entity.ResponseJson;

@RestController
@RequestMapping("/cart")
public class CartController implements ICartController {

	@Override
	public ResponseJson add() {
		return null;
	}

	@Override
	public ResponseJson findByUid(Integer uid) {
		return null;
	}

}
