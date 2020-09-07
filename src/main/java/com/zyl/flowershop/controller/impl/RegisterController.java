package com.zyl.flowershop.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IUserService;
import com.zyl.flowershop.util.SendEmailUtil;
import com.zyl.flowershop.util.SessionKey;

@RestController
public class RegisterController {
	@Autowired
	IUserService userService;
	@Autowired
	JavaMailSender jms;
	@Autowired
	SendEmailUtil emailUtil;

	/********* 注册 ***********/
	// 返回注册页面
	@GetMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/register.html");
		return mav;
	}

	// 提交注册
	@PostMapping(value = "/register/step1")
	public ResponseJson register(@RequestParam String account, @RequestParam String password,
			@RequestParam String email, HttpSession session) {
		System.out.println(account);
		if (!userService.find(account)) {
			session.setAttribute(SessionKey.CURRENT_REGISTERY_EMAIL, email);
			session.setAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT, account);
			session.setAttribute(SessionKey.CURRENT_REGISTERY_PASSWORD, password);

			return new ResponseJson(200, "成功", null, true);
		}
		return new ResponseJson(200, "失败", "ACCOUNT_REPEAT", false);
	}

	@GetMapping(value = "/register/step2")
	public ModelAndView registerStepOne() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/registerStep2.html");
		return mav;
	}

	@GetMapping(value = "/register/step3")
	public ModelAndView registerStepTwo() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/front/registerStep3.html");
		return mav;
	}

	@PostMapping(value = "/register/getEmailCode")
	public ResponseJson getEmailCode(HttpSession session) {
		if (session.getAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT).equals(null)
				|| session.getAttribute(SessionKey.CURRENT_REGISTERY_EMAIL).equals(null)
				|| session.getAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT).equals(null))
			return new ResponseJson(200, "发送验证码失败,账户名与当前提交注册的其不一致", null, false);
		String email = (String) session.getAttribute(SessionKey.CURRENT_REGISTERY_EMAIL);
		try {
			SendEmailUtil emailUtil = new SendEmailUtil();
			session.setAttribute(SessionKey.VALIDATE_REGISTERY_CODE, emailUtil.send(jms, email, 4));
			return new ResponseJson(200, "发送验证码成功", null, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "发送验证码失败", null, false);
		}
	}

	@PostMapping(value = "register/verifyCode")
	public ResponseJson verifyEmail(@RequestParam String verifyCode, HttpSession session) {
		System.out.println(SessionKey.VALIDATE_REGISTERY_CODE + ":" + verifyCode);
		if (verifyCode.equals(session.getAttribute(SessionKey.VALIDATE_REGISTERY_CODE)))
			return userService.insert(session);
		return new ResponseJson(200, "验证码错误", null, false);

	}
}
