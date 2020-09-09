package com.zyl.flowershop.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.IFlowerController;
import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerService;

@RestController
@RequestMapping("flower")
public class FlowerController implements IFlowerController {
	@Autowired
	IFlowerService flowerService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return flowerService.findAll();
	}

	@Override
	@RequestMapping("/find")
	public ResponseJson find(@RequestBody Flower flower) {
		return flowerService.find(flower);
	}

	@Override
	@RequestMapping("/{fid}")
	public ResponseJson find(@PathVariable Integer fid) {
		return flowerService.find(fid);
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam("pics") MultipartFile[] files, @RequestParam String fname,
			@RequestParam String description, @RequestParam String flowerLan, @RequestParam String deliveryDesc,
			@RequestParam Double price, @RequestParam String sale, @RequestParam String intro,
			@RequestParam String pack, @RequestParam Integer sid, @RequestParam Integer tid) {
		return flowerService.insert(files, fname, description, flowerLan, deliveryDesc, price, sale, intro, pack, sid,
				tid);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Flower flower) {
		return flowerService.update(flower);
	}

	@Override
	@PostMapping(value = "/uploadImage")
	public Map<String, Object> uploadImage(@RequestParam("upload") MultipartFile file) {
		return flowerService.uploadImage(file);
	}
}
