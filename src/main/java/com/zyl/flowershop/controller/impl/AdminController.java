package com.zyl.flowershop.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IAdminController;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.impl.AdminService;

@RestController
public class AdminController implements IAdminController {
	@Autowired
	AdminService adminService;

	@Override
	@RequestMapping("/adm")
	public ResponseJson findAll() {
		System.out.println("-------");
		List<Admin> list = adminService.findAll();
		for (Admin admin : list)
			System.out.println(admin);
		return new ResponseJson();
	}

}
