package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.FlowerSeries;

@Repository
public interface IFlowerSeriesDao {
	public List<FlowerSeries> findAll();

	public Integer insert(FlowerSeries flowerSeries);

	public Integer update(FlowerSeries flowerSeries);

}
