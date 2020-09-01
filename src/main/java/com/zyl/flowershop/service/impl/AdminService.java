package com.zyl.flowershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IAdminDao;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired
	IAdminDao adminDao;

	@Override
	public ResponseJson findAll() {
		List<Admin> listAdm;
		try {
			listAdm = adminDao.findAll();
			return new ResponseJson(200, "获取成功", listAdm, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}
}
