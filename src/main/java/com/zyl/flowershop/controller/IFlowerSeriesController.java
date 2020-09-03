package com.zyl.flowershop.controller;

import com.zyl.flowershop.entity.FlowerSeries;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerSeriesController {
	public ResponseJson findAll();

	public ResponseJson update(FlowerSeries flowerSeries);

	public ResponseJson insert(String sname);

}
