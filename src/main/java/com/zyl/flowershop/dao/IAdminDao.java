package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Admin;

@Repository
public interface IAdminDao {
	public List<Admin> findAll();
}
