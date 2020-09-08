package com.zyl.flowershop.controller;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.ResponseJson;

public interface IFlowerController {

	public ResponseJson findAll();

	public ResponseJson find(Flower flower);

	public ResponseJson find(Integer fid);

	public ResponseJson update(Flower flower);

	/**
	 * 上传商品描述中的图片
	 * 
	 * @param file
	 * @return
	 */
	public Map<String, Object> uploadImage(MultipartFile file);

	public ResponseJson insert(MultipartFile[] files, String fname, String description, String flowerLan,
			String deliveryDesc, Double price, String sale, String intro, String pack, Integer sid, Integer tid);

}
