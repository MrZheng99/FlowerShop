package com.zyl.flowershop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.User;

@Repository
public interface IUserDao {
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 条件查询
	 * 
	 * @param name
	 * @return
	 */
	public List<User> find(User user);

	/**
	 * 登录
	 * 
	 * @param name
	 * @return
	 */
	public User findByAccountPwd(User user);

	/**
	 * 会员注册
	 * 
	 * @param user
	 * @return
	 */
	public Integer insert(User user);

	/**
	 * 修改会员的密码
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Integer updatePwd(@Param("uid") Integer uid, @Param("opwd") String opwd, @Param("npwd") String npwd);

	/**
	 * 修改会员的姓名，头像，性别
	 * 
	 * @param admin
	 * @return
	 */
	public Integer update(User user);
	
	/**
	 * 修改会员的电话，邮箱
	 * 
	 * @param admin
	 * @return
	 */
	public Integer updateMajor(User user);
	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public Integer totalNum();
}
