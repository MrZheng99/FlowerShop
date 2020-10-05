package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.IAdvertisementDao;
import com.zyl.flowershop.entity.Advertisement;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IAdvertisementService;
import com.zyl.flowershop.util.UploadImg;

@Service
public class AdvertisementService implements IAdvertisementService {
	@Autowired
	IAdvertisementDao advertisementDao;
	@Autowired
	UploadImg uploadImg;
	@Value("${file.advertisement.path}")
	private String path;
	@Value("${file.advertisement.uploadPath}")
	private String uploadPath;

	@Override
	public ResponseJson findAll() {
		List<Advertisement> listAdvertisement;
		try {
			listAdvertisement = advertisementDao.findAll();
			return new ResponseJson(200, "获取广告信息成功", listAdvertisement, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取广告信息失败", null, false);
		}
	}

	@Override
	public ResponseJson insert(MultipartFile file, String url, String position) {
		if (file.isEmpty())
			return new ResponseJson(200, "添加失败,图片不能为空", null, false);
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "添加失败,格式不正确", null, false);
		String advImg;
		try {
			advImg = path + uploadImg.uploadWaterLogoImg(file, uploadPath);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseJson(500, "添加失败", null, false);
		}
		Advertisement advertisement = new Advertisement();
		advertisement.setPosition(position);
		advertisement.setUrl(url);
		advertisement.setAdImg(advImg);
		Integer row = advertisementDao.insert(advertisement);
		if (row > 0)
			return new ResponseJson(200, "添加成功", row, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

	@Override
	public ResponseJson update(Advertisement advertisement) {
		Integer row = 0;
		try {
			row = advertisementDao.update(advertisement);
			if (row > 0)
				return new ResponseJson(200, "修改广告信息成功", row, true);
			return new ResponseJson(200, "修改广告信息失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改广告信息失败", -1, false);
		}
	}

}
