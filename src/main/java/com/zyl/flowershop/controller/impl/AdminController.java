package com.zyl.flowershop.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.flowershop.controller.IAdminController;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.impl.AdminService;

@RestController
@RequestMapping("/adm")
public class AdminController implements IAdminController {
	@Autowired
	AdminService adminService;

	@RequestMapping("/findAll")
	@Override
	public ResponseJson findAll() {
		return adminService.findAll();
	}

	@Override
	@RequestMapping("/find/{op}/{data}")
	public ResponseJson find(@PathVariable String op, @PathVariable String data) {
		return adminService.find(op, data);
	}

	@Override
	@PutMapping("/insert")
	public ResponseJson insert(@RequestBody Admin admin) {
		return adminService.insert(admin);
	}

	@Override
	@PostMapping("/update/{op}")
	public ResponseJson update(@RequestBody Admin admin, @PathVariable String op) {
		return adminService.update(admin, op);
	}

	@Override
	@PostMapping("/updatePwd")
	public ResponseJson updatePwd(@RequestParam String opwd, @RequestParam String npwd, @RequestParam Integer id) {
		return adminService.updatePwd(opwd, npwd, id);
	}
}
