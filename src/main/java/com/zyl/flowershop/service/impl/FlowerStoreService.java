package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.IStoreDao;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.Store;
import com.zyl.flowershop.service.IFlowerStoreService;
import com.zyl.flowershop.util.UploadImg;

@Service
public class FlowerStoreService implements IFlowerStoreService {
	@Autowired
	IStoreDao flowerDao;
	@Autowired
	UploadImg uploadImg;
	@Value("${file.store.path}")
	private String path;
	@Value("${file.store.uploadPath}")
	private String uploadPath;
	
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
	public ResponseJson insert(MultipartFile file,String color, String size, String num, Integer fid ) {
		if (file.isEmpty())
			return new ResponseJson(200, "添加失败,图片不能为空", null, false);
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "添加失败,格式不正确", null, false);
		String storeImg;
		try {
			storeImg = path + uploadImg.uploadWaterLogoImg(file, uploadPath);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseJson(500, "添加失败", null, false);
		}
		Integer row = 0;
		Store store = new Store();
		store.setColor(color);
		store.setFid(fid);
		store.setNum(num);
		store.setSize(size);
		store.setImg(storeImg);
		try {
			row = flowerDao.insert(store);
			if (row > 0)
				return new ResponseJson(200, "添加成功", row, true);
			return new ResponseJson(200, "添加失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "添加失败", -1, false);
		}
	}

}
