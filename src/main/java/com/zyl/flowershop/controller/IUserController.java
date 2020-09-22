package com.zyl.flowershop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IUserController {
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public ResponseJson findAll();

	/**
	 * 条件查询用户信息
	 * 
	 * @param op   条件 eg role
	 * @param data 条件的数据
	 * @return
	 */
	public ResponseJson find(User user);

	/**
	 * 修改信息
	 * 
	 * @param admin
	 * @param op
	 * @return
	 */
	public 	ResponseJson update(MultipartFile file, String sex, String uname, Integer uid, HttpSession session);
	/**
	 * 修改重要信息
	 * 
	 * @param admin
	 * @param op
	 * @return
	 */
	public ResponseJson updateMajor(User user);
	/**
	 * 修改密码
	 * 
	 * @param opwd 旧密码
	 * @param npwd 新密码
	 * @param id   管理员id
	 * @return
	 */
	public ResponseJson updatePwd(String opwd, String npwd, Integer uid);

	/**
	 * 用户注册
	 * 
	 * @param verifyCode
	 * @param pwd
	 * @param session
	 * @return
	 */
	public ResponseJson insert(String verifyCode, String pwd, HttpSession session);

	public ResponseJson findCurrent(HttpSession session);



}
