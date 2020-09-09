package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.IStoreController;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.Store;
import com.zyl.flowershop.service.IFlowerStoreService;

@RestController
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
	public ResponseJson insert(@RequestParam("pic") MultipartFile file, @RequestParam String color ,@RequestParam String size, @RequestParam String num,@RequestParam Integer fid) {
		return service.insert(file, color, size, num, fid);
	}

}
