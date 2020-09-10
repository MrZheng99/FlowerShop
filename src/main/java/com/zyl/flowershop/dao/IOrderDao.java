package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Order;

@Repository
public interface IOrderDao {
	public List<Order> findCurrent();
	
	public List<Order> findAll();
	
	public List<Order> findByDate();
	
	public Integer insert(Order order);
	
	public Integer updateFlag(Order order);
}
