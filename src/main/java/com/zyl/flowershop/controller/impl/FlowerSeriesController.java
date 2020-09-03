package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IFlowerSeriesController;
import com.zyl.flowershop.entity.FlowerSeries;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerSeriesService;

@RestController
@RequestMapping("flowerService")
public class FlowerSeriesController implements IFlowerSeriesController {
	@Autowired
	IFlowerSeriesService service;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return service.findAll();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam String sname) {
		return service.insert(sname);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(FlowerSeries flowerSeries) {
		return service.update(flowerSeries);
	}
}
