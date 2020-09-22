package com.zyl.flowershop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.entity.Comments;
import com.zyl.flowershop.entity.ResponseJson;

public interface ICommentsController {
	/**
	 * 插入评论
	 * 
	 * @return
	 */
	public ResponseJson insert(MultipartFile file, String level, String details, Integer fid, HttpSession session);
	
	/**
	 * 按会员编号查询评论
	 * 
	 */
	public ResponseJson findByUid(Integer uid);
	
	/**
	 * 按鲜花编号查询评论
	 * 
	 */
	public ResponseJson findByFid(Integer fid);

	

	


}
