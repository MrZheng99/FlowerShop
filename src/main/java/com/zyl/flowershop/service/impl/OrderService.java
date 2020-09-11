package com.zyl.flowershop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.flowershop.dao.IFlowerDao;
import com.zyl.flowershop.dao.IOrderDao;
import com.zyl.flowershop.dao.IOrderDetailsDao;
import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.OrderDetails;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IOrderService;

@Service
@Transactional
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IOrderDetailsDao orderDetailsDao;
	@Autowired
	private IFlowerDao flowerDao;

	@Override
	public ResponseJson findAll() {
		List<Order> listOrder;
		try {
			listOrder = orderDao.findAll();
			return new ResponseJson(200, "获取成功", listOrder, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson findByDate() {
		List<Order> listOrder;
		try {
			listOrder = orderDao.findByDate();
			return new ResponseJson(200, "获取成功", listOrder, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson findByFlag(Order order) {
		List<Order> listOrder;
		try {
			listOrder = orderDao.findByFlag(order);
			return new ResponseJson(200, "获取成功", listOrder, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson findCurrent() {
		List<Order> listOrder;
		try {
			listOrder = orderDao.findCurrent();
			return new ResponseJson(200, "获取成功", listOrder, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(Order order) {
		Integer row = 0;
		try {
			row = orderDao.update(order);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson updateFlag(Order order) {
		Integer row = 0;
		try {
			row = orderDao.updateFlag(order);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson updateAddrTel(Order order) {
		Integer row = 0;
		try {
			row = orderDao.updateAddrTel(order);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson insert(List<Cart> carts) {
		Integer row = 0;
		Double amount = 0d;
		Flower flower = null;
		OrderDetails details;
		List<OrderDetails> lisOrderDetails;
		Long oid;
		try {
			Order order = new Order();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			oid = System.currentTimeMillis();
			lisOrderDetails = new ArrayList<OrderDetails>();
			for (Cart cart : carts) {
				flower = flowerDao.findPrice(cart.getFid());
				details = new OrderDetails(String.valueOf(cart.getNum()), flower.getFname(), flower.getPrice(),
						flower.getSale(), oid);
				amount += cart.getNum() * flower.getPrice() * Double.valueOf(flower.getSale()) * 0.1;
				lisOrderDetails.add(details);
			}
			order.setOid(oid);
			order.setAmount(amount);
			order.setCreateDate(formatter.format(date));
			row = orderDao.insert(order);
			if (row > 0) {
				if (orderDetailsDao.insert(lisOrderDetails) > 0)
					return new ResponseJson(200, "订单详情表插入成功", oid, true);
				return new ResponseJson(200, "订单详情表插入失败", -1, false);
			}
			return new ResponseJson(200, "订单插入失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "订单插入失败", -1, false);
		}
	}

}
