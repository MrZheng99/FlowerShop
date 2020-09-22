package com.zyl.flowershop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyl.flowershop.entity.Comments;

@Repository
public interface ICommentsDao {
	public Integer insert(Comments comments);
	
	public List<Comments> findByFid(Integer fid);
	
	public List<Comments> findByUid(Integer uid);

}
