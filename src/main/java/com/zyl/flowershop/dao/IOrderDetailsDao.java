package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.OrderDetails;

@Repository
public interface IOrderDetailsDao {
	public List<OrderDetails> findByOid(Long oid);

	public Integer insert(List<OrderDetails> lisOrderDetails);
}
