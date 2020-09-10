package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IOrderController;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.OrderData;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IOrderService;

@RestController
@RequestMapping("order")
public class OrderController implements IOrderController {
	@Autowired
	IOrderService orderService;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return orderService.findAll();
	}

	@Override
	@RequestMapping("/findByDate")
	public ResponseJson findByDate() {
		return orderService.findByDate();

	}

	@Override
	@RequestMapping("/findCurrent")
	public ResponseJson findCurrent() {
		return orderService.findCurrent();
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestBody OrderData orderData) {
		return orderService.insert(orderData);
	}

	@Override
	@PostMapping("/updateFlag")
	public ResponseJson updateFlag(@RequestBody Order order) {
		return orderService.updateFlag(order);
	}
}
