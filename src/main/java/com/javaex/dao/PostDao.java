package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PostVo> getPostList(int cateNo){
		return sqlSession.selectList("blog.getList",cateNo);
	}
	
	public void postUpload(PostVo postVo) {

		sqlSession.insert("blog.insertPost", postVo);
	}

	public int getPostTime(int cateNo) {

		return sqlSession.selectOne("blog.getPostTime", cateNo);

	}

}