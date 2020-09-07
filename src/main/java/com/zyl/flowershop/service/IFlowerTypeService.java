package com.zyl.flowershop.service;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.FlowerType;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerTypeService {
	public ResponseJson findAll();

	public ResponseJson update(FlowerType flowerType);

	public ResponseJson insert(MultipartFile file, String tname, String description);

	/***
	 * 查询可用类别
	 * 
	 * @return
	 */
	public ResponseJson find();

}
