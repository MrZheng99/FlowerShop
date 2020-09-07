package com.zyl.flowershop.controller;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.FlowerType;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerTypeController {
	public ResponseJson findAll();

	public ResponseJson update(FlowerType flowerType);

	public ResponseJson find();

	public ResponseJson insert(MultipartFile file, String tname, String description);
}
