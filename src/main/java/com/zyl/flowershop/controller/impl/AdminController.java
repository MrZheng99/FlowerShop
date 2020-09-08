package com.zyl.flowershop.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.IAdminController;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.impl.AdminService;
import com.zyl.flowershop.util.SessionKey;

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
	@RequestMapping("/find")
	public ResponseJson find(@RequestBody Admin admin) {
		return adminService.find(admin);
	}

	@Override

	@PostMapping("/insert")
	public ResponseJson insert(@RequestParam("pic") MultipartFile file, @RequestParam String aname,
			@RequestParam String account, @RequestParam String pwd, @RequestParam String role,
			@RequestParam String tel) {
		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setAname(aname);
		admin.setPwd(pwd);
		admin.setTel(tel);
		admin.setRole(role);
		return adminService.insert(file, admin);
	}

	@Override
	@PostMapping("/update")
	public ResponseJson update(@RequestParam("pic") MultipartFile file, @RequestParam String aname,
			@RequestParam String account, @RequestParam String role,
			@RequestParam String tel,@RequestParam Integer aid,HttpSession session){
				Admin admin = new Admin();
				admin.setAccount(account);
				admin.setAname(aname);
				admin.setTel(tel);
				admin.setRole(role);
				admin.setAid(aid);
				return adminService.update(file,admin, session);
	}

	@Override
	@PostMapping("/updatePwd")
	public ResponseJson updatePwd(@RequestParam String opwd, @RequestParam String npwd, @RequestParam Integer aid) {
		return adminService.updatePwd(opwd, npwd, aid);
	}

	@Override
	@GetMapping("/findCurrent")
	public ResponseJson findCurrent(HttpSession session) {
		return new ResponseJson(200, "获取成功", session.getAttribute(SessionKey.CURRENT_ADMIN), true);
	}

}
