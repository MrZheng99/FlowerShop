package com.zyl.flowershop.controller;

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
	 * @param op   条件 eg role
	 * @param data 条件的数据
	 * @return
	 */
	public ResponseJson find(String op, String data);

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 * @return
	 */
	public ResponseJson insert(Admin admin);

	/**
	 * 修改管理员
	 * 
	 * @param admin
	 * @param op
	 * @return
	 */
	ResponseJson update(Admin admin, String op);

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
