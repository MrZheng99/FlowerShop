package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Address;


@Repository
public interface IAddressDao {
	/*
	 * 查询当前用户的地址信息
	 * 
	 */
	public List<Address> findCurrent(Integer uid); 
	
	public Integer insert(Address address);
	
	public Integer update(Address address);
	
	public Integer updateFlag(Address address);

}
