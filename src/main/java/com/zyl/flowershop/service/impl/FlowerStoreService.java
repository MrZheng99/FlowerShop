package com.zyl.flowershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.flowershop.dao.IStoreDao;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.Store;
import com.zyl.flowershop.service.IFlowerStoreService;

public class FlowerStoreService implements IFlowerStoreService {
	@Autowired
	IStoreDao flowerDao;

	@Override
	public ResponseJson findAll() {
		List<Store> listStore;
		try {
			listStore = flowerDao.findAll();
			return new ResponseJson(200, "获取成功", listStore, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson find(Store store) {
		List<Store> listStore;
		try {
			listStore = flowerDao.find(store);
			return new ResponseJson(200, "获取成功", listStore, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(Store store) {
		Integer row = 0;
		try {
			row = flowerDao.update(store);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson insert(Store store) {
		Integer row = 0;
		try {
			row = flowerDao.insert(store);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

}
