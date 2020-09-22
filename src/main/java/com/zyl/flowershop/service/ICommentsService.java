package com.zyl.flowershop.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Comments;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICommentsService {
	public	ResponseJson insert(MultipartFile file, Comments comments, HttpSession session);
	
	public ResponseJson findByFid(Integer fid);

	public 	ResponseJson findByUid(Integer uid);




}
