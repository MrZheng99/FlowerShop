package com.zyl.flowershop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ResponseJson;

public interface IAdminController {
	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public ResponseJson findAll();

	/**
	 * 条件查询管理员信息
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson find(Admin admin);

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson insert(MultipartFile file, String aname, String account, String pwd, String role, String tel);

	/**
	 * 修改管理员
	 * 
	 * @param admin
	 * @return
	 */
	public 	ResponseJson update(MultipartFile file, String aname, String account, String role, String tel, Integer aid,
			HttpSession session);
	/**
	 * 修改密码
	 * 
	 * @param opwd 旧密码
	 * @param npwd 新密码
	 * @param id   管理员id
	 * @return
	 */
	public ResponseJson updatePwd(String opwd, String npwd, Integer id);

	public ResponseJson findCurrent(HttpSession session);




}
