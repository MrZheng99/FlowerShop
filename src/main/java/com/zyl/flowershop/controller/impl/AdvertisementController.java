package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.IAdvertisementController;
import com.zyl.flowershop.entity.Advertisement;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAdvertisementService;

@RestController
@RequestMapping("advertisement")
public class AdvertisementController implements IAdvertisementController {
	@Autowired
	IAdvertisementService advertisementService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return advertisementService.findAll();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam("pic") MultipartFile file, @RequestParam String position,
			@RequestParam String url) {
		return advertisementService.insert(file, url, position);

	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Advertisement advertisement) {
		return advertisementService.update(advertisement);
	}

}
