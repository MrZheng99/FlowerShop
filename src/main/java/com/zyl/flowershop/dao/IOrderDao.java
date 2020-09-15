package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Order;

@Repository
public interface IOrderDao {
	public List<Order> findCurrent(Order order);

	public List<Order> findAll();

	public List<Order> findByDate();

	public List<Order> findByFlag(Order order);

	public Order findByOid(Long oid);

	public Integer insert(Order order);

	public Integer updateFlag(Order order);

	public Integer updateReceiveInfo(Order order);

	public Integer update(Order order);

}
