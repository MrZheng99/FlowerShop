package com.zyl.flowershop.service;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Advertisement;
import com.zyl.flowershop.entity.ResponseJson;

public interface IAdvertisementService {

	public ResponseJson findAll();

	public ResponseJson insert(MultipartFile file, String url, String position);

	public ResponseJson update(Advertisement advertisement);

}
