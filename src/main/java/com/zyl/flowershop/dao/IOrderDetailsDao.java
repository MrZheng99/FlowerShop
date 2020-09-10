package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.OrderDetails;

@Repository
public interface IOrderDetailsDao {
	public List<OrderDetails> findByOid();

	public Integer insert(List<OrderDetails> lisOrderDetails);
}
