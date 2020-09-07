package com.zyl.flowershop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IUserDao;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.IUserService;
import com.zyl.flowershop.util.SessionKey;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserDao userDao;

	@Override
	public ResponseJson findAll() {
		List<User> listUser;
		try {
			listUser = userDao.findAll();
			return new ResponseJson(200, "获取成功", listUser, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson login(User user, String code, HttpSession session) {
		if (!code.equals(session.getAttribute(SessionKey.VALIDATE_LOGIN_CODE)))
			return new ResponseJson(404, "验证码错误", null, false);
		session.removeAttribute(SessionKey.VALIDATE_LOGIN_CODE);
		User u = userDao.findByAccountPwd(user);
		if (u != null) {
			session.setAttribute(SessionKey.CURRENT_USER, u);
			return new ResponseJson(200, "login success", null, true);
		} else
			return new ResponseJson(200, "账户名和密码不匹配", null, false);
	}

	@Override
	public ResponseJson find(User user) {
		List<User> listUser;
		try {
			listUser = userDao.find(user);
			return new ResponseJson(200, "获取成功", listUser, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson insert(User user) {
		Integer row = userDao.insert(user);
		if (row > 0)
			return new ResponseJson(200, "添加成功", null, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

	@Override
	public ResponseJson update(User user) {
		Integer row = userDao.update(user);
		if (row > 0)
			return new ResponseJson(200, "修改成功", null, true);
		return new ResponseJson(200, "修改失败", null, false);
	}

	@Override
	public ResponseJson updatePwd(Integer id, String opwd, String npwd) {
		Integer row = userDao.updatePwd(id, opwd, npwd);
		if (row > 0)
			return new ResponseJson(200, "修改密码成功", null, true);
		return new ResponseJson(200, "修改密码失败", null, false);
	}

	public Boolean find(String account) {
		User user = new User();
		user.setAccount(account);
		List<User> listUser = userDao.find(user);
		if (listUser.size() > 0)
			return true;
		return false;
	}

	@Override
	public ResponseJson insert(HttpSession session) {
		String email = (String) session.getAttribute(SessionKey.CURRENT_REGISTERY_EMAIL);
		String account = (String) session.getAttribute(SessionKey.CURRENT_REGISTERY_ACCOUNT);
		String password = (String) session.getAttribute(SessionKey.CURRENT_REGISTERY_PASSWORD);
		User user = new User();
		user.setAccount(account);
		user.setEmail(email);
		user.setPwd(password);
		return insert(user);
	}

}
