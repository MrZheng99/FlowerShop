package com.zyl.flowershop.service;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;

public interface IAdminService {
	public ResponseJson findAll();

	public ResponseJson find(Admin admin);

	public ResponseJson insert(Admin admin);

	/**
	 * 修改管理员信息
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson update(Admin admin);

	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */
	public ResponseJson login(Admin admin, HttpSession session);

}
