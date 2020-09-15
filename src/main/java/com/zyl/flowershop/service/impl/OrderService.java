package com.zyl.flowershop.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zyl.flowershop.config.AliPayConfig;
import com.zyl.flowershop.dao.IFlowerDao;
import com.zyl.flowershop.dao.IOrderDao;
import com.zyl.flowershop.dao.IOrderDetailsDao;
import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.OrderDetails;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.IOrderService;
import com.zyl.flowershop.util.SessionKey;

@Service
@Transactional
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IOrderDetailsDao orderDetailsDao;
	@Autowired
	private IFlowerDao flowerDao;
	@Autowired
	private AliPayConfig alipayConfig;

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
	public ResponseJson findCurrent(Long oid, HttpSession session) {
		List<Order> listOrder;
		try {
			User user = (User) session.getAttribute(SessionKey.CURRENT_USER);
			Order order = new Order();
			order.setOid(oid);
			order.setUid(user.getUid());
			System.out.println(order);
			listOrder = orderDao.findCurrent(order);
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
	public ResponseJson updateReceiveInfo(Order order, User user) {
		order.setUid(user.getUid());
		Integer row = 0;
		try {
			row = orderDao.updateReceiveInfo(order);
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
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			oid = System.currentTimeMillis();
			lisOrderDetails = new ArrayList<OrderDetails>();
			for (Cart cart : carts) {
				flower = flowerDao.findPrice(cart.getFid());
				details = new OrderDetails(String.valueOf(cart.getNum()), flower.getFname(), flower.getPrice(),
						flower.getSale(), flower.getIntro(), flower.getFirstImg(), oid);
				amount += cart.getNum() * flower.getPrice() * Double.valueOf(flower.getSale()) * 0.1;
				lisOrderDetails.add(details);
				System.out.println(details);
			}

			order.setOid(oid);
			order.setAmount(amount);
			order.setUid(carts.get(0).getUid());
			order.setCreateDate(formatter.format(date));
			System.out.println(order);

			row = orderDao.insert(order);
			System.out.println(lisOrderDetails);
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

	@Override
	public String getPayPage(Long oid, User user) {
		// 更新订单的收货信息
		try {
			Order order = orderDao.findByOid(oid);
			DecimalFormat df = new DecimalFormat("#.00");// 一定要两位精度的金额
			// 构建客户端
			System.out.println(alipayConfig.appId);
			DefaultAlipayClient alipayRsa2Client = new DefaultAlipayClient(alipayConfig.gatewayUrl, alipayConfig.appId,
					alipayConfig.privateKey, "json", alipayConfig.charset, alipayConfig.publicKey,
					alipayConfig.signType);
			AlipayTradePagePayRequest request = new AlipayTradePagePayRequest(); // 网页支付
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time_expire = dateFormat.format(System.currentTimeMillis() + alipayConfig.time_expire);// 过期时间
			request.setNotifyUrl(alipayConfig.notifyUrl);
			request.setReturnUrl(alipayConfig.returnUrl);
			request.setBizContent("{\"out_trade_no\":\"" + oid + "\"," + "\"time_expire\":\"" + time_expire + "\","
					+ "\"total_amount\":\"" + df.format(order.getAmount()) + "\"," + "\"subject\":\"ZJ商城支付\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			System.out.println("{\"out_trade_no\":\"" + oid + "\"," + "\"time_expire\":\"" + time_expire + "\","
					+ "\"total_amount\":\"" + df.format(order.getAmount()) + "\"," + "\"subject\":\"ZJ商城支付\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			return alipayRsa2Client.pageExecute(request).getBody();
		} catch (

		AlipayApiException e) {
			e.printStackTrace();
		}
		return null;

	}

}
