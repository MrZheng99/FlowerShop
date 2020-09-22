package com.zyl.flowershop.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyl.flowershop.controller.ICommentsController;
import com.zyl.flowershop.entity.Comments;
import com.zyl.flowershop.entity.ResponseJson;
import com.zyl.flowershop.service.impl.CommentsService;

@RestController
@RequestMapping("/comments")
public class CommentsController implements ICommentsController {
	@Autowired
	CommentsService commentsService;

	@RequestMapping("/insert")
	@Override
	public ResponseJson insert(@RequestParam("pics") MultipartFile file,@RequestParam String level,
		@RequestParam String details,@RequestParam Integer fid,HttpSession session) {
		Comments comments = new Comments();
		comments.setLevel(level);
		comments.setDetails(details);
		comments.setFid(fid);
		return commentsService.insert(file, comments,session);
	}
	
	@RequestMapping("/findByUid")
	@Override
	public ResponseJson findByUid(@RequestParam Integer uid) {
		return commentsService.findByUid(uid);
	}
	@RequestMapping("/findByFid")
	@Override
	public ResponseJson findByFid(@RequestParam Integer fid) {
		return commentsService.findByFid(fid);
	}
}
