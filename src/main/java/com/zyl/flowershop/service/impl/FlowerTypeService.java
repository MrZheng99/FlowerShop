package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.IFlowerTypeDao;
import com.zyl.flowershop.entity.FlowerType;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerTypeService;
import com.zyl.flowershop.util.UploadImg;

@Service
public class FlowerTypeService implements IFlowerTypeService {
	@Autowired
	IFlowerTypeDao flowerTypeDao;
	@Autowired
	UploadImg uploadImg;

	@Override
	public ResponseJson findAll() {
		List<FlowerType> listFlowerType;
		try {
			listFlowerType = flowerTypeDao.findAll();
			return new ResponseJson(200, "获取成功", listFlowerType, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(FlowerType flowerType) {
		Integer row = 0;
		try {
			row = flowerTypeDao.update(flowerType);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public ResponseJson insert(MultipartFile file, String tname) {
		if (file.isEmpty())
			return new ResponseJson(200, "添加失败,头像不能为空", null, false);
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "添加失败,头像格式不正确", null, false);
		String typeImg;
		try {
			typeImg = "fileUpload\\types\\" + uploadImg.uploadWaterLogoImg(file, "\\images\\types");
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseJson(500, "添加失败", null, false);
		}
		FlowerType flowerType = new FlowerType();
		flowerType.setTname(tname);
		flowerType.setTypeImg(typeImg);
		Integer row = flowerTypeDao.insert(flowerType);
		if (row > 0)
			return new ResponseJson(200, "添加成功", row, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

}
