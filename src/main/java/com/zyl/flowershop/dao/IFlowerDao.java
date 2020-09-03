package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Flower;

@Repository
public interface IFlowerDao {
	public List<Flower> findAll();

	public List<Flower> find(Flower flower);

	public Integer insert(Flower flower);

	public Integer update(Flower flower);

}
