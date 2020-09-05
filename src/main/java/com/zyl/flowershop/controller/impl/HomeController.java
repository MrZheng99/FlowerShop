package com.zyl.flowershop.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyl.flowershop.controller.IHomeController;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.impl.AdminService;
import com.zyl.flowershop.service.impl.UserService;

@RestController
public class HomeController implements IHomeController {
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;

	@Override
	@RequestMapping("/super")
	public ModelAndView backSuper() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/manager/supermanager.html");
		return mav;
	}

	@Override
	@RequestMapping("/back/normal")
	public ModelAndView backNormal() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/manager/normalmanager.html");
		return mav;
	}

	@Override
	@RequestMapping("/front/home")
	public ModelAndView front() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:static/front/index.html");
		return mav;
	}

	@Override
	@RequestMapping("/back")
	public ModelAndView backIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/back/login.html");
		return mav;
	}

	@Override
	@RequestMapping("/front")
	public ModelAndView frontIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/login.html");
		return mav;
	}

	@Override
	@PostMapping("/back/login")
	public ResponseJson loginBack(@RequestBody Admin admin, HttpSession session) {
		return adminService.login(admin, session);
	}

	@Override
	@PostMapping("/front/login/{code}")
	public ResponseJson loginFront(@RequestBody User user, @PathVariable String code, HttpSession session) {
		return userService.login(user, code, session);
	}


}
