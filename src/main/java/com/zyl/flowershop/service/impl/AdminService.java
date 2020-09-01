package com.zyl.flowershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IAdminDao;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired
	IAdminDao adminDao;

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

}
