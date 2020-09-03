package com.zyl.flowershop.controller.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IUserController;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.impl.UserService;
import com.zyl.flowershop.util.CodeUtil;
import com.zyl.flowershop.util.SendEmailUtil;
import com.zyl.flowershop.util.SessionKey;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
	@Autowired
	UserService userService;
	@Autowired
	JavaMailSender jms;
	@Autowired
	SendEmailUtil emailUtil;
	@Autowired
	CodeUtil codeUtil;

	@Override
	@RequestMapping("/findAll")
	public ResponseJson findAll() {
		return userService.findAll();
	}

	@Override
	@RequestMapping("/find")
	public ResponseJson find(@RequestBody User user) {
		return userService.find(user);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestBody User user) {
		return userService.update(user);
	}

	@Override
	@PostMapping("/updatePwd")
	public ResponseJson updatePwd(@RequestParam String opwd, @RequestParam String npwd, @RequestParam Integer id) {
		return userService.updatePwd(id, opwd, npwd);
	}

	@PostMapping(value = "/getEmailCode")
	public ResponseJson getCode(@RequestParam String email, @RequestParam String account, HttpSession session) {
		session.setAttribute(SessionKey.CURRENT_REGISTERY_EMAIL, email);
		session.setAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT, account);
		try {
			SendEmailUtil emailUtil = new SendEmailUtil();
			session.setAttribute(SessionKey.VALIDATE_REGISTERY_CODE, emailUtil.send(jms, email, 4));
			return new ResponseJson(200, "发送验证码成功", null, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "发送验证码失败", null, false);
		}
	}

	@Override
	@PostMapping(value = "/insert")
	public ResponseJson insert(@RequestParam String verifyCode, @RequestParam String pwd, HttpSession session) {
		if (verifyCode.equals(session.getAttribute(SessionKey.VALIDATE_REGISTERY_CODE))) {
			User user = new User();
			user.setAccount((String) session.getAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT));
			user.setAccount((String) session.getAttribute(SessionKey.CURRENT_REGISTERY_EMAIL));
			user.setAccount(pwd);
			return userService.insert(user);
		}
		return new ResponseJson(200, "验证码不正确", null, false);
	}

	@GetMapping("/getLoginCode")
	public void code(HttpSession session, HttpServletResponse resp) {
		try {
			String code = codeUtil.getRamdomCode();
			session.setAttribute(SessionKey.VALIDATE_LOGIN_CODE, code);
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setDateHeader("Expires", 0);
			BufferedImage bi = codeUtil.getCodeImage(code, 110, 38);
			ImageIO.write(bi, "JPEG", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
