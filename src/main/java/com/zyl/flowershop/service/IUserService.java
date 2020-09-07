package com.zyl.flowershop.service;

import javax.servlet.http.HttpSession;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;

public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param admin
	 * @param session
	 * @return
	 */
	public ResponseJson login(User user, String code, HttpSession session);

	public ResponseJson findAll();

	public ResponseJson find(User user);

	public ResponseJson insert(User user);

	/**
	 * 用户修改信息
	 * 
	 * @param admin
	 * @param op
	 * @return
	 */
	public ResponseJson update(User user);

	/**
	 * 用户修改密码
	 * 
	 * @param id
	 * @param opwd
	 * @param npwd
	 * @return
	 */
	public ResponseJson updatePwd(Integer id, String opwd, String npwd);

	public Boolean find(String account);

	public ResponseJson insert(HttpSession session);

}
