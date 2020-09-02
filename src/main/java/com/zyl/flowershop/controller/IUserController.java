package com.zyl.flowershop.controller;

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
	 * 添加用户
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson insert(User user);

	/**
	 * 修改管理员
	 * 
	 * @param admin
	 * @param op
	 * @return
	 */
	ResponseJson update(User user);

	/**
	 * 修改密码
	 * 
	 * @param opwd 旧密码
	 * @param npwd 新密码
	 * @param id   管理员id
	 * @return
	 */
	ResponseJson updatePwd(String opwd, String npwd, Integer id);

}
