package com.zyl.flowershop.controller;

import com.zyl.flowershop.entity.ResponseJson;

public interface ICartController {
	public ResponseJson add();

	public ResponseJson findByUid(Integer uid);

}
