package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Advertisement;

@Repository
public interface IAdvertisementDao {

	public List<Advertisement> findAll();

	public Integer insert(Advertisement advertisement);

	public Integer update(Advertisement advertisement);

}
