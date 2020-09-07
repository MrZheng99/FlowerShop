package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.FlowerType;

@Repository
public interface IFlowerTypeDao {
	public List<FlowerType> findAll();

	public Integer insert(FlowerType flowerType);

	public Integer update(FlowerType flowerType);

	public List<FlowerType> find();

}
