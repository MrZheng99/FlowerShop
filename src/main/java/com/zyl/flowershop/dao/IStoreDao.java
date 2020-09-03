package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Store;

@Repository
public interface IStoreDao {
	public List<Store> findAll();

	public List<Store> find(Integer fid);

	public Integer insert(Store store);

	public Integer update(Store store);

}
