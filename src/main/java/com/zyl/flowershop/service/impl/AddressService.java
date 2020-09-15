package com.zyl.flowershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyl.flowershop.dao.IAddressDao;
import com.zyl.flowershop.entity.Address;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAddressService;

@Service
public class AddressService implements IAddressService{
	@Autowired
	IAddressDao addressDao;

	@Override
	public ResponseJson findCurrent(Integer uid) {
		List<Address> listAddress;
		try {
			listAddress =addressDao.findCurrent(uid);
			return new ResponseJson(200, "获取地址信息成功", listAddress, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取地址信息失败", null, false);
		}
	}
	@Override
	public ResponseJson insert(Address address) {
		Integer row =0;
		try {
			row = addressDao.insert(address);
			if(row>0) 
				return new ResponseJson(200, "插入地址信息成功", row, true);
			return new ResponseJson(200, "插入地址信息失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "插入地址信息失败", -1, false);
		}
	}
	@Override
	public ResponseJson update(Address address) {
		Integer row =0;
		try {
			row = addressDao.update(address);
			if(row>0) 
				return new ResponseJson(200, "更新地址信息成功", row, true);
			return new ResponseJson(200, "更新地址信息失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "更新地址信息失败", -1, false);
		}
	}
	
	@Override
	public ResponseJson updateFlag(Address address) {
		Integer row =0;
		try {
			row = addressDao.updateFlag(address);
			if(row>0) 
				return new ResponseJson(200, "修改默认地址成功", row, true);
			return new ResponseJson(200, "修改默认地址失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改默认地址失败", -1, false);
		}
	}
}
