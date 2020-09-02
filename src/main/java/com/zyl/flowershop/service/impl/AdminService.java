package com.zyl.flowershop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IAdminDao;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAdminService;
import com.zyl.flowershop.util.SessionKey;

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

	@Override
	public ResponseJson find(String op, String data) {
		ResponseJson responseJson = new ResponseJson();
		try {
			if ("role".equals(op)) {
				responseJson.setData(adminDao.findByRole(data));
			} else if ("name".equals(op)) {
				responseJson.setData(adminDao.findByName(data));
			} else if ("account".equals(op)) {
				responseJson.setData(adminDao.findByAccount(data));
			} else if ("id".equals(op)) {
				responseJson.setData(adminDao.findById(Integer.valueOf(data)));
			}
			responseJson.setSuccess(true);
			responseJson.setMsg("获取成功");
			responseJson.setStatus(200);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			responseJson.setSuccess(false);
			responseJson.setMsg("获取失败");
			responseJson.setStatus(500);
		}
		return responseJson;
	}

	@Override
	public ResponseJson insert(Admin admin) {
		Integer row = adminDao.insert(admin);
		if (row > 0)
			return new ResponseJson(200, "添加成功", null, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

	public ResponseJson update(Admin admin, String op) {
		Integer row = 0;
		try {
			if ("role".equals(op)) {
				row = adminDao.updateRole(admin);
			} else if ("status".equals(op)) {
				row = adminDao.updateStatus(admin);
			} else if ("info".equals(op)) {
				row = adminDao.updateInfo(admin);
			}
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", row, false);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", row, false);

		}
	}

	public ResponseJson updatePwd(String opwd, String npwd, Integer id) {
		Integer row = adminDao.updatePwd(id, opwd, npwd);
		if (row > 0)
			return new ResponseJson(200, "添加密码成功", null, true);
		return new ResponseJson(200, "修改密码失败", null, false);
	}

	public ResponseJson login(Admin admin, HttpSession session) {
		Admin adm = adminDao.findByAccountPwdRole(admin);
		if (adm.getAid() != null && adm.getAname() != null && adm.getHeadImg() != null) {
			session.setAttribute(SessionKey.CURRENT_ADMIN, adm);
			return new ResponseJson(200, "login success", null, true);
		} else
			return new ResponseJson(200, "login fail", null, false);
	}

}
