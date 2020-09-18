package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Order;

@Repository
public interface IOrderDao {

	public List<Order> findByUid(Order order);

	public List<Order> findAll();

	public List<Order> findByFlag(Order order);

	public Integer insert(Order order);

	public Integer updateFlag(Order order);

	public Integer updateReceiveInfo(Order order);

	public Integer update(Order order);

	public List<Order> findByDate();

	// 默认按年查找
	public List<Order> findDefault();
	
	//指定时间，不指定类型
	public List<Order> findTypeTime(Order order);
	
	//指定类型，不指定时间
	public List<Order> findByType(Order order);

	//指定类型和时间
	public List<Order> findByTimeAndType(Order order);

	//不指定鲜花，不指定时间
	public List<Order> findFlowerSales();

	//指定时间，不指定鲜花 
	public List<Order> findFlowerTime(Order order);

	//指定鲜花，不指定时间 
	public List<Order> findByFlower(Order order);

	//指定时间和鲜花
	public List<Order> findByFlowerAndTime(Order order);

	public Order findByOid(Order order);

}
