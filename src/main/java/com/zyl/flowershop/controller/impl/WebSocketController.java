package com.zyl.flowershop.controller.impl;

import java.util.Random;

import org.springframework.web.bind.annotation.SessionAttribute;

import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.util.SessionKey;

public class WebSocketController {
	public String webSocket(@SessionAttribute(SessionKey.CURRENT_USER) User user) {
		if (user.equals(null)) {
			user = new User();
			user.setUid(new Random().nextInt(100));
		}
		try {
			System.out.println("跳转到websocket的页面上");
			return "/chat/websocket/" + user.getUid();
		} catch (Exception e) {
			System.out.println("跳转到websocket的页面上发生异常，异常信息是：" + e.getMessage());
			return "error";
		}
	}
}