package com.zyl.flowershop.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.IUserService;

@Service
public class UserService implements IUserService {

	@Override
	public ResponseJson login(User user, HttpSession session) {
		return null;
	}

}
