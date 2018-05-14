package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	public List<PostVo> getPostList(int cateNo){
		return postDao.getPostList(cateNo);
	}
	
	public void postUpload(PostVo postVo) {

		postDao.postUpload(postVo);
	}
	
	public PostVo getPostOne(int postNo) {
		
		return postDao.getPostOne(postNo);
	}

}
