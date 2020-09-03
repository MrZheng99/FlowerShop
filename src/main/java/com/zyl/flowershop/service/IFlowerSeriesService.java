package com.zyl.flowershop.service;

import com.zyl.flowershop.entity.FlowerSeries;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerSeriesService {
	public ResponseJson findAll();

	public ResponseJson update(FlowerSeries flowerSeries);

	public ResponseJson insert(String sname);

}
