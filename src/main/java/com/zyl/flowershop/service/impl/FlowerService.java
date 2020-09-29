package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.IFlowerDao;
import com.zyl.flowershop.entity.Flower;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.IFlowerService;
import com.zyl.flowershop.util.LucenceUtil;
import com.zyl.flowershop.util.UploadImg;

@Service
public class FlowerService implements IFlowerService {
	@Autowired
	IFlowerDao flowerDao;
	@Autowired
	UploadImg uploadImg;
	@Value("${file.flower.path}")
	private String path;
	@Value("${file.flower.uploadPath}")
	private String uploadPath;

	@Override
	public ResponseJson findAll() {
		List<Flower> listFlower;
		try {
			listFlower = flowerDao.findAll();
			return new ResponseJson(200, "获取成功", listFlower, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson find(Flower flower) {
		List<Flower> listFlower;
		try {
			listFlower = flowerDao.find(flower);
			return new ResponseJson(200, "获取成功", listFlower, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson find(Integer fid) {
		List<Flower> listFlower;
		try {
			Flower flower = new Flower();
			flower.setFid(fid);
			listFlower = flowerDao.findByFid(flower);
			return new ResponseJson(200, "获取成功", listFlower, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	@Override
	public ResponseJson update(Flower flower) {
		Integer row = 0;
		try {
			row = flowerDao.update(flower);
			if (row > 0)
				return new ResponseJson(200, "修改成功", row, true);
			return new ResponseJson(200, "修改失败", -1, false);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return new ResponseJson(500, "修改失败", -1, false);
		}
	}

	@Override
	public Map<String, Object> uploadImage(MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> rs = new HashMap<String, Object>();
		String fileName;
		try {
			fileName = uploadImg.uploadWaterLogoImg(file, uploadPath);
			rs.put("fileName", fileName);
			rs.put("upload", path + fileName);
		} catch (IOException e) {
			e.printStackTrace();

		}
		String url = (String) rs.get("upload");
		if (rs != null) {
			map.put("fileName", rs.get("fileName"));
			map.put("url", url);
			map.put("uploaded", 1);
		}
		return map;

	}

	@Override
	public ResponseJson insert(MultipartFile[] files, String fname, String description, String flowerLan,
			String deliveryDesc, Double price, String sale, Integer store, String intro, String pack, Integer sid,
			Integer tid) {
		List<String> listImage = new ArrayList<String>();
		if (files.length > 0) {
			try {
				for (MultipartFile file : files) {
					if (!(file.getContentType().indexOf("image") >= 0)) {
						return new ResponseJson(200, "添加失败,图片格式不正确", null, false);
					}
					listImage.add(path + uploadImg.uploadWaterLogoImg(file, uploadPath));
				}
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseJson(500, "添加失败", null, false);
			}
		}

		String flowerImg;
		if (listImage.size() > 0)
			flowerImg = String.join(",", listImage);
		else
			flowerImg = "images\\zanwu.jpg";
		Flower flower = new Flower(fname, description, flowerLan, deliveryDesc, price, intro, pack, sale, store, sid,
				tid, flowerImg);
		Integer row = flowerDao.insert(flower);
		if (row > 0)
			return new ResponseJson(200, "添加成功", row, true);
		return new ResponseJson(200, "添加失败", null, false);
	}

	@Override
	public ResponseJson findIdAndName() {
		List<Flower> listFlower;
		try {
			listFlower = flowerDao.findIdAndName();
			return new ResponseJson(200, "获取成功", listFlower, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}

	/**
	 * lucence分词搜索
	 * 
	 * @param goodsName
	 * @param pageNum
	 * @return
	 */
	@Override
	public ResponseJson myLucence(String goodsName, Integer pageNum) {
		initLu();
		List<Document> docs;
		if (pageNum == null) {
			docs = lu.search(new String[] { "id", "name", "description", "price", "images" }, goodsName, 8, 0, 100);
		} else {
			docs = lu.search(new String[] { "id", "name", "description", "price", "images" }, goodsName, 8, pageNum,
					100);
		}
		if (docs.size() <= 0) {
			return new ResponseJson(200, "暂无结果", null, false);
		}
		// 取值
		Flower flower = null;
		List<Flower> listFlowers = new ArrayList<>();
		for (Document doc : docs) {
			flower = new Flower();
			flower.setFid(Integer.valueOf(doc.get("id")));
			flower.setFname(doc.get("name"));
			flower.setPrice(Double.valueOf(doc.get("price")));
			flower.setFlowerImg(doc.get("images"));
			listFlowers.add(flower);
		}
		return new ResponseJson(200, "数据获取成功", listFlowers, true);
	}

	/**
	 * 获取记录总条数
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public ResponseJson myLucenceNumber(String name) {
		initLu();
		return new ResponseJson(200, null,
				lu.getNumByName(new String[] { "id", "name", "description", "price", "images" }, name, 100), true);
	}

	/**
	 * 先查询字典是否初始化 如果没有则初始化
	 */
	public static LucenceUtil lu = null;

	private synchronized void initLu() {
		if (lu == null) {
			lu = new LucenceUtil("Goods", "id", new String[] { "name", "description", "price", "images" });
			// 查询数据库所有商品
			List<Flower> rs = flowerDao.findAll();
			// 清空字典
			lu.deleteAll();
			// 添加
			lu.add(Flower.class, rs);
			System.out.println("初始化库");
		}
	}

}
