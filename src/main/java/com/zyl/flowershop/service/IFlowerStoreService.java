package com.zyl.flowershop.service;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.Store;

public interface IFlowerStoreService {
	public ResponseJson findAll();

	public ResponseJson find(Store store);

	public ResponseJson update(Store store);

	public ResponseJson insert(MultipartFile file, String color, String size, String num, Integer fid);



}
