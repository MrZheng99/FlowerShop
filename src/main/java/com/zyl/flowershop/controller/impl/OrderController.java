package com.zyl.flowershop.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.zyl.flowershop.config.AliPayConfig;
import com.zyl.flowershop.controller.IOrderController;
import com.zyl.flowershop.entity.Cart;
import com.zyl.flowershop.entity.Order;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.IOrderService;
import com.zyl.flowershop.util.SessionKey;
@RestController
@RequestMapping("order")
public class OrderController implements IOrderController {
	@Autowired
	IOrderService orderService;
	@Autowired
	private AliPayConfig alipayConfig;

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
	@RequestMapping("/findDefault")
	public ResponseJson findDefault() {
		return orderService.findDefault();
	}

	@Override
	public ResponseJson findByFlag(Order order) {
		return orderService.findByFlag(order);
	}

	@Override
	@RequestMapping("/findByUid")
	public ResponseJson findByUid(HttpSession session) {
		return orderService.findByUid( session);
	}

	@Override
	@PostMapping("/insert")
	public ResponseJson insert(@RequestBody List<Cart> carts) {
		return orderService.insert(carts);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody Order order) {
		return orderService.update(order);
	}

	@Override
	@PostMapping("/updateFlag")
	public ResponseJson updateFlag(@RequestBody Order order) {
		return orderService.updateFlag(order);
	}

	@Override
	@PostMapping("/updateReceiveInfo")
	public ResponseJson updateReceiveInfo(@RequestBody Order order,
			@SessionAttribute(name = SessionKey.CURRENT_USER) User user) {
		return orderService.updateReceiveInfo(order, user);
	}

	@Override
	@GetMapping("/getPayPage/{oid}")
	public String getPayPage(@PathVariable Long oid, @SessionAttribute(name = SessionKey.CURRENT_USER) User user) {

		System.out.println(oid);
		return orderService.getPayPage(oid, user);
	}

	/**
	 * @Description: 支付宝回调接口
	 * @param out_trade_no 商户订单号
	 * @param trade_no     支付宝交易凭证号
	 * @param trade_status 交易状态
	 * @return String
	 * @throws AlipayApiException
	 */
	@SuppressWarnings("unused")
	@PostMapping("/pay/notify")
	private ResponseJson aliPayNotify(HttpServletRequest request, String out_trade_no, String trade_no,
			String trade_status) throws AlipayApiException {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = iter.next();
			String[] values = requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			map.put(name, valueStr);
		}
		boolean signVerified = false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(map, alipayConfig.publicKey, alipayConfig.charset,
					alipayConfig.signType);
		} catch (com.alipay.api.AlipayApiException e) {
			// 验签发生异常,则直接返回失败
			return new ResponseJson(false, "验签发生异常");
		}
		return new ResponseJson(false, "验签失败");

	}

	/**
	 * @Description: 支付宝回调接口
	 * @return String
	 * @throws AlipayApiException
	 */
	@GetMapping("/pay/return")
	private String aliPayReturn(HttpServletRequest request) {
		System.out.println("接收到支付宝的同步通知请求");
		Map<String, String[]> maps = request.getParameterMap();
		System.out.println(maps);
		Order order = new Order();
		Long oid = Long.valueOf(maps.get("out_trade_no")[0]);// 获取订单号
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		order.setOid(oid);
		order.setPayDate(formatter.format(date));
		order.setFlag(1);
		updateFlag(order);
		return "redirect:/front/index";
	}

}
