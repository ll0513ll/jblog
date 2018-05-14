package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVo userVo) {
		
		sqlSession.insert("blog.insert",userVo);
	}
	
	public BlogVo getblog(String id) {

		return sqlSession.selectOne("blog.getblog", id);
	}
	
	public String serchId(String id) {
		
		return sqlSession.selectOne("blog.serchId",id);
	}
	
	public void blogUpdate(Map map) {
		
		System.out.println("사진수정 다오");
		sqlSession.update("blog.blogUpdate",map);
	}
	
}
