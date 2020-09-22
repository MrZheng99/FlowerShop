package com.zyl.flowershop.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.dao.ICommentsDao;
import com.zyl.flowershop.entity.Comments;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.entity.User;
import com.zyl.flowershop.service.ICommentsService;
import com.zyl.flowershop.util.SessionKey;
import com.zyl.flowershop.util.UploadImg;

@Service
public class CommentsService implements ICommentsService{
	@Autowired
	ICommentsDao commentsDao;
	@Autowired
	UploadImg uploadImg;
	
	@Value("${file.comments.path}")
	private String path;
	@Value("${file.comments.uploadPath}")
	private String uploadPath;
	
	@Override
	public ResponseJson insert(MultipartFile file,Comments comments, HttpSession session) {
		if (!(file.getContentType().indexOf("image") >= 0))
			return new ResponseJson(200, "评价失败,图片格式不正确", null, false);
		String fileName;
		Map<String, Object> rs = new HashMap<String, Object>();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			comments.setCdate(formatter.format(date));
			Object userinfo =session.getAttribute(SessionKey.CURRENT_USER);
			User user = (User) userinfo;
			Integer uid = user.getUid();
			fileName = uploadImg.uploadImage(file, uploadPath);
			comments.setComImg(path + fileName);
			comments.setUid(uid);
			System.out.println(comments);
			rs.put("fileName", fileName);
			rs.put("upload", path + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer row = commentsDao.insert(comments);
			if (row > 0) 
				return new ResponseJson(200, "评价成功", rs, true);
			
			return new ResponseJson(500, "评价失败", null, false);
			
	}
	
	@Override
	public ResponseJson findByFid(Integer fid) {
		List<Comments> listComments;
		try {
			listComments = commentsDao.findByFid(fid);
			return new ResponseJson(200, "获取成功", listComments, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}
	
	@Override
	public ResponseJson findByUid(Integer uid) {
		List<Comments> listComments;
		try {
			listComments = commentsDao.findByUid(uid);
			return new ResponseJson(200, "获取成功", listComments, true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(500, "获取失败", null, false);
		}
	}
}
