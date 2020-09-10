package com.zyl.flowershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IOrderDetailsDao;
import com.zyl.flowershop.entity.OrderDetails;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IOrderDetailsService;


@Service
public class OrderDetailsService implements IOrderDetailsService {
	@Autowired
	IOrderDetailsDao orderDetailsDao;
	
	@Override
	public ResponseJson findByOid() {
		List<OrderDetails> listOrderDetails;
		try {
			listOrderDetails =orderDetailsDao.findByOid();
			return new ResponseJson(200, "获取成功", listOrderDetails, true);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}
}
