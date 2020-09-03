package com.zyl.flowershop.service;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerService {
	public ResponseJson findAll();

	public ResponseJson find(Flower flower);

	public ResponseJson update(Flower flower);

	public ResponseJson insert(MultipartFile[] files, String fname, String description, String flowerLan,
			String deliveryDesc, Double price, String sale, Integer sid, Integer tid);

	public ResponseJson uploadImage(MultipartFile file);
}
