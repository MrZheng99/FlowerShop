package com.zyl.flowershop.service;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */
	public ResponseJson login(User user, HttpSession session);
}
