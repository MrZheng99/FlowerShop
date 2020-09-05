package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.IAdminDao;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAdminService;
import com.zyl.flowershop.util.SessionKey;
import com.zyl.flowershop.util.UploadImg;

@Service
public class AdminService implements IAdminService {
	@Autowired
	IAdminDao adminDao;
	@Autowired
	UploadImg uploadImg;

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
	public ResponseJson find(Admin admin) {
		List<Admin> listAdm;
		try {
			listAdm = adminDao.find(admin);
			return new ResponseJson(200, "查询成功", listAdm, true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "查询成功", null, false);
		}
	}

	@Override
	public ResponseJson insert(MultipartFile file, Admin admin) {
		// 上传图片
		if (file.isEmpty())
			return new ResponseJson(200, "添加失败,头像不能为空", null, false);
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "添加失败,头像格式不正确", null, false);
		String fileName;
		Map<String, Object> rs = new HashMap<String, Object>();
		try {
			fileName = uploadImg.uploadImage(file, "\\images\\adm");
			admin.setHeadImg("fileUpload\\adm\\" + fileName);
			rs.put("fileName", fileName);
			rs.put("upload", "fileUpload\\adm\\" + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer row = adminDao.insert(admin);
		if (row > 0)
			return new ResponseJson(200, "添加成功", rs, true);

		return new ResponseJson(200, "添加失败", null, false);

	}

	@Override
	public ResponseJson update(Admin admin) {
		Integer row = 0;
		try {
			row = adminDao.update(admin);
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
		System.out.println(adm);
		if (adm != null) {
			session.setAttribute(SessionKey.CURRENT_ADMIN, adm);
			return new ResponseJson(200, "login success", null, true);
		} else
			return new ResponseJson(200, "login fail", null, false);
	}

}
