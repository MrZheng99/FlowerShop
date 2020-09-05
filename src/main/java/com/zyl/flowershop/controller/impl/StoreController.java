package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyl.flowershop.controller.IStoreController;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.Store;
import com.zyl.flowershop.service.IFlowerStoreService;

@RequestMapping("/store")
public class StoreController implements IStoreController {
	@Autowired
	IFlowerStoreService service;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return service.findAll();
	}

	@Override
	@PostMapping("/find")
	public ResponseJson find(@RequestBody Store store) {
		return service.find(store);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Store store) {
		return service.update(store);
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestBody Store store) {
		return service.insert(store);
	}

}
