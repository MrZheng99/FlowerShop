package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IOrderDetailsController;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IOrderDetailsService;
@RestController
@RequestMapping("orderdetails")
public class OrderDetailsController implements IOrderDetailsController {
	@Autowired
	IOrderDetailsService orderDetailsService;
	
	@Override
	@RequestMapping("/findByOid")
	public ResponseJson findByOid() {
		return orderDetailsService.findByOid();
	}
}
