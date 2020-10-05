package com.zyl.flowershop.controller;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Advertisement;
import com.zyl.flowershop.entity.ResponseJson;

public interface IAdvertisementController {
	public ResponseJson findAll();

	public ResponseJson insert(MultipartFile file, String position, String url);

	public ResponseJson update(Advertisement advertisement);

}
