package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.IFlowerTypeController;
import com.zyl.flowershop.entity.FlowerType;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerTypeService;

@RestController
@RequestMapping("flowerType")
public class FlowerTypeController implements IFlowerTypeController {
	@Autowired
	IFlowerTypeService flowerTypeService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return flowerTypeService.findAll();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam MultipartFile file, @RequestParam String tname) {
		return flowerTypeService.insert(file, tname);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(FlowerType flowerType) {
		return flowerTypeService.update(flowerType);
	}
}
