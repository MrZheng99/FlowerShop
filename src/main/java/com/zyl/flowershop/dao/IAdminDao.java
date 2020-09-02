package com.zyl.flowershop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Admin;

@Repository
public interface IAdminDao {
	/**
	 * 查询所有普通和超级管理员
	 * 
	 * @return
	 */
	public List<Admin> findAll();

	/**
	 * 根据管理员姓名查询
	 * 
	 * @param name
	 * @return
	 */
	public List<Admin> findByName(String name);

	/**
	 * 根据管理员用户名查询,唯一
	 * 
	 * @param name
	 * @return
	 */
	public Admin findByAccount(String account);

	/**
	 * 登录使用
	 * 
	 * @param account
	 * @return
	 */
	public Admin findByAccountPwdRole(Admin admin);

	/**
	 * 根据管理员id查询
	 * 
	 * @param id
	 * @return
	 */
	public Admin findById(Integer id);

	/**
	 * 根据管理员类别查询
	 * 
	 * @param role 1:超级 0:普通
	 * @return
	 */
	public List<Admin> findByRole(String role);

	/**
	 * 添加管理员
	 * 
	 * @param admin
	 * @return
	 */
	public Integer insert(Admin admin);

	/**
	 * 修改管理员状态
	 * 
	 * @param admin
	 * @return
	 */
	public Integer updateStatus(Admin admin);

	/**
	 * 修改管理员的密码
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Integer updatePwd(@Param("id") Integer id, @Param("opwd") String opwd, @Param("npwd") String npwd);

	/**
	 * 修改管理员角色
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	public Integer updateRole(Admin admin);

	/**
	 * 修改管理员的电话，姓名，头像
	 * 
	 * @param admin
	 * @return
	 */
	public Integer updateInfo(Admin admin);

}
