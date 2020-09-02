package com.zyl.flowershop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IHomeController {
	public ModelAndView back();

	public ModelAndView front();

	public ModelAndView backIndex();

	public ModelAndView frontIndex();

	/**
	 * 后台登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */

	ResponseJson loginBack(Admin admin, HttpSession session);

	/**
	 * 前台登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */

	ResponseJson loginFront(User user, HttpSession session);
}
